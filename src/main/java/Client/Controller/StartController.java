package Client.Controller;

import Client.DataHandler.ConfigLoader;
import Client.DataHandler.UserLoader;
import Client.Model.Chat;
import Client.Model.Config;
import Client.Model.User;
import Client.ServerHandler.ChatService;
import Client.Util.ChatUtil;
import Client.View.ChatView;
import Client.View.LoginView;
import Client.View.MainFrame;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

/**
 * The type Start Controller
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 03
 */
public class StartController {

    private final MainFrame mainFrame;

    /**
     * Instantiates a new Start controller.
     *
     * @param mainFrame the main frame
     */
    public StartController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    /**
     * Set up project.
     */
    public void setUpProject(){
        UserLoader userLoader = new UserLoader();
        User user = userLoader.loadUser();

        if (user.getuserToken() != null){
            Response response = ChatService.loadChats(user.getuserToken());
            if (response.code() == 200) {
                try {
                    Config config = ConfigLoader.loadConfig();
                    Vector<Chat> allChats = ChatUtil.loadAllChats(Objects.requireNonNull(response.body()).string());
                    if (config.getWindowHeight() != 0 && config.getWindowWidth() != 0){
                        mainFrame.setNewScene(new ChatView(mainFrame, allChats), config.getWindowWidth(), config.getWindowHeight(), false);
                    } else {
                        mainFrame.setNewScene(new ChatView(mainFrame, allChats), 1000, 750, true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                mainFrame.setNewScene(new LoginView(mainFrame), 720, 400, true);
            }
        } else {
            mainFrame.setNewScene(new LoginView(mainFrame), 720, 400, true);
        }
    }
}
