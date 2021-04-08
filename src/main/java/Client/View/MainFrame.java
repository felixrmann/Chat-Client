package Client.View;

import Client.DataHandler.ConfigLoader;
import Client.Model.Config;
import Client.Util.Util;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
     *
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
        window.setScene(mainScene);
        window.show();
    }

    /**
     * init method
     *
     * @param primaryStage
     */
    public void init(Stage primaryStage) {
        window = primaryStage;

        /*
        mainScene = new Scene(new ChatView(this));
        Util.loadStylesheet(mainScene);
         */

        StartView startView = new StartView(this);
        mainScene = new Scene(startView, 400, 350);
        Util.loadStylesheet(mainScene);

        PauseTransition delay = new PauseTransition(Duration.millis(Math.random() * (2000 - 1000) + 1000));
        delay.setOnFinished(event -> startView.execute());
        delay.play();
    }

    /**
     * updates the scene
     *
     * @param borderPane
     * @param width
     * @param height
     */
    public void setNewScene(BorderPane borderPane, double width, double height) {
        Scene scene = new Scene(borderPane, width, height);
        Util.loadStylesheet(scene);
        mainScene = scene;
        window.setScene(scene);
        window.centerOnScreen();
    }

    /**
     * handles the closing of the program
     */
    public void closeProgram() {
        boolean answer = ConfirmView.display("Exit", "Do you want to exit the program?");
        if (answer) {
            window.close();
            Config exitConfig = ConfigLoader.loadConfig();
            exitConfig.setWindowHeight((int) window.getHeight());
            exitConfig.setWindowWidth((int) window.getWidth());
            ConfigLoader.saveConfig(exitConfig);
            System.exit(0);
        }
    }

    /**
     * method which returns the current stage
     *
     * @return the stage
     */
    public Stage getStage() {
        return window;
    }

    /**
     * updates the size of the scene
     *
     * @param width
     * @param height
     */
    public void setSceneSize(double width, double height) {
        window.setScene(new Scene(window.getScene().getRoot(), width, height));
    }

    /**
     * toggles the resizability of the window
     *
     * @param resizable
     */
    public void setResizable(boolean resizable) {
        window.setResizable(resizable);
    }

    /**
     * makes the window max-sized
     */
    public void resizeToMaxSize() {
        window.setMaximized(true);
    }

    /**
     * sets the height and width of the window
     *
     * @param width
     * @param height
     */
    public void setWindowSize(double width, double height){
        window.setWidth(width);
        window.setHeight(height);
    }

    /**
     * sets minimum height and with of window
     *
     * @param height
     * @param width
     */
    public void setMinSize(double width, double height) {
        window.setMinWidth(width);
        window.setMinHeight(height);
    }

    /**
     * sets Name of window
     *
     * @param stageName
     */
    public void setStageName(String stageName) {
        window.setTitle(stageName);
    }

    /**
     * returns window
     *
     * @return window
     */
    public Stage getWindow() {
        return window;
    }
}
