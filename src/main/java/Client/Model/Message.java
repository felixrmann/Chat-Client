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
    private String messageDate;
    private String messageAuthorUUID;
    private String messageChatUUID;
    private User author;

    public Message(String messageUUID, String messageContent, String messageDate, User author){
        this.messageUUID = messageUUID;
        this.messageContent = messageContent;
        this.messageDate = messageDate;
        this.author = author;
    }

    public Message(String messageContent, String messageAuthorUUID, String messageChatUUID){
        this.messageContent = messageContent;
        this.messageAuthorUUID = messageAuthorUUID;
        this.messageChatUUID = messageChatUUID;

        messageUUID = UUID.randomUUID().toString();
        messageDate = String.valueOf(System.currentTimeMillis());
    }

    public Message(String messageUUID, String messageContent, String messageCreationDate, String messageAuthorUUID, String messageChatUUID){
        this.messageUUID = messageUUID;
        this.messageContent = messageContent;
        this.messageDate = messageCreationDate;
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
        return messageDate;
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

    public void setMessageCreationDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public void setMessageAuthorUUID(String messageAuthorUUID) {
        this.messageAuthorUUID = messageAuthorUUID;
    }

    public void setMessageChatUUID(String messageChatUUID) {
        this.messageChatUUID = messageChatUUID;
    }
}
