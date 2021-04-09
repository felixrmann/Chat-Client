package Client.DataHandler;

import Client.Model.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
 * @since 2021-April-01
 */

public class ConfigLoader {

    private final static String fileName = "config.json";
    private final static String filePath = "src\\main\\resources\\DATA\\" + fileName;
    private static Gson gson = new Gson();

    /**
     * Loads the Data and saves them into an Object
     * @return Config Object
     */
    public static Config loadConfig(){
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

    /**
     * saves the config object in the config.json file
     * @param config
     */
    public static void saveConfig(Config config){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("mode", config.getMode());
            map.put("baseURL", config.getBaseURL());
            map.put("windowHeight", String.valueOf(config.getWindowHeight()));
            map.put("windowWidth", String.valueOf(config.getWindowWidth()));
            map.put("windowPosY", String.valueOf(config.getWindowPosY()));
            map.put("windowPosX", String.valueOf(config.getWindowPosX()));

            Writer writer = new FileWriter(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(map, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
