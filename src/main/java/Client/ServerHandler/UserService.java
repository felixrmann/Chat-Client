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

    public static Response loginUser(String username, String password){
        FormBody data = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(ConfigLoader.loadConfig().getBaseURL() + "users/login")
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
                .url(ConfigLoader.loadConfig().getBaseURL() + "users/register")
                .post(data)
                .build();

        return Util.executeServerRequest(request);
    }

}
