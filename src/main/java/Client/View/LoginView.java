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
    private final String fontPath = "file:src\\main\\resources\\Segoe_UI.ttf";

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
        mainGridPane.setStyle("-fx-border-color: black; -fx-background-color: white");

        setLoginPane();
        setRegisterPane();
    }

    private void setLoginPane() {
        BorderPane loginPane = new BorderPane();
        loginPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        loginPane.setPadding(new Insets(20,18,20,20));
        mainGridPane.add(loginPane, 0,0);

        signUpButton.setText("Sign Up");
        forgotPasswordButton.setText("I forgot my password");

        Label loginLabel = new Label();
        Label userNameLabel = new Label();
        Label passwordLabel = new Label();

        TextField userNameTextField = new TextField();
        TextField passwordTextField = new TextField();

        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Arial", 27));
        loginLabel.setPadding(new Insets(0,0,40,0));
        loginPane.setTop(loginLabel);

        GridPane userInputPane = new GridPane();
        loginPane.setCenter(userInputPane);

        userNameLabel.setText("Username / Mail");
        userNameLabel.setFont(new Font("Arial", 14));
        userNameLabel.setPadding(new Insets(0,0,5,0));
        userInputPane.add(userNameLabel, 0,0);

        userNameTextField.setPrefWidth(320);
        userNameTextField.setPrefHeight(35);
        userNameTextField.setFont(new Font("Arial", 20));
        userInputPane.add(userNameTextField, 0,1);

        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Arial", 14));
        passwordLabel.setPadding(new Insets(10,0,5,0));
        userInputPane.add(passwordLabel, 0,2);

        userInputPane.add(passwordTextField, 0,3);
        userInputPane.add(forgotPasswordButton, 0,4);

        loginPane.setBottom(forgotPasswordButton);
    }

    private void setRegisterPane() {
        BorderPane registerPane = new BorderPane();
        registerPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        registerPane.setPadding(new Insets(30,30,30,30));
        mainGridPane.add(registerPane, 1,0);

        createAccountButton.setText("Create New Account");

        Label registerLabel = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();

        registerLabel.setText("Register");
        registerLabel.setFont(new Font("Arial", 27));
        registerPane.setTop(registerLabel);

        GridPane registerInfoPane = new GridPane();
        registerPane.setCenter(registerInfoPane);

        label1.setText("Create an account to chat with your friends");
        registerInfoPane.add(label1, 0,0);
        label2.setText("You can:");
        registerInfoPane.add(label2, 0,1);
        label3.setText("Chat with your friends");
        registerInfoPane.add(label3, 0,2);
        label4.setText("Create group chats and chat with many friends");
        registerInfoPane.add(label4, 0,3);

        registerPane.setBottom(createAccountButton);
    }
}
