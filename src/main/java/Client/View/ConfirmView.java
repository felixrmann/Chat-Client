package Client.View;

import Client.Util.Util;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The class Confirm View
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 - December - 11
 */

public class ConfirmView {

    private static boolean answer;
    private static Stage window;
    private static Label textLabel;
    private static Button noButton, yesButton;
    private static String text;

    /**
     * Display boolean.
     *
     * @param title the title
     * @param text  the text
     * @return the boolean
     */
    public static boolean display(String title, String text){
        ConfirmView.text = text;

        init();

        //TODO set icon
        window.setTitle(title);
        Scene scene = new Scene(windowContent(), 250, 100);
        Util.loadStylesheet(scene);
        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.centerOnScreen();
        window.showAndWait();

        return answer;
    }

    /**
     * initializes all variables
     */
    private static void init() {
        window = new Stage();
        textLabel = new Label();
        noButton = new Button();
        yesButton = new Button();
    }

    /**
     * creates the windowContent
     * @return borderPane
     */
    private static BorderPane windowContent(){
        BorderPane borderPane = new BorderPane();

        textLabel.setText(text);
        textLabel.setFont(new Font("Arial", 15));
        Util.setColor(textLabel);

        borderPane.getStyleClass().add("confirm");
        borderPane.setCenter(textLabel);
        borderPane.setBottom(botPart());
        borderPane.setPadding(new Insets(5,5,5,5));
        buttonAction();

        return borderPane;
    }

    /**
     * creates the botPart
     * @return borderPane
     */
    private static BorderPane botPart() {
        BorderPane borderPane = new BorderPane();

        noButton.setText("No");
        Util.setButton(noButton);
        yesButton.setText("Yes");
        Util.setButton(yesButton);

        borderPane.setLeft(noButton);
        borderPane.setRight(yesButton);

        return borderPane;
    }

    /**
     * creates the buttonAction
     */
    private static void buttonAction() {
        noButton.setOnAction(event -> {
            answer = false;
            window.close();
        });
        yesButton.setOnAction(event -> {
            answer = true;
            window.close();
        });
    }
}
