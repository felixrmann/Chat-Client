package Client.Controller;

import Client.DataHandler.UserLoader;
import Client.ServerHandler.UserService;
import Client.Util.Util;
import Client.View.ChatView;
import Client.View.LoginView;
import Client.View.MainFrame;
import Client.View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import okhttp3.Response;

import java.io.IOException;
import java.util.Vector;

/**
 * The type Login controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 -März-31
 */
public class LoginController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private LoginView loginView;
    private Vector<Button> buttons;
    private Vector<TextField> fields;

    /**
     * Instantiates a new Login controller.
     *
     * @param mainFrame the main frame
     * @param loginView the login view
     * @param buttons   the buttons
     * @param fields    the fields
     */
    public LoginController(MainFrame mainFrame, LoginView loginView, Vector<Button> buttons, Vector<TextField> fields){
        this.mainFrame = mainFrame;
        this.loginView = loginView;
        this.buttons = buttons;
        this.fields = fields;
    }

    /**
     * handles button presses
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if (buttons.get(0).equals(event.getSource())){
            handleButton1();
        } else if (buttons.get(1).equals(event.getSource())){
            mainFrame.setNewScene(new RegisterView(mainFrame), 400, 450);
        } else if (buttons.get(1).equals(event.getSource())){
            //TODO open password reset window (not in version 1)
        }
    }

    /**
     * handles sign in button press
     */
    private void handleButton1(){
        if (!fields.get(0).getText().equals("") && !fields.get(1).getText().equals("")){

            Response response = UserService.loginUser(fields.get(0).getText(), fields.get(1).getText());

            if (response != null) {
                switch (response.code()){
                    case 200 -> {
                        try {
                            UserLoader userLoader = new UserLoader();
                            userLoader.saveUser(Util.extractToken(response.body().string()));
                            mainFrame.setNewScene(new ChatView(mainFrame), 800, 800);
                            loginView.setErrorMsgLabel("");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    case 400, 401 -> {
                        try {
                            loginView.setErrorMsgLabel(Util.extractErrorMsg(response.body().string()).getErrorMsg());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        } else {
            if (fields.get(0).getText().equals("")){
                loginView.setErrorMsgLabel("No username / email provided");
            } else {
                loginView.setErrorMsgLabel("No password provided");
            }
        }
    }
}
