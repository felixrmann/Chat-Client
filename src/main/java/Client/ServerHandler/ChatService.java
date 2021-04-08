package Client.ServerHandler;

import Client.DataHandler.ConfigLoader;
import Client.DataHandler.UserLoader;
import Client.Model.ChatType;
import Client.Util.Util;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-04
 */

public class ChatService {

    private static final String BASE_URL = ConfigLoader.loadConfig().getBaseURL() + "chats";

    public static Response loadChats(String userToken){
        Request request = new Request.Builder()
                .url(BASE_URL)
                .header("Authorization", userToken)
                .build();

        return Util.executeServerRequest(request);
    }

    public static Response createChat(String chatName, ChatType chatType){
        UserLoader userLoader = new UserLoader();

        RequestBody bodyParams = new FormBody.Builder()
                .add("chat_name", chatName)
                .add("chat_type", chatType.getChatType())
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .header("Authorization", userLoader.loadUser().getuserToken())
                .post(bodyParams)
                .build();

        return Util.executeServerRequest(request);
    }
}
