package Client.View;

import Client.DataHandler.UserLoader;
import Client.Model.User;
import Client.ServerHandler.UserService;
import Client.ServerHandler.Util;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import okhttp3.Response;

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

        UserLoader userLoader = new UserLoader();
        User user = userLoader.loadUser();

        if (user != null){
            Response response = UserService.loginUser(user.getUserName(), user.getUserPassword());
            if (response.code() == 200) {
                mainScene = new Scene(new ChatView(this), 800, 800);
            } else {
                mainScene = new Scene(new LoginView(this), 720, 400);
            }
        } else {
            mainScene = new Scene(new RegisterView(this), 400, 450);
        }

        Util.loadStylesheet(mainScene);
    }

    /**
     * updates the scene
     * @param borderPane
     * @param width
     * @param height
     */
    public void setNewScene(BorderPane borderPane, double width, double height){
        Scene scene = new Scene(borderPane, width, height);
        Util.loadStylesheet(scene);
        window.setScene(scene);
        window.centerOnScreen();
    }

    /**
     * handles the closing of the program
     */
    public void closeProgram(){
        boolean answer = ConfirmView.display("Exit", "Do you want to exit the program?");
        if (answer) window.close();
        System.exit(0);
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
}
