package Client.Model;

/**
 * The only purpose of this class is to make sure of a
 * smooth loading of all the json data in the DataHandler.java
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 -März-30
 */
public class LoadUser {
    private String userName;
    private String userMail;
    private String userPassword;
    private String userToken;

    /**
     * Gets user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets user mail.
     * @return the user mail
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * Gets user password.
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Gets user token.
     * @return the user token
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Convert to user user.
     * @return the user
     */
    public User convertToUser(){
       return new User(userName, userMail, userPassword, userToken);
    }
}
