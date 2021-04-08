package Client.ServerHandler;

import Client.DataHandler.ConfigLoader;
import Client.Util.Util;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-02
 */

public class UserService {

    private static final String BASE_URL = ConfigLoader.loadConfig().getBaseURL() + "users";

    public static Response loginUser(String username, String password){
        FormBody data = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/login")
                .post(data)
                .build();

        return Util.executeServerRequest(request);
    }

    public static Response registerUser(String userName, String userMail, String userPassword, String userConfPassword){
        FormBody data = new FormBody.Builder()
                .add("username", userName)
                .add("mail", userMail)
                .add("password", userPassword)
                .add("confirm_password", userConfPassword)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/register")
                .post(data)
                .build();

        return Util.executeServerRequest(request);
    }

    public static Response getUserDataByToken(String userToken){
        Request request = new Request.Builder()
                .url(BASE_URL + "/me")
                .header("Authorization", userToken)
                .build();

        return Util.executeServerRequest(request);
    }

}
