package Client.Controller;

import Client.DataHandler.UserLoader;
import Client.ServerHandler.UserService;
import Client.ServerHandler.Util;
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
 * The type Register controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 -April-02
 */
public class RegisterController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private RegisterView registerView;
    private Vector<Button> buttons;
    private Vector<TextField> fields;

    /**
     * Instantiates a new Register controller.
     *
     * @param mainFrame    the main frame
     * @param registerView the register view
     * @param buttons      the buttons
     * @param fields       the fields
     */
    public RegisterController(MainFrame mainFrame, RegisterView registerView, Vector<Button> buttons, Vector<TextField> fields){
        this.mainFrame = mainFrame;
        this.registerView = registerView;
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
            mainFrame.setNewScene(new LoginView(mainFrame), 720, 400);
        }
    }

    /**
     * handles register button press
     */
    private void handleButton1() {
        if (allFieldsFilled() == 0){
            if (fields.get(2).getText().equals(fields.get(3).getText())){

                Response response = UserService.registerUser(fields.get(0).getText(), fields.get(1).getText(), fields.get(2).getText(), fields.get(3).getText());

                if (response != null) {
                    switch (response.code()){
                        case 200 -> {
                            try {
                                UserLoader userLoader = new UserLoader();
                                userLoader.saveUser(Util.extractToken(response.body().string()));
                                mainFrame.setNewScene(new ChatView(mainFrame), 800, 800);
                                registerView.setErrorMsgLabel("");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        case 400, 401, 500 -> {
                            try {
                                registerView.setErrorMsgLabel(Util.extractErrorMsg(response.body().string()).getErrorMsg());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                registerView.setErrorMsgLabel("Passwords do not match");
            }
        } else {
            switch (allFieldsFilled()){
                case 1 -> registerView.setErrorMsgLabel("Username not filled in");
                case 2 -> registerView.setErrorMsgLabel("Email not filled in");
                case 3 -> registerView.setErrorMsgLabel("Password not filled in");
                case 4 -> registerView.setErrorMsgLabel("Confirm password not filled in");
                default -> registerView.setErrorMsgLabel("");
            }
        }
    }

    /**
     * returns the empty textfield
     * @return empty field
     */
    private int allFieldsFilled(){
        if (fields.get(0).getText().equals("")) return  1;
        else if (fields.get(1).getText().equals("")) return 2;
        else if (fields.get(2).getText().equals("")) return 3;
        else if (fields.get(3).getText().equals("")) return 4;
        else return 0;
    }
}
