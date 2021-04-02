package Client.Controller;

import Client.DataHandler.ConfigLoader;
import Client.ServerHandler.Util;
import Client.View.LoginView;
import Client.View.MainFrame;
import Client.View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-31
 */

public class LoginController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private LoginView loginView;
    private Vector<Button> buttons;
    private Vector<TextField> fields;

    public LoginController(MainFrame mainFrame, LoginView loginView, Vector<Button> buttons, Vector<TextField> fields){
        this.mainFrame = mainFrame;
        this.loginView = loginView;
        this.buttons = buttons;
        this.fields = fields;
    }

    @Override
    public void handle(ActionEvent event) {
        if (buttons.get(0).equals(event.getSource())){
            handleButton1();
        } else if (buttons.get(1).equals(event.getSource())){
            mainFrame.setNewScene(new RegisterView(mainFrame), 400, 450);
        } else if (buttons.get(1).equals(event.getSource())){
            //TODO open password reset window (not in version 1)
        }
    }

    private void handleButton1(){
        if (!fields.get(0).getText().equals("") && !fields.get(1).getText().equals("")){

            FormBody data = new FormBody.Builder()
                    .add("username", fields.get(0).getText())
                    .add("password", fields.get(1).getText())
                    .build();

            Request request = new Request.Builder()
                    .url(ConfigLoader.loadConfig().getBaseURL() + "users/login")
                    .post(data)
                    .build();

            Response response = Util.executeServerRequest(request);

            if (response != null) {
                switch (response.code()){
                    case 200 -> {
                        //TODO open new window
                        loginView.setErrorMsgLabel("");
                        System.out.println("200");
                    }
                    case 400 -> {
                        try {
                            loginView.setErrorMsgLabel(Util.extractMulErrorMsg(response.body().string()).getErrorMsg());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(400);
                    }
                    case 401 ->{
                        try {
                            loginView.setErrorMsgLabel(Util.extractMulErrorMsg(response.body().string()).getErrorMsg());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(401);
                    }
                }
            }

        } else {
            if (fields.get(0).getText().equals("")){
                loginView.setErrorMsgLabel("No username / email provided");
            } else {
                loginView.setErrorMsgLabel("No password provided");
            }
        }
    }
}
