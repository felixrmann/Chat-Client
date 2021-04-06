package Client.Util;

import Client.DataHandler.UserLoader;
import Client.Model.Chat;
import Client.ServerHandler.ChatService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Vector;

public class ChatUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(ChatUtil.class);

    public static Vector<Chat> loadAllChats(){
        try {
            Vector<Chat> allChats = new Vector<>();

            UserLoader userLoader = new UserLoader();
            JSONObject jsonObject = new JSONObject(ChatService.loadChats(userLoader.loadUser().getuserToken()).body().string());



            return allChats;
        } catch (JSONException | IOException e) {
            LOGGER.error("Error occurred in ChatUtil, loadAllChats ", e);
        }
        return null;
    }

}
