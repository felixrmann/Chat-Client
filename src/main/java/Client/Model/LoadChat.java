package Client.Model;

/**
 * The type Load chat.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 05
 */

public class LoadChat {

    /**
     * The type Chats.
     */
    static class chats{
        /**
         * The Chats.
         */
        static chat[] chats;
    }

    /**
     * The type Chat.
     */
    static class chat{
        /**
         * The Id.
         */
        static String id;
        /**
         * The Name.
         */
        static String name;
        /**
         * The Type.
         */
        static int type;
        /**
         * The Image path.
         */
        static String imagePath;
    }

    /**
     * The type Message.
     */
    static class message {
        /**
         * The Id.
         */
        static String id;
        /**
         * The Content.
         */
        static String content;
        /**
         * The Date.
         */
        static String date;
        /**
         * The Author.
         */
        static author author;
    }

    /**
     * The type Author.
     */
    static class author {
        /**
         * The Id.
         */
        static String id;
        /**
         * The Username.
         */
        static String username;
        /**
         * The Avatar.
         */
        static String avatar;
    }

    public String toString() {
        return "chat:\tid: " + chat.id +
        "\n\t name: " + chat.name +
        "\n\t type: " + ChatType.getChatType(chat.type) +
        "\n\t name: " + chat.imagePath;
    }
}
