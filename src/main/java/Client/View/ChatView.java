package Client.View;

import javafx.scene.layout.BorderPane;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class ChatView extends BorderPane {

    private MainFrame mainFrame;

    public ChatView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        init();
    }

    private void init() {
        mainFrame.setResizable(true);
    }
}