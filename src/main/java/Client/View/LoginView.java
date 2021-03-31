package Client.View;

import Client.Controller.LoginController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
        mainGridPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));

        setLoginPane();
        setRegisterPane();
    }

    private void setLoginPane() {
        BorderPane loginPane = new BorderPane();
        loginPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        loginPane.setPadding(new Insets(30,30,30,30));
        mainGridPane.add(loginPane, 1,1);

        signUpButton.setText("Sign Up");
        forgotPasswordButton.setText("I forgot my password");

        Label loginLabel = new Label();
        Label userNameLabel = new Label();
        Label passwordLabel = new Label();

        TextField userNameTextField = new TextField();
        TextField passwordTextField = new TextField();

        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Verdana", 30));
        loginPane.setTop(loginLabel);

        GridPane userInputPane = new GridPane();
        loginPane.setCenter(userInputPane);

        userNameLabel.setText("Username");
        userInputPane.add(userNameLabel, 0,0);
        userInputPane.add(userNameTextField, 0,1);
        passwordLabel.setText("Password");
        userInputPane.add(passwordLabel, 0,2);
        userInputPane.add(passwordTextField, 0,3);
        userInputPane.add(forgotPasswordButton, 0,4);

        loginPane.setBottom(forgotPasswordButton);
    }

    private void setRegisterPane() {

    }
}
