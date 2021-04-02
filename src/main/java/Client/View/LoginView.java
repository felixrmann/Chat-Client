package Client.View;

import Client.Controller.LoginController;
import Client.DataHandler.ConfigLoader;
import Client.Model.Config;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    private Vector<TextField> fields;
    private Button signUpButton, createAccountButton, forgotPasswordButton;
    private Label errorMsgLabel;
    private TextField userNameTextField;
    private PasswordField passwordTextField;
    private final Config config = ConfigLoader.loadConfig();

    public LoginView(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        init();

        createGridPane();

        setCenter(mainGridPane);
    }

    private void init() {
        buttons = new Vector<>();
        fields = new Vector<>();

        userNameTextField = new TextField();
        passwordTextField = new PasswordField();
        loginController = new LoginController(mainFrame, this, buttons, fields);
        mainGridPane = new GridPane();

        signUpButton = new Button();
        createAccountButton = new Button();
        forgotPasswordButton = new Button();
        errorMsgLabel = new Label();

        buttons.add(signUpButton);
        buttons.add(createAccountButton);
        buttons.add(forgotPasswordButton);

        fields.add(userNameTextField);
        fields.add(passwordTextField);

        signUpButton.setOnAction(loginController);
        createAccountButton.setOnAction(loginController);
        forgotPasswordButton.setOnAction(loginController);
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

        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Arial", 27));
        setColor(loginLabel);
        loginLabel.setPadding(new Insets(0,0,40,0));
        loginPane.setTop(loginLabel);

        GridPane userInputPane = new GridPane();
        userInputPane.setStyle("-fx-background-color: transparent");
        loginPane.setCenter(userInputPane);

        errorMsgLabel.setFont(new Font("Arial", 13));
        userInputPane.add(errorMsgLabel,0,0);

        userNameLabel.setText("Username / Mail");
        userNameLabel.setFont(new Font("Arial", 14));
        setColor(userNameLabel);
        userNameLabel.setPadding(new Insets(0,0,5,0));
        userInputPane.add(userNameLabel,0,1);

        userNameTextField.setPrefWidth(320);
        userNameTextField.setPrefHeight(35);
        userNameTextField.setFont(new Font("Arial", 20));
        if (config.getMode().equals("dark")){
            userNameTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '374151'; -fx-text-inner-color: DarkGrey; -fx-background-color: '374151'");
        } else {
            userNameTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '9CA3AF'; -fx-text-inner-color: Black; -fx-background-color: '9CA3AF'");
        }
        userInputPane.add(userNameTextField, 0,2);

        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Arial", 14));
        setColor(passwordLabel);
        passwordLabel.setPadding(new Insets(15,0,5,0));
        userInputPane.add(passwordLabel, 0,3);

        passwordTextField.setPrefWidth(320);
        passwordTextField.setPrefHeight(35);
        passwordTextField.setFont(new Font("Arial", 20));
        if (config.getMode().equals("dark")){
            passwordTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '374151'; -fx-text-inner-color: DarkGrey; -fx-background-color: '374151'");
        } else {
            passwordTextField.setStyle("-fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-border-color: '9CA3AF'; -fx-text-inner-color: Black; -fx-background-color: '9CA3AF'");
        }
        userInputPane.add(passwordTextField, 0,4);

        forgotPasswordButton.setText("I forgot my password");
        forgotPasswordButton.setStyle("-fx-background-color: transparent; -fx-text-fill: DarkBlue");
        forgotPasswordButton.setPadding(new Insets(10,0,40,0));
        userInputPane.add(forgotPasswordButton, 0,5);

        signUpButton.setText("Sign In");
        signUpButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'");
        signUpButton.setMinHeight(35);
        signUpButton.setPrefHeight(35);
        signUpButton.setMaxHeight(35);
        signUpButton.setMinWidth(250);
        signUpButton.setPrefWidth(250);
        signUpButton.setMaxWidth(250);
        signUpButton.setOnMouseEntered(mouseEvent -> signUpButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: 'A3E635'"));
        signUpButton.setOnMouseExited(mouseEvent -> signUpButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'"));
        BorderPane botButtonPane = new BorderPane();
        botButtonPane.setCenter(signUpButton);
        botButtonPane.setPadding(new Insets(20,0,0,0));
        loginPane.setBottom(botButtonPane);
    }

    private void setRegisterPane() {
        BorderPane registerPane = new BorderPane();
        registerPane.setPadding(new Insets(20,18,20,20));
        mainGridPane.add(registerPane, 1,0);

        Label registerLabel = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();

        BorderPane registerLabelPane = new BorderPane();
        registerLabelPane.setRight(registerLabel);
        registerLabelPane.setPadding(new Insets(0,0,55,0));
        registerLabel.setText("Register");
        registerLabel.setFont(new Font("Arial", 27));
        setColor(registerLabel);
        registerPane.setTop(registerLabelPane);

        GridPane registerInfoPane = new GridPane();
        registerPane.setCenter(registerInfoPane);

        label1.setText("Create an account to chat with your friends");
        label1.setFont(new Font("Arial", 17));
        label1.setPadding(new Insets(0,0,20,0));
        setColor(label1);
        registerInfoPane.add(label1, 0,0);

        label2.setText("You can:");
        label2.setFont(new Font("Arial", 17));
        label2.setPadding(new Insets(0,0,10,0));
        setColor(label2);
        registerInfoPane.add(label2, 0,1);
        
        label3.setText("Chat with your friends");
        label3.setFont(new Font("Arial", 14));
        label3.setPadding(new Insets(0,0,10,0));
        setColor(label3);
        registerInfoPane.add(label3, 0,2);
        
        label4.setText("Create group chats and chat with many friends");
        label4.setFont(new Font("Arial", 14));
        label4.setPadding(new Insets(0,0,0,0));
        setColor(label4);
        registerInfoPane.add(label4, 0,3);

        createAccountButton.setText("Create New Account");
        createAccountButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'");
        createAccountButton.setMinHeight(27);
        createAccountButton.setPrefHeight(27);
        createAccountButton.setMaxHeight(27);
        createAccountButton.setMinWidth(190);
        createAccountButton.setPrefWidth(190);
        createAccountButton.setMaxWidth(190);
        createAccountButton.setOnMouseEntered(mouseEvent -> createAccountButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: 'A3E635'"));
        createAccountButton.setOnMouseExited(mouseEvent -> createAccountButton.setStyle("-fx-border-color: '84CC16'; -fx-focus-color: -fx-control-inner-background; -fx-faint-focus-color: -fx-control-inner-background; -fx-background-color: '84CC16'"));
        BorderPane botButtonPane = new BorderPane();
        botButtonPane.setCenter(createAccountButton);
        botButtonPane.setPadding(new Insets(50,0,0,0));
        registerInfoPane.add(botButtonPane, 0, 4);
    }

    private void setColor(Node node){
        if (config.getMode().equals("dark")){
            node.setStyle("-fx-text-fill: LightGray");
        } else {
            node.setStyle("-fx-text-fill: '1A2636'");
        }
    }

    public void setErrorMsgLabel(String errorMsg){
        errorMsgLabel.setText(errorMsg);
        errorMsgLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: red");
    }
}