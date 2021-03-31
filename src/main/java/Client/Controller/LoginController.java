package Client.Controller;

import Client.View.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-31
 */

public class LoginController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private Vector<Button> buttons;

    public LoginController(MainFrame mainFrame, Vector<Button> buttons){
        this.mainFrame = mainFrame;
        this.buttons = buttons;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
