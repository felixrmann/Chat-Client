package Client.View;

import Client.Controller.LoginController;
import Client.DataHandler.ConfigLoader;
import Client.Model.Config;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private final Config config = ConfigLoader.loadConfig();

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
        setLoginPane();
        setRegisterPane();
    }

    private void setLoginPane() {
        BorderPane loginPane = new BorderPane();
        loginPane.setPadding(new Insets(20,18,20,20));
        loginPane.setStyle("-fx-background-color: transparent");
        mainGridPane.add(loginPane, 0,0);

        Label loginLabel = new Label();
        Label userNameLabel = new Label();
        Label passwordLabel = new Label();

        TextField userNameTextField = new TextField();
        TextField passwordTextField = new TextField();

        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Arial", 27));
        setColor(loginLabel);
        loginLabel.setPadding(new Insets(0,0,40,0));
        loginPane.setTop(loginLabel);

        GridPane userInputPane = new GridPane();
        userInputPane.setStyle("-fx-background-color: transparent");
        loginPane.setCenter(userInputPane);

        userNameLabel.setText("Username / Mail");
        userNameLabel.setFont(new Font("Arial", 14));
        setColor(userNameLabel);
        userNameLabel.setPadding(new Insets(15,0,5,0));
        userInputPane.add(userNameLabel, 0,0);

        userNameTextField.setPrefWidth(320);
        userNameTextField.setPrefHeight(35);
        userNameTextField.setFont(new Font("Arial", 20));
        if (config.getMode().equals("dark")){
            userNameTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: D3D3D3; -fx-text-inner-color: DarkGrey");
        } else {
            userNameTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: D3D3D3; -fx-text-inner-color: Black");
        }
        userInputPane.add(userNameTextField, 0,1);

        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Arial", 14));
        setColor(passwordLabel);
        passwordLabel.setPadding(new Insets(15,0,5,0));
        userInputPane.add(passwordLabel, 0,2);

        passwordTextField.setPrefWidth(320);
        passwordTextField.setPrefHeight(35);
        passwordTextField.setFont(new Font("Arial", 20));
        if (config.getMode().equals("dark")){
            passwordTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: D3D3D3; -fx-text-inner-color: DarkGrey");
        } else {
            passwordTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: D3D3D3; -fx-text-inner-color: Black");
        }
        userInputPane.add(passwordTextField, 0,3);

        forgotPasswordButton.setText("I forgot my password");
        forgotPasswordButton.setStyle("-fx-background-color: transparent; -fx-text-fill: DarkBlue");
        forgotPasswordButton.setPadding(new Insets(10,0,40,0));
        userInputPane.add(forgotPasswordButton, 0,4);

        signUpButton.setText("Sign In");
        signUpButton.setMinHeight(35);
        signUpButton.setPrefHeight(35);
        signUpButton.setMaxHeight(35);
        signUpButton.setMinWidth(250);
        signUpButton.setPrefWidth(250);
        signUpButton.setMaxWidth(250);
        signUpButton.setOnMouseEntered(mouseEvent -> {
            signUpButton.setStyle("-fx-border-color: D3D3D3; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: Gainsboro");
        });
        signUpButton.setOnMouseExited(mouseEvent -> {
            signUpButton.setStyle("-fx-border-color: D3D3D3; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: White");
        });
        BorderPane botButtonPane = new BorderPane();
        botButtonPane.setCenter(signUpButton);
        botButtonPane.setPadding(new Insets(20,0,0,0));
        loginPane.setBottom(botButtonPane);
    }

    private void setRegisterPane() {
        BorderPane registerPane = new BorderPane();
        registerPane.setPadding(new Insets(30,30,30,30));
        mainGridPane.add(registerPane, 1,0);

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

        createAccountButton.setText("Create New Account");
        registerPane.setBottom(createAccountButton);
    }

    private void setColor(Node node){
        if (config.getMode().equals("dark")){
            node.setStyle("-fx-text-fill: LightGray");
        } else {
            node.setStyle("-fx-text-fill: Black");
        }
    }
}
