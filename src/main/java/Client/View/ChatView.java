package Client.View;

import Client.Model.Chat;
import Client.Util.ChatUtil;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class ChatView extends BorderPane {

    private MainFrame mainFrame;
    private GridPane mainGridPane;
    private ListView<Chat> listView;
    private int screenWidth, screenHeight;
    private Vector<Chat> allChats;

    public ChatView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        init();

        createMainGridPane();
    }

    private void init() {
        getStyleClass().add("chat");
        mainFrame.setStageName("Chat");
        mainFrame.setResizable(true);
        mainFrame.setMaxSize();
        mainFrame.setMinSize(700, 500);

        mainGridPane = new GridPane();
        listView = new ListView<>();
        allChats = ChatUtil.loadAllChats();

        initScreenSize();
    }

    private void createMainGridPane() {
        setCenter(mainGridPane);

        mainGridPane.setPadding(new Insets(10,10,10,10));
        mainGridPane.add(chatListView(), 0,0);
    }

    private BorderPane chatListView(){
        BorderPane listBorderPane = new BorderPane();

        if (allChats != null) {
            ObservableList<Chat> allChatList = FXCollections.observableList(allChats);
            listView.setItems(allChatList);
            listView.setOnMouseClicked(mouseEvent -> {
                System.out.println(allChatList.get(listView.getSelectionModel().getSelectedIndex()).getChatName());
            });
            listView.setCellFactory(chatListView -> new ChatCell());
            listView.prefHeightProperty().bind(Bindings.divide(mainFrame.getStage().widthProperty(), 0.1));
        }

        listBorderPane.setCenter(listView);

        BorderPane botBorderPane = new BorderPane();

        listBorderPane.setBottom(botBorderPane);

        return listBorderPane;
    }

    private void initScreenSize() {
        screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

    static class ChatCell extends ListCell<Chat> {
        BorderPane borderPane = new BorderPane();
        GridPane centerPane = new GridPane();
        BorderPane datePane = new BorderPane();
        Label chatNameLabel = new Label();
        Label lastMsgLabel = new Label();
        Label lastMsgDateLabel = new Label();

        public ChatCell(){
            borderPane.setPrefHeight(50);
            borderPane.setPrefWidth(100);
            //TODO set image of chat left
            //borderPane.setLeft();
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
                        lastMsgDateLabel.setText(chat.getLastMessage().getMessageCreationDate());
                    } else {
                        lastMsgLabel.setText("last message");
                        lastMsgDateLabel.setText("last date");
                    }
                }
                setGraphic(borderPane);
            }
        }
    }
}