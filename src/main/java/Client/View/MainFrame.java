package Client.View;

import Client.DataHandler.ConfigLoader;
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
    Scene mainScene;

    /**
     * starts the program
     * @param primaryStage
     */
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
        window.setTitle("LogIn");
        //TODO first view
        window.setScene(mainScene);
        window.show();
    }

    /**
     * init method
     * @param primaryStage
     */
    public void init(Stage primaryStage){
        window = primaryStage;

        //TODO set first Scene
        mainScene = new Scene(new LoginView(this), 720, 400);
        setSceneImage(ConfigLoader.loadConfig().getMode());
    }

    /**
     * updates the scene
     * @param borderPane
     * @param width
     * @param height
     */
    public void setNewScene(BorderPane borderPane, double width, double height){
        window.setScene(new Scene(borderPane, width, height));
        window.centerOnScreen();
    }

    /**
     * handles the closing of the program
     */
    public void closeProgram(){
        boolean answer = ConfirmView.display("Exit", "Do you want to exit the program?");
        if (answer) window.close();
    }

    /**
     * method which returns the current stage
     * @return the stage
     */
    public Stage getStage(){
        return window;
    }

    /**
     * updates the size of the scene
     * @param width
     * @param height
     */
    public void setSceneSize(double width, double height){
        window.setScene(new Scene(window.getScene().getRoot() , width, height));
    }

    public void setSceneImage(String mode){
        if (mode.equals("light")){
            mainScene.getStylesheets().add("lightStyle.css");
        } else {
            mainScene.getStylesheets().add("darkStyle.css");
        }
    }
}
