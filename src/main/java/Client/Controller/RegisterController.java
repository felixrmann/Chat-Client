package Client.Controller;

import Client.View.MainFrame;
import Client.View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-02
 */

public class RegisterController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private RegisterView registerView;
    private Vector<Button> buttons;
    private Vector<TextField> textFields;

    public RegisterController(MainFrame mainFrame, RegisterView registerView, Vector<Button> buttons, Vector<TextField> textFields){
        this.mainFrame = mainFrame;
        this.registerView = registerView;
        this.buttons = buttons;
        this.textFields = textFields;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
