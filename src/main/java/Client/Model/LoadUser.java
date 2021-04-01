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
     * Convert to user user.
     * @return the user
     */
    public User convertToUser(){
       return new User(userName, userMail, userPassword, userToken);
    }
}
