package Client.View;

import Client.Controller.ChatController;
import Client.DataHandler.ConfigLoader;
import Client.Model.Chat;
import Client.Model.Config;
import Client.Model.User;
import Client.Util.ChatUtil;
import Client.Util.UserUtil;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * The class Chat View
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - February - 27
 */

public class ChatView extends BorderPane {

    private final MainFrame mainFrame;
    private ChatController chatController;
    private GridPane mainGridPane;
    private BorderPane listBorderPane;
    private ListView<Chat> listView;
    private TextArea textInputArea;
    private Button addChatButton, settingsButton;
    private int screenWidth, screenHeight;
    private Vector<Button> buttons;
    private Vector<Chat> allChats;

    public ChatView(MainFrame mainFrame, Vector<Chat> allChats){
        this.mainFrame = mainFrame;
        this.allChats = allChats;

        init();

        createMainGridPane();
    }

    private void init() {
        getStyleClass().add("chat");
        mainFrame.setStageName("Chat");
        mainFrame.setResizable(true);
        Config config = ConfigLoader.loadConfig();
        if (config.getWindowHeight() != 0 && config.getWindowWidth() != 0){
            mainFrame.setWindowSize(config.getWindowWidth(), config.getWindowHeight());
        } else {
            mainFrame.setWindowSize(1500, 1000);
        }
        if (config.getWindowPosY() != 0.0 && config.getWindowPosX() != 0.0){
            mainFrame.setWindowPosition(config.getWindowPosY(), config.getWindowPosX());
        }
        mainFrame.setMinSize(700, 500);

        if (allChats == null){
            allChats = ChatUtil.loadAllChats();
        }

        mainGridPane = new GridPane();
        listBorderPane = new BorderPane();
        listView = new ListView<>();
        textInputArea = new TextArea();
        addChatButton = new Button();
        settingsButton = new Button();
        buttons = new Vector<>();
        chatController = new ChatController(mainFrame, this, buttons);

        buttons.add(addChatButton);
        buttons.add(settingsButton);

        addChatButton.setOnAction(chatController);
        settingsButton.setOnAction(chatController);

        initScreenSize();
    }

    private void createMainGridPane() {
        setCenter(mainGridPane);

        mainGridPane.setPadding(new Insets(10,10,10,10));
        mainGridPane.requestFocus();
        mainGridPane.add(chatListView(), 0,0);
        mainGridPane.add(createChatPane(), 1,0);
    }

    private BorderPane chatListView(){

        initListView(allChats);

        BorderPane botBorderPane = new BorderPane();
        botBorderPane.setStyle("-fx-background-color: white");

        try {
            Label userImgLabel = new Label();
            Image img = new Image(new FileInputStream("src\\main\\resources\\images\\defaultUser.png"));
            ImageView view = new ImageView(img);
            view.setFitHeight(50);
            view.setPreserveRatio(true);
            userImgLabel.setGraphic(view);
            userImgLabel.setPadding(new Insets(5,0,0,5));
            botBorderPane.setLeft(userImgLabel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Label userNameLabel = new Label();
        userNameLabel.setFont(new Font("Arial", 25));
        User currentUser = UserUtil.loadUserData();
        if (currentUser != null) {
            userNameLabel.setText(currentUser.getUserName());
        }
        botBorderPane.setCenter(userNameLabel);

        GridPane botButtonGridPane = new GridPane();

        try {
            Image img = new Image(new FileInputStream("src\\main\\resources\\images\\addChat.png"));
            ImageView view = new ImageView(img);
            view.setFitHeight(50);
            view.setPreserveRatio(true);
            addChatButton.setGraphic(view);
            addChatButton.setStyle("-fx-background-color: transparent");
            botButtonGridPane.add(addChatButton,0,0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Image img = new Image(new FileInputStream("src\\main\\resources\\images\\settings.png"));
            ImageView view = new ImageView(img);
            view.setFitHeight(50);
            view.setPreserveRatio(true);
            settingsButton.setGraphic(view);
            settingsButton.setStyle("-fx-background-color: transparent");
            botButtonGridPane.add(settingsButton,1,0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        botBorderPane.setRight(botButtonGridPane);

        listBorderPane.setBottom(botBorderPane);
        listBorderPane.setMinWidth(350);
        listBorderPane.prefHeightProperty().bind(mainFrame.getStage().heightProperty());
        listBorderPane.prefWidthProperty().bind(mainFrame.getStage().widthProperty().multiply(0.25));

        return listBorderPane;
    }

    private BorderPane createChatPane(){
        BorderPane chatPane = new BorderPane();

        BorderPane chatContentPane = new BorderPane();
        //chatContentPane.prefHeightProperty().bind(Bindings.divide(mainFrame.getStage().heightProperty(), 1));
        //chatContentPane.prefWidthProperty().bind(Bindings.divide(mainFrame.getStage().widthProperty(), 0.75));
        chatPane.setCenter(chatContentPane);

        BorderPane textInputPane = new BorderPane();
        textInputPane.setCenter(textInputArea);

        textInputArea.prefWidthProperty().bind(Bindings.divide(mainFrame.getStage().widthProperty(), 1));

        chatPane.setBottom(textInputPane);

        return chatPane;
    }

    private void initScreenSize() {
        screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

    static class ChatCell extends ListCell<Chat> {
        BorderPane borderPane = new BorderPane();
        GridPane centerPane = new GridPane();
        BorderPane datePane = new BorderPane();
        Label chatImgLabel = new Label();
        Label chatNameLabel = new Label();
        Label lastMsgLabel = new Label();
        Label lastMsgDateLabel = new Label();

        public ChatCell(){
            borderPane.setPrefHeight(50);
            borderPane.setPrefWidth(100);

            try {
                Image img = new Image(new FileInputStream("src\\main\\resources\\images\\defaultChat.png"));
                ImageView view = new ImageView(img);
                view.setFitHeight(50);
                view.setPreserveRatio(true);
                chatImgLabel.setGraphic(view);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            chatNameLabel.setFont(new Font("Arial", 15));
            chatNameLabel.setPadding(new Insets(5,0,7,0));

            lastMsgLabel.setFont(new Font("Arial", 12));

            borderPane.setLeft(chatImgLabel);
            borderPane.setCenter(centerPane);
            borderPane.setRight(datePane);

            centerPane.add(chatNameLabel, 0,0);
            centerPane.add(lastMsgLabel, 0,1);

            datePane.setTop(lastMsgDateLabel);
        }

        @Override
        protected void updateItem(Chat chat, boolean empty) {
            super.updateItem(chat, empty);
            if (empty){
                setGraphic(null);
                setText(null);
            } else {
                if (chat != null){
                    chatNameLabel.setText(chat.getChatName());
                    if (!chat.getLastMessage().getMessageContent().equals("")){
                        lastMsgLabel.setText(chat.getLastMessage().getMessageContent());
                        lastMsgDateLabel.setText(ChatView.dateLogic(chat));
                    } else {
                        lastMsgLabel.setText("no messages");
                        lastMsgDateLabel.setText("");
                    }
                }
                setGraphic(borderPane);
            }
        }
    }

    private void initListView(Vector<Chat> allChats){
        if (allChats != null) {
            ObservableList<Chat> allChatList = FXCollections.observableList(allChats);
            listView.setItems(allChatList);
            //TODO handle if user has no chats (direct user to creation of chat)
            listView.getSelectionModel().select(0);
            listView.setOnMouseClicked(mouseEvent -> {
                //TODO load chat
                System.out.println(allChatList.get(listView.getSelectionModel().getSelectedIndex()).getChatName());
            });
            listView.setCellFactory(chatListView -> new ChatCell());
        }

        listBorderPane.setCenter(listView);
    }

    /**
     * updates the chat list
     */
    public void updateChatList(){
        allChats = null;
        initListView(ChatUtil.loadAllChats());
    }

    /**
     * logic for the chat
     * @return date for chat
     */
    private static String dateLogic(Chat chat){
        String outString = "";

        Calendar lastWeek = Calendar.getInstance();
        lastWeek.setTime(new Date());
        lastWeek.add(Calendar.WEEK_OF_YEAR, - 7);

        Calendar messageDate = Calendar.getInstance();
        messageDate.setTimeInMillis(Long.parseLong(chat.getLastMessage().getMessageCreationDate()));

        if ((lastWeek.get(Calendar.YEAR) == messageDate.get(Calendar.YEAR)) && (lastWeek.get(Calendar.DAY_OF_YEAR) <= messageDate.get(Calendar.DAY_OF_YEAR))){
            String dayOfWeek = new SimpleDateFormat("EEEE").format(messageDate.get(Calendar.DAY_OF_WEEK));
            outString = dayOfWeek + "    " + messageDate.get(Calendar.HOUR_OF_DAY) + ":" + messageDate.get(Calendar.MINUTE);
        } else {
            outString = messageDate.get(Calendar.DAY_OF_MONTH) + " / " + messageDate.get(Calendar.MONTH) + " / " + messageDate.get(Calendar.YEAR);
        }

        return outString;
    }
}