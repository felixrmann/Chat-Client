package Client.Util;

import Client.DataHandler.UserLoader;
import Client.Model.User;
import Client.ServerHandler.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserUtil.class);

    public static User loadUserData(){
        try {
            User userData = new User();

            UserLoader userLoader = new UserLoader();
            JSONObject jsonObject = new JSONObject(UserService.getUserDataByToken(userLoader.loadUser().getuserToken()).body().string());

            userData.setUserName(jsonObject.optString("username"));
            userData.setUserImagePath(jsonObject.optString("imagePath"));

            return userData;
        } catch (JSONException | IOException e){
            LOGGER.error("Error occurred in UserUtil, loadUserData ", e);
        }
        return null;
    }

}
