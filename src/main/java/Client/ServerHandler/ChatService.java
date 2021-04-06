package Client.ServerHandler;

import Client.DataHandler.ConfigLoader;
import Client.Util.Util;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-04
 */

public class ChatService {

    public static Response loadChats(String userToken){
        Request request = new Request.Builder()
                .url(ConfigLoader.loadConfig().getBaseURL() + "chats")
                .header("Authorization", userToken)
                .build();

        return Util.executeServerRequest(request);
    }

}
