package Client.View;

import Client.Controller.StartController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The type Start view.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 03
 */

public class StartView extends BorderPane {

    private final MainFrame mainFrame;
    private StartController startController;

    /**
     * Instantiates a new Start view.
     *
     * @param mainFrame the main frame
     */
    public StartView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        init();

        createPane();
    }

    /**
     * initializes all variables
     */
    private void init() {
        mainFrame.setStageName("Connecting...");
        mainFrame.setResizable(false);
        setStyle("-fx-background-color: '001d30'");

        startController = new StartController(mainFrame);
    }

    /**
     * creates the Pane
     */
    private void createPane() {
        try {
            Label label = new Label();
            /*
             * Animation found on this website:
             * https://dribbble.com/shots/2156764-Firefly-Scanner-look-Gooey-Effect-Loader
             */
            Image img = new Image(new FileInputStream("src\\main\\resources\\images\\loadingAnimation.gif"));
            ImageView view = new ImageView(img);
            view.setFitHeight(300);
            view.setPreserveRatio(true);
            label.setGraphic(view);

            setCenter(label);

            Label connectingLabel = new Label();
            connectingLabel.setText("Connecting");
            connectingLabel.setFont(new Font("Arial", 20));
            connectingLabel.setStyle("-fx-text-fill: 'e1e6ed'");
            BorderPane botPane = new BorderPane();
            botPane.setCenter(connectingLabel);
            botPane.setPadding(new Insets(15,0,15,0));

            setBottom(botPane);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * sets up Project
     */
    public void execute(){
        startController.setUpProject();
    }
}
