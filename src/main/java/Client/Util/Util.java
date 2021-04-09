package Client.Util;

import Client.DataHandler.ConfigLoader;
import Client.Model.Config;
import Client.Model.LoadUser;
import Client.Model.OverErrorMsg;
import com.google.gson.Gson;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * The class Util
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 02
 */

public class Util {

    private static OkHttpClient client = new OkHttpClient();
    private static Call call;
    private static Gson gson = new Gson();
    private static Config config = ConfigLoader.loadConfig();

    /**
     * executes server requests
     * @param request request
     * @return response
     */
    public static Response executeServerRequest(Request request){
        try {
            call = client.newCall(request);
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * saves errorMsg in Object
     * @param responseString responseString
     * @return ErrorMsg
     */
    public static OverErrorMsg extractErrorMsg(String responseString){
        return gson.fromJson(responseString, OverErrorMsg.class);
    }

    /**
     * extracts the token from json
     * @param responseString responseString
     * @return userToken
     */
    public static String extractToken(String responseString){
        return gson.fromJson(responseString, LoadUser.class).getToken();
    }

    /**
     * loads the stylesheet according to the theme
     * @param scene scene
     */
    public static void loadStylesheet(Scene scene){
        if (config.getMode().equals("light")){
            scene.getStylesheets().add("lightStyle.css");
        } else {
            scene.getStylesheets().add("darkStyle.css");
        }
    }

    /**
     * sets color of nodes
     * @param node node
     */
    public static void setColor(Node node){
        if (config.getMode().equals("dark")){
            node.setStyle("-fx-text-fill: LightGray");
        } else {
            node.setStyle("-fx-text-fill: '1A2636'");
        }
    }

    /**
     * sets colors of button
     * @param button button
     */
    public static void setButton(Button button){
        button.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'");
        button.setOnMouseEntered(mouseEvent -> button.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: 'A3E635'"));
        button.setOnMouseExited(mouseEvent -> button.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'"));
    }

    /**
     * sets theme of textField
     * @param textField textField
     */
    public static void setTextField(TextField textField){
        if (config.getMode().equals("dark")){
            textField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '374151'; -fx-text-inner-color: DarkGrey; -fx-background-color: '374151'");
        } else {
            textField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '9CA3AF'; -fx-text-inner-color: Black; -fx-background-color: '9CA3AF'");
        }
    }
}
