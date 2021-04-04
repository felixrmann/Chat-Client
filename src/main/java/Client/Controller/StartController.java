package Client.Controller;

import Client.DataHandler.UserLoader;
import Client.Model.User;
import Client.ServerHandler.ChatService;
import Client.View.ChatView;
import Client.View.LoginView;
import Client.View.MainFrame;
import Client.View.RegisterView;
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
                mainFrame.setNewScene(new ChatView(mainFrame), 800, 800);
                System.out.println("all good");
            } else {
                mainFrame.setNewScene(new LoginView(mainFrame), 720, 400);
                System.out.println("wrong token");
            }
        } else {
            mainFrame.setNewScene(new RegisterView(mainFrame), 400, 450);
            System.out.println("new user");
        }
    }

}
