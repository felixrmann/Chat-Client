package Client.View;

import Client.Controller.CreateChatController;
import Client.Util.Util;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 09
 */

public class CreateChatView {

    private Stage window;
    private CreateChatController createChatController;
    private Label textLabel, errorMsgLabel;
    private TextField textField;
    private CheckBox checkBox1, checkBox2;
    private static Button backButton, createButton;

    /**
     * displays the main window
     * @param mainFrame mainFrame
     */
    public void display(MainFrame mainFrame){
        init();

        Scene scene = new Scene(createWindowContent(), 400, 200);
        Util.loadStylesheet(scene);

        //TODO set icon

        window.initOwner(mainFrame.getStage());
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.setResizable(false);
        window.setTitle("Create chat");
        window.setAlwaysOnTop(true);
        //TODO show above the main window (position)
        window.centerOnScreen();
        window.showAndWait();
    }

    /**
     * initializes all variables
     */
    private void init() {
        window = new Stage();
        createChatController = new CreateChatController(this);
        textLabel = new Label();
        errorMsgLabel = new Label();
        textField = new TextField();
        checkBox1 = new CheckBox();
        checkBox2 = new CheckBox();
        backButton = new Button();
        createButton = new Button();
    }

    /**
     * creates the window
     * @return borderPane
     */
    private BorderPane createWindowContent() {
        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("createChat");
        borderPane.setPadding(new Insets(10,10,10,10));

        BorderPane topPane = new BorderPane();

        textLabel.setText("Enter the name of your chat");
        textLabel.setFont(new Font("Arial",25));
        Util.setColor(textLabel);
        topPane.setCenter(textLabel);

        errorMsgLabel.setFont(new Font("Arial", 14));
        errorMsgLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: red");
        topPane.setBottom(errorMsgLabel);
        borderPane.setTop(topPane);

        BorderPane centerPane = new BorderPane();
        centerPane.setPadding(new Insets(0,0,10,0));

        textField.setPrefWidth(200);
        textField.setPrefHeight(30);
        textField.setFont(new Font("Arial", 20));
        Util.setTextField(textField);
        centerPane.setCenter(textField);

        GridPane centerGridPane = new GridPane();
        centerGridPane.setPadding(new Insets(0,10,0,10));
        centerGridPane.setHgap(180);

        checkBox1.setText("DM");
        checkBox1.setFont(new Font("Arial", 17));
        Util.setCheckBox(checkBox1);
        centerGridPane.add(checkBox1,0,0);

        checkBox2.setText("group chat");
        checkBox2.setFont(new Font("Arial", 17));
        Util.setCheckBox(checkBox2);
        centerGridPane.add(checkBox2,1,0);

        checkBoxAction();

        centerPane.setBottom(centerGridPane);
        borderPane.setCenter(centerPane);

        BorderPane botPane = new BorderPane();

        backButton.setText("Back");
        Util.setButton(backButton);
        backButton.setPrefHeight(30);
        backButton.setPrefWidth(60);
        botPane.setLeft(backButton);

        createButton.setText("Create");
        Util.setButton(createButton);
        createButton.setPrefHeight(30);
        createButton.setPrefWidth(60);
        botPane.setRight(createButton);
        borderPane.setBottom(botPane);

        buttonAction();

        return borderPane;
    }

    /**
     * sets the checkbox action
     */
    private void checkBoxAction(){
        checkBox1.setOnAction(event -> {
            if (checkBox1.isSelected()) checkBox2.setSelected(false);
        });
        checkBox2.setOnAction(event -> {
            if (checkBox2.isSelected()) checkBox1.setSelected(false);
        });
    }

    /**
     * sets the button action
     */
    private void buttonAction(){
        backButton.setOnAction(event -> {
            window.close();
        });
        createButton.setOnAction(createChatController);
    }

    /**
     * sets error Message Label
     * @param errorMsg error message
     */
    public void setErrorMsgLabel(String errorMsg){
        errorMsgLabel.setText(errorMsg);
    }

    /**
     * returns the text of the textField
     * @return text of the textField
     */
    public String getFieldText(){
        return textField.getText();
    }

    /**
     * returns the chatMode
     * @return chatMode
     */
    public int getChatMode(){
        if (checkBox1.isSelected()) return 1;
        else if (checkBox2.isSelected()) return 0;
        else return 2;
    }

    /**
     * closes the window
     */
    public void closeWindow(){
        window.close();
    }
}
