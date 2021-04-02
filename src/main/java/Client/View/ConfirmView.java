package Client.View;

import Client.ServerHandler.Util;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Dezember-11
 */

public class ConfirmView {

    private static boolean answer;
    private static Stage window;
    private static Label textLabel;
    private static Button noButton, yesButton;
    private static String text;

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

    private static void init() {
        window = new Stage();
        textLabel = new Label();
        noButton = new Button();
        yesButton = new Button();
    }

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
