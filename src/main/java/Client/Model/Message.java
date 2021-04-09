package Client.Model;

import java.util.UUID;

/**
 * The model class Message
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public class Message {

    private String messageUUID;
    private String messageContent;
    private String messageDate;
    private String messageAuthorUUID;
    private String messageChatUUID;
    private User author;

    /**
     * Instantiates a new Message.
     *
     * @param messageUUID    the message uuid
     * @param messageContent the message content
     * @param messageDate    the message date
     * @param author         the author
     */
    public Message(String messageUUID, String messageContent, String messageDate, User author){
        this.messageUUID = messageUUID;
        this.messageContent = messageContent;
        this.messageDate = messageDate;
        this.author = author;
    }

    /**
     * Instantiates a new Message.
     *
     * @param messageContent    the message content
     * @param messageAuthorUUID the message author uuid
     * @param messageChatUUID   the message chat uuid
     */
    public Message(String messageContent, String messageAuthorUUID, String messageChatUUID){
        this.messageContent = messageContent;
        this.messageAuthorUUID = messageAuthorUUID;
        this.messageChatUUID = messageChatUUID;

        messageUUID = UUID.randomUUID().toString();
        messageDate = String.valueOf(System.currentTimeMillis());
    }

    /**
     * Instantiates a new Message.
     *
     * @param messageUUID         the message uuid
     * @param messageContent      the message content
     * @param messageCreationDate the message creation date
     * @param messageAuthorUUID   the message author uuid
     * @param messageChatUUID     the message chat uuid
     */
    public Message(String messageUUID, String messageContent, String messageCreationDate, String messageAuthorUUID, String messageChatUUID){
        this.messageUUID = messageUUID;
        this.messageContent = messageContent;
        this.messageDate = messageCreationDate;
        this.messageAuthorUUID = messageAuthorUUID;
        this.messageChatUUID = messageChatUUID;
    }

    /**
     * Gets message uuid.
     *
     * @return the message uuid
     */
    public String getMessageUUID() {
        return messageUUID;
    }

    /**
     * Gets message content.
     *
     * @return the message content
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * Gets message creation date.
     *
     * @return the message creation date
     */
    public String getMessageCreationDate() {
        return messageDate;
    }

    /**
     * Gets message author uuid.
     *
     * @return the message author uuid
     */
    public String getMessageAuthorUUID() {
        return messageAuthorUUID;
    }

    /**
     * Gets message chat uuid.
     *
     * @return the message chat uuid
     */
    public String getMessageChatUUID() {
        return messageChatUUID;
    }

    /**
     * Sets message uuid.
     *
     * @param messageUUID the message uuid
     */
    public void setMessageUUID(String messageUUID) {
        this.messageUUID = messageUUID;
    }

    /**
     * Sets message content.
     *
     * @param messageContent the message content
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * Sets message creation date.
     *
     * @param messageDate the message date
     */
    public void setMessageCreationDate(String messageDate) {
        this.messageDate = messageDate;
    }

    /**
     * Sets message author uuid.
     *
     * @param messageAuthorUUID the message author uuid
     */
    public void setMessageAuthorUUID(String messageAuthorUUID) {
        this.messageAuthorUUID = messageAuthorUUID;
    }

    /**
     * Sets message chat uuid.
     *
     * @param messageChatUUID the message chat uuid
     */
    public void setMessageChatUUID(String messageChatUUID) {
        this.messageChatUUID = messageChatUUID;
    }
}
