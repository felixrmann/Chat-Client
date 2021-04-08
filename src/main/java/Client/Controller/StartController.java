package Client.Controller;

import Client.DataHandler.ConfigLoader;
import Client.DataHandler.UserLoader;
import Client.Model.Config;
import Client.Model.User;
import Client.ServerHandler.ChatService;
import Client.View.ChatView;
import Client.View.LoginView;
import Client.View.MainFrame;
import okhttp3.Response;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-03
 */

public class StartController {

    private MainFrame mainFrame;

    public StartController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void setUpProject(){
        UserLoader userLoader = new UserLoader();
        User user = userLoader.loadUser();

        if (user.getuserToken() != null){
            Response response = ChatService.loadChats(user.getuserToken());
            if (response.code() == 200) {
                Config config = ConfigLoader.loadConfig();
                if (config.getWindowHeight() != 0 && config.getWindowWidth() != 0){
                    mainFrame.setNewScene(new ChatView(mainFrame), config.getWindowWidth(), config.getWindowHeight());
                } else {
                    mainFrame.setNewScene(new ChatView(mainFrame), 1000, 750);
                }
            } else {
                mainFrame.setNewScene(new LoginView(mainFrame), 720, 400);
            }
        } else {
            mainFrame.setNewScene(new LoginView(mainFrame), 720, 400);
        }
    }

}
