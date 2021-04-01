package Client.DataHandler;

import Client.Model.Config;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-01
 */

public class ConfigLoader {

    private final static String fileName = "config.json";
    private final static String filePath = "src\\main\\resources\\" + fileName;

    /**
     * Loads the Data and saves them into an Object
     * @return Config Object
     */
    public static Config loadConfig(){
        Gson gson = new Gson();

        return gson.fromJson(loadFileString(), Config.class);
    }

    /**
     load file content to String
     @return String
     */
    private static String loadFileString(){
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
