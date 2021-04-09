package Client.Model;

/**
 * The type Chat user data.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 19
 */

public class ChatUserData {

    private Chat chat;
    private User user;
    private String nickName;
    private Role role;

    /**
     * Instantiates a new Chat user data.
     */
    public ChatUserData(){}

    /**
     * Instantiates a new Chat user data.
     *
     * @param chat the chat
     * @param user the user
     */
    public ChatUserData(Chat chat, User user){
        this.chat = chat;
        this.user = user;

        nickName = user.getUserName();
        role = Role.STANDARD;
    }

    /**
     * Instantiates a new Chat user data.
     *
     * @param chat     the chat
     * @param user     the user
     * @param nickName the nick name
     * @param role     the role
     */
    public ChatUserData(Chat chat, User user, String nickName, Role role) {
        this.chat = chat;
        this.user = user;
        this.nickName = nickName;
        this.role = role;
    }

    /**
     * Gets chat.
     *
     * @return the chat
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Sets chat.
     *
     * @param chat the chat
     */
    public void setChat(Chat chat) {
        this.chat = chat;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets nick name.
     *
     * @return the nick name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets nick name.
     *
     * @param nickName the nick name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(int role) {
        this.role = Role.getRole(role);
    }
}
