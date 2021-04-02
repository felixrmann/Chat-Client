package Client.View;

import Client.Controller.RegisterController;
import Client.ServerHandler.Util;
import javafx.geometry.Insets;
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
 * @since 2021-April-02
 */

public class RegisterView extends BorderPane {

    private MainFrame mainFrame;
    private RegisterController registerController;
    private GridPane mainGridPane;
    private Vector<Button> buttons;
    private Vector<TextField> textFields;
    private Button registerButton, haveAccountButton;
    private TextField nameField, mailField;
    private PasswordField passwordField, confPasswordField;

    public RegisterView(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        init();

        createGridPane();

    }

    private void init(){
        getStyleClass().add("register");
        buttons = new Vector<>();
        textFields = new Vector<>();

        registerButton = new Button();
        haveAccountButton = new Button();
        nameField = new TextField();
        mailField = new TextField();
        passwordField = new PasswordField();
        confPasswordField = new PasswordField();
        mainGridPane = new GridPane();
        registerController = new RegisterController(mainFrame, this, buttons, textFields);

        buttons.add(registerButton);
        buttons.add(haveAccountButton);

        textFields.add(nameField);
        textFields.add(mailField);
        textFields.add(passwordField);
        textFields.add(confPasswordField);

        registerButton.setOnAction(registerController);
        haveAccountButton.setOnAction(registerController);
    }

    private void createGridPane() {
        Label registerLabel = new Label();
        registerLabel.setText("Register");
        registerLabel.setFont(new Font("Arial", 27));
        Util.setColor(registerLabel);
        registerLabel.setPadding(new Insets(20, 0, 20, 20));
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(registerLabel);
        setTop(borderPane);

        createCenter();

        registerButton.setText("Register");
        Util.setButton(registerButton);
        registerButton.setMinHeight(40);
        registerButton.setPrefHeight(40);
        registerButton.setMaxHeight(40);
        registerButton.setMinWidth(150);
        registerButton.setPrefWidth(150);
        registerButton.setMaxWidth(150);
        BorderPane botButtonPane = new BorderPane();
        botButtonPane.setCenter(registerButton);
        botButtonPane.setPadding(new Insets(0,0,20,0));
        setBottom(botButtonPane);
    }

    private void createCenter() {
        BorderPane registerPane = new BorderPane();
        registerPane.setPadding(new Insets(10,0,10,0));
        setCenter(registerPane);

        GridPane registerInputPane = new GridPane();
        registerInputPane.setPadding(new Insets(0,50,0,50));
        registerPane.setCenter(registerInputPane);
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();

        label1.setText("Username");
        label1.setFont(new Font("Arial", 14));
        Util.setColor(label1);
        label1.setPadding(new Insets(0,0,5,0));
        registerInputPane.add(label1,0,0);

        nameField.setPrefWidth(300);
        nameField.setPrefHeight(30);
        nameField.setFont(new Font("Arial", 20));
        Util.setTextField(nameField);
        registerInputPane.add(nameField,0,1);

        label2.setText("Email");
        label2.setFont(new Font("Arial", 14));
        Util.setColor(label2);
        label2.setPadding(new Insets(10,0,5,0));
        registerInputPane.add(label2,0,2);

        mailField.setPrefWidth(300);
        mailField.setPrefHeight(30);
        mailField.setFont(new Font("Arial", 20));
        Util.setTextField(mailField);
        registerInputPane.add(mailField,0,3);

        label3.setText("Password");
        label3.setFont(new Font("Arial", 14));
        Util.setColor(label3);
        label3.setPadding(new Insets(10,0,5,0));
        registerInputPane.add(label3,0,4);

        passwordField.setPrefWidth(300);
        passwordField.setPrefHeight(30);
        passwordField.setFont(new Font("Arial", 20));
        Util.setTextField(passwordField);
        registerInputPane.add(passwordField,0,5);

        label4.setText("Confirm password");
        label4.setFont(new Font("Arial", 14));
        Util.setColor(label4);
        label4.setPadding(new Insets(10,0,5,0));
        registerInputPane.add(label4,0,6);

        confPasswordField.setPrefWidth(300);
        confPasswordField.setPrefHeight(30);
        confPasswordField.setFont(new Font("Arial", 20));
        Util.setTextField(confPasswordField);
        registerInputPane.add(confPasswordField,0,7);

        haveAccountButton.setText("I already have an account");
        haveAccountButton.setStyle("-fx-background-color: transparent; -fx-text-fill: DarkBlue");
        haveAccountButton.setPadding(new Insets(10,0,0,0));
        registerInputPane.add(haveAccountButton,0,8);
    }
}
