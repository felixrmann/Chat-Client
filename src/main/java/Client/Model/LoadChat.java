package Client.Model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-05
 */

public class LoadChat {

    static class chats{
        static chat[] chats;
    }

    static class chat{
        static String id;
        static String name;
        static int type;
        static String imagePath;
    }

    static class message {
        static String id;
        static String content;
        static String date;
        static author author;
    }

    static class author {
        static String id;
        static String username;
        static String avatar;
    }

    public String toString() {
        return "chat:\tid: " + chat.id +
        "\n\t name: " + chat.name +
        "\n\t type: " + ChatType.getChatType(chat.type) +
        "\n\t name: " + chat.imagePath;
    }
}
