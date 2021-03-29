package Client.Model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-19
 */

public class ChatUserData {

    private Chat chat;
    private User user;
    private String nickName;
    private Role role;

    public ChatUserData(){}

    public ChatUserData(Chat chat, User user){
        this.chat = chat;
        this.user = user;

        nickName = user.getUserName();
        role = Role.STANDARD;
    }

    public ChatUserData(Chat chat, User user, String nickName, Role role) {
        this.chat = chat;
        this.user = user;
        this.nickName = nickName;
        this.role = role;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = Role.getRole(role);
    }
}
