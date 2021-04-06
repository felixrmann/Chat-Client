package Client.Model;

import java.util.UUID;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-15
 */

public class Message {

    private String messageUUID;
    private String messageContent;
    private String messageCreationDate;
    private String messageAuthorUUID;
    private String messageChatUUID;

    public Message(String messageContent, String messageAuthorUUID, String messageChatUUID){
        this.messageContent = messageContent;
        this.messageAuthorUUID = messageAuthorUUID;
        this.messageChatUUID = messageChatUUID;

        messageUUID = UUID.randomUUID().toString();
        messageCreationDate = String.valueOf(System.currentTimeMillis());
    }

    public Message(String messageUUID, String messageContent, String messageCreationDate, String messageAuthorUUID, String messageChatUUID){
        this.messageUUID = messageUUID;
        this.messageContent = messageContent;
        this.messageCreationDate = messageCreationDate;
        this.messageAuthorUUID = messageAuthorUUID;
        this.messageChatUUID = messageChatUUID;
    }

    public String getMessageUUID() {
        return messageUUID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getMessageCreationDate() {
        return messageCreationDate;
    }

    public String getMessageAuthorUUID() {
        return messageAuthorUUID;
    }

    public String getMessageChatUUID() {
        return messageChatUUID;
    }

    public void setMessageUUID(String messageUUID) {
        this.messageUUID = messageUUID;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setMessageCreationDate(String messageCreationDate) {
        this.messageCreationDate = messageCreationDate;
    }

    public void setMessageAuthorUUID(String messageAuthorUUID) {
        this.messageAuthorUUID = messageAuthorUUID;
    }

    public void setMessageChatUUID(String messageChatUUID) {
        this.messageChatUUID = messageChatUUID;
    }
}
