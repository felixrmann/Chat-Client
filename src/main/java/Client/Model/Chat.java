package Client.Model;

import java.util.UUID;

/**
 * The type Chat.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public class Chat {

    private String chatUUID;
    private String chatName;
    private String chatDescription;
    private String chatImagePath;
    private String chatCreatedAt;
    private ChatType chatType;
    private Message lastMessage;

    /**
     * Instantiates a new Chat.
     */
    public Chat(){}

    /**
     * Instantiates a new Chat.
     *
     * @param chatUUID      the chat uuid
     * @param chatName      the chat name
     * @param chatType      the chat type
     * @param chatImagePath the chat image path
     * @param lastMessage   the last message
     */
    public Chat(String chatUUID, String chatName, int chatType, String chatImagePath, Message lastMessage){
        this.chatUUID = chatUUID;
        this.chatName = chatName;
        this.chatType = ChatType.getChatType(chatType);
        this.chatImagePath = chatImagePath;
        this.lastMessage = lastMessage;
    }

    /**
     * Instantiates a new Chat.
     *
     * @param chatName the chat name
     * @param chatType the chat type
     */
    public Chat (String chatName, ChatType chatType){
        this.chatName = chatName;
        this.chatType = chatType;

        chatUUID = UUID.randomUUID().toString();
        chatCreatedAt = String.valueOf(System.currentTimeMillis());
    }

    /**
     * Instantiates a new Chat.
     *
     * @param chatUUID        the chat uuid
     * @param chatName        the chat name
     * @param chatDescription the chat description
     * @param chatImagePath   the chat image path
     * @param chatCreatedAt   the chat created at
     * @param chatType        the chat type
     */
    public Chat (String chatUUID, String chatName, String chatDescription, String chatImagePath, String chatCreatedAt, String chatType){
        this.chatUUID = chatUUID;
        this.chatName = chatName;
        this.chatDescription = chatDescription;
        this.chatImagePath = chatImagePath;
        this.chatCreatedAt = chatCreatedAt;
        this.chatType = ChatType.getChatType(Integer.parseInt(chatType));
    }

    /**
     * Sets chat name.
     *
     * @param chatName the chat name
     */
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    /**
     * Sets chat description.
     *
     * @param chatDescription the chat description
     */
    public void setChatDescription(String chatDescription) {
        this.chatDescription = chatDescription;
    }

    /**
     * Sets chat uuid.
     *
     * @param chatUUID the chat uuid
     */
    public void setChatUUID(String chatUUID) {
        this.chatUUID = chatUUID;
    }

    /**
     * Sets chat image path.
     *
     * @param chatImagePath the chat image path
     */
    public void setChatImagePath(String chatImagePath) {
        this.chatImagePath = chatImagePath;
    }

    /**
     * Sets chat created at.
     *
     * @param chatCreatedAt the chat created at
     */
    public void setChatCreatedAt(String chatCreatedAt) {
        this.chatCreatedAt = chatCreatedAt;
    }

    /**
     * Sets chat type.
     *
     * @param chatType the chat type
     */
    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    /**
     * Gets chat uuid.
     *
     * @return the chat uuid
     */
    public String getChatUUID() {
        return chatUUID;
    }

    /**
     * Gets chat name.
     *
     * @return the chat name
     */
    public String getChatName() {
        return chatName;
    }

    /**
     * Gets chat description.
     *
     * @return the chat description
     */
    public String getChatDescription() {
        return chatDescription;
    }

    /**
     * Gets chat image path.
     *
     * @return the chat image path
     */
    public String getChatImagePath() {
        return chatImagePath;
    }

    /**
     * Gets chat created at.
     *
     * @return the chat created at
     */
    public String getChatCreatedAt() {
        return chatCreatedAt;
    }

    /**
     * Gets chat type.
     *
     * @return the chat type
     */
    public String  getChatType() {
        return chatType.getChatType();
    }

    /**
     * Sets last message.
     *
     * @param lastMessage the last message
     */
    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    /**
     * Gets last message.
     *
     * @return the last message
     */
    public Message getLastMessage() {
        return lastMessage;
    }
}
