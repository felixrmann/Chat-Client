package Client.View;

import Client.Controller.LoginController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-26
 */

public class LoginView extends BorderPane {

    private MainFrame mainFrame;
    private LoginController loginController;
    private GridPane mainGridPane;
    private Vector<Button> buttons;
    private Button signUpButton, createAccountButton, forgotPasswordButton;

    public LoginView(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        init();

        createGridPane();

        setCenter(mainGridPane);
        setPadding(new Insets(30, 30, 30, 30));
    }

    private void init() {
        buttons = new Vector<>();
        loginController = new LoginController(mainFrame, buttons);
        mainGridPane = new GridPane();

        signUpButton = new Button();
        createAccountButton = new Button();
        forgotPasswordButton = new Button();

        buttons.add(signUpButton);
        buttons.add(createAccountButton);
        buttons.add(forgotPasswordButton);
    }

    private void createGridPane() {
        setLoginPane();
        setRegisterPane();
    }

    private void setLoginPane() {

    }

    private void setRegisterPane() {

    }
}
