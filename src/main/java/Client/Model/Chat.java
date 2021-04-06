package Client.Model;

import java.util.UUID;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-15
 */

public class Chat {

    private String chatUUID;
    private String chatName;
    private String chatDescription;
    private String chatImagePath;
    private String chatCreatedAt;
    private ChatType chatType;
    private Message lastMessage;

    public Chat(){}

    public Chat(String chatUUID, String chatName, int chatType, String chatImagePath, Message lastMessage){
        this.chatUUID = chatUUID;
        this.chatName = chatName;
        this.chatType = ChatType.getChatType(chatType);
        this.chatImagePath = chatImagePath;
        this.lastMessage = lastMessage;
    }

    public Chat (String chatName, ChatType chatType){
        this.chatName = chatName;
        this.chatType = chatType;

        chatUUID = UUID.randomUUID().toString();
        chatCreatedAt = String.valueOf(System.currentTimeMillis());
    }

    public Chat (String chatUUID, String chatName, String chatDescription, String chatImagePath, String chatCreatedAt, String chatType){
        this.chatUUID = chatUUID;
        this.chatName = chatName;
        this.chatDescription = chatDescription;
        this.chatImagePath = chatImagePath;
        this.chatCreatedAt = chatCreatedAt;
        this.chatType = ChatType.getChatType(Integer.parseInt(chatType));
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setChatDescription(String chatDescription) {
        this.chatDescription = chatDescription;
    }

    public void setChatUUID(String chatUUID) {
        this.chatUUID = chatUUID;
    }

    public void setChatImagePath(String chatImagePath) {
        this.chatImagePath = chatImagePath;
    }

    public void setChatCreatedAt(String chatCreatedAt) {
        this.chatCreatedAt = chatCreatedAt;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public String getChatUUID() {
        return chatUUID;
    }

    public String getChatName() {
        return chatName;
    }

    public String getChatDescription() {
        return chatDescription;
    }

    public String getChatImagePath() {
        return chatImagePath;
    }

    public String getChatCreatedAt() {
        return chatCreatedAt;
    }

    public String  getChatType() {
        return chatType.getChatType();
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Message getLastMessage() {
        return lastMessage;
    }
}
