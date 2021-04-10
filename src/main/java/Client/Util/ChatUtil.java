package Client.Util;

import Client.DataHandler.UserLoader;
import Client.Model.Chat;
import Client.Model.Message;
import Client.Model.User;
import Client.ServerHandler.ChatService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

/**
 * The class Chat Util
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public class ChatUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(ChatUtil.class);

    /**
     * Load all chats vector.
     *
     * @return the vector
     */
    public static Vector<Chat> loadAllChats(){
        try {
            Vector<Chat> allChats = new Vector<>();

            UserLoader userLoader = new UserLoader();
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull(ChatService.loadChats(userLoader.loadUser().getuserToken()).body()).string());

            JSONArray array = jsonObject.getJSONArray("chats");

            for (int i = 0; i < array.length(); i++) {
                User author = null;

                JSONObject chatObj = array.getJSONObject(i);
                JSONObject messageObj = chatObj.getJSONObject("message");

                if (messageObj.has("author")){
                    JSONObject authorObj = messageObj.getJSONObject("author");
                    author = new User(authorObj.optString("id"), authorObj.optString("username"), authorObj.optString("avatar"));
                }

                Message lastMessage = new Message(messageObj.optString("id"), messageObj.optString("content"), messageObj.optString("date"), author);
                allChats.add(new Chat(chatObj.optString("id"), chatObj.optString("name"), chatObj.optInt("type"), chatObj.optString("imagePath"), lastMessage));
            }

            return allChats;
        } catch (JSONException | IOException e) {
            LOGGER.error("Error occurred in ChatUtil, loadAllChats ", e);
        }
        return null;
    }

    /**
     * Load all chats vector.
     *
     * @return the vector
     */
    public static Vector<Chat> loadAllChats(String responseString){
        try {
            Vector<Chat> allChats = new Vector<>();

            JSONObject jsonObject = new JSONObject(responseString);

            JSONArray array = jsonObject.getJSONArray("chats");

            for (int i = 0; i < array.length(); i++) {
                User author = null;

                JSONObject chatObj = array.getJSONObject(i);
                JSONObject messageObj = chatObj.getJSONObject("message");

                if (messageObj.has("author")){
                    JSONObject authorObj = messageObj.getJSONObject("author");
                    author = new User(authorObj.optString("id"), authorObj.optString("username"), authorObj.optString("avatar"));
                }

                Message lastMessage = new Message(messageObj.optString("id"), messageObj.optString("content"), messageObj.optString("date"), author);
                allChats.add(new Chat(chatObj.optString("id"), chatObj.optString("name"), chatObj.optInt("type"), chatObj.optString("imagePath"), lastMessage));
            }

            return allChats;
        } catch (JSONException e) {
            LOGGER.error("Error occurred in ChatUtil, loadAllChats ", e);
        }
        return null;
    }
}
