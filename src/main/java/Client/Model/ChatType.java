package Client.Model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-15
 */

public enum ChatType {
    DIRECTMESSAGE (0),
    GROUPCHAT (1);

    private final int chatInt;

    ChatType(int chatInt){
        this.chatInt = chatInt;
    }

    public int getChatInt() {
        return chatInt;
    }

    public String getChatType(){
        return switch (chatInt) {
            case 0 -> "D";
            case 1 -> "G";
            default -> null;
        };
    }

    public static ChatType getChatType(int chatInt){
        return switch (chatInt){
            case 1 -> GROUPCHAT;
            default -> DIRECTMESSAGE;
        };
    }
}
