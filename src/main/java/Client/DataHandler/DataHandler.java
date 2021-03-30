package Client.DataHandler;

import Client.Model.LoadUser;
import Client.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class DataHandler {

    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadAllUsers();
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(DataHandler.class);
    private final static String fileName = "users.json";
    private final static String filePath = "src\\main\\resources\\" + fileName;

    /**
     constructor
     searches for File and if it doesn't exist create the file
     */
    private DataHandler() {
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
     * converts a String it gets from the loadFileString method
     * to a vector with all Users
     * @return Vector with JsonObjects
     */
    public Vector<User> loadAllUsers(){
        Gson gson = new Gson();
        Vector<User> allUsers = new Vector<>();

        Type userList = new TypeToken<ArrayList<LoadUser>>(){}.getType();

        ArrayList<LoadUser> userArrayList = gson.fromJson(loadFileString(), userList);

        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i).getUserName());
            System.out.println(userArrayList.get(i).getUserMail());
            System.out.println(userArrayList.get(i).getUserPassword());
            System.out.println(userArrayList.get(i).getUserToken());
        }

        return allUsers;
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

}