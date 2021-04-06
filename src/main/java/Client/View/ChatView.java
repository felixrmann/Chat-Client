package Client.View;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class ChatView extends BorderPane {

    private MainFrame mainFrame;
    private GridPane mainGridPane;
    private int screenWidth, screenHeight;

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

        initScreenSize();
    }

    private void createMainGridPane() {
        setCenter(mainGridPane);

        mainGridPane.setPadding(new Insets(10,10,10,10));
        mainGridPane.add(chatListView(), 0,0);
    }

    private BorderPane chatListView(){
        BorderPane listBorderPane = new BorderPane();
        listBorderPane.setStyle("-fx-background-color: white");


        return listBorderPane;
    }

    private void initScreenSize() {
        screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }
}