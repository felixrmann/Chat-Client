package Client.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class MainFrame extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);
        //TODO set icon
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });
        window.setResizable(false);
        //TODO title
        //TODO first view
        window.show();
    }

    public void init(Stage primaryStage){
        window = primaryStage;

        //TODO set first Scene
    }

    public void setNewScene(BorderPane borderPane, double width, double height){
        window.setScene(new Scene(borderPane, width, height));
        window.centerOnScreen();
    }

    public void closeProgram(){
        boolean answer = ConfirmView.display("Exit", "Do you want to exit the program?");
        if (answer) window.close();
    }

    public Stage getStage(){
        return window;
    }

    public void setSceneSize(double width, double height){
        window.setScene(new Scene(window.getScene().getRoot() , width, height));
    }
}
