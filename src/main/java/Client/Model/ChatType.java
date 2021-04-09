package Client.Model;

/**
 * The enum ChatType
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public enum ChatType {

    DIRECTMESSAGE (0),
    GROUPCHAT (1);

    private final int chatInt;

    ChatType(int chatInt){
        this.chatInt = chatInt;
    }

    /**
     * Gets chat int.
     *
     * @return the chat int
     */
    public int getChatInt() {
        return chatInt;
    }

    /**
     * Get chat type string.
     *
     * @return the string
     */
    public String getChatType(){
        return switch (chatInt) {
            case 0 -> "D";
            case 1 -> "G";
            default -> null;
        };
    }

    /**
     * Get chat type chat type.
     *
     * @param chatInt the chat int
     * @return the chat type
     */
    public static ChatType getChatType(int chatInt){
        if (chatInt == 1) return GROUPCHAT;
        else return DIRECTMESSAGE;
    }
}
