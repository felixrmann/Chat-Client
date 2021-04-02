package Client.DataHandler;

import Client.Model.LoadUser;
import Client.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class UserLoader {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserLoader.class);
    private final static String fileName = "users.json";
    private final static String filePath = "src\\main\\resources\\DATA\\" + fileName;

    /**
     constructor
     searches for File and if it doesn't exist create the file
     */
    public UserLoader() {
        try {
            File userFile = new File(filePath);
            if (!userFile.exists()) {
                File newUserFile = new File(filePath);
                if (newUserFile.createNewFile()) {
                    LOGGER.info("File created");
                }
            } else {
                LOGGER.info("File exists");
            }
        } catch (IOException ex) {
            LOGGER.error("Error occurred", ex);
        }
    }

    /**
     * loads the user
     * @return User
     */
    public User loadUser(){
        Gson gson = new Gson();
        return gson.fromJson(loadFileString(), LoadUser.class).convertToUser();
    }

    /**
     load file content to String
     @return String
     */
    private String loadFileString(){
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * saves the user in json file
     * @param user
     */
    public void saveUser(User user){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("nameName", user.getUserName());
            map.put("userMail", user.getUserMail());
            map.put("userPassword", user.getUserPassword());
            map.put("userToken", user.getuserToken());

            Writer writer = new FileWriter(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(map, writer);
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Error loading File", e);
        }
    }
}