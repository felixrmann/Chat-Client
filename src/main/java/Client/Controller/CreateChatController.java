package Client.Controller;

import Client.ServerHandler.ChatService;
import Client.Util.Util;
import Client.View.CreateChatView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 09
 */

public class CreateChatController implements EventHandler<ActionEvent> {

    private CreateChatView createChatView;

    public CreateChatController(CreateChatView createChatView){
        this.createChatView = createChatView;
    }

    @Override
    public void handle(ActionEvent event) {
        if (!createChatView.getFieldText().equals("")){
            if (createChatView.getChatMode() < 2){

                Response response = ChatService.createChat(createChatView.getFieldText(), createChatView.getChatMode());

                if (response != null){
                    switch (response.code()){
                        case 200 -> {
                            createChatView.closeWindow();
                        }
                        case 400, 500 -> {
                            try {
                                createChatView.setErrorMsgLabel(Util.extractErrorMsg(Objects.requireNonNull(response.body()).string()).getErrorMsg());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    createChatView.setErrorMsgLabel("Unexpected error. Please try again later");
                }
            } else {
                createChatView.setErrorMsgLabel("Please select a chat mode");
            }
        } else {
            createChatView.setErrorMsgLabel("Enter a name please");
        }
    }
}
