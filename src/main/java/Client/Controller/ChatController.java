package Client.Controller;

import Client.View.ChatView;
import Client.View.CreateChatView;
import Client.View.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Vector;

/**
 * The type Chat controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 31
 */

public class ChatController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private ChatView chatView;
    private Vector<Button> buttons;

    public ChatController(MainFrame mainFrame, ChatView chatView, Vector<Button> buttons){
        this.mainFrame = mainFrame;
        this.chatView = chatView;
        this.buttons = buttons;
    }

    @Override
    public void handle(ActionEvent event) {
        if (buttons.get(0).equals(event.getSource())){
            CreateChatView createChatView = new CreateChatView();
            createChatView.display(mainFrame);
            chatView.updateChatList();
        } else if (buttons.get(1).equals(event.getSource())){
            //TODO open settings view
        }
    }
}
