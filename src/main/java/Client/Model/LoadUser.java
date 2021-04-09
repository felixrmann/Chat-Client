package Client.Model;

/**
 * The only purpose of this class is to make sure of a
 * smooth loading of all the json data in the DataHandler.java
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 30
 */

public class LoadUser {
    private String userToken;
    private String token;

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Gets user token.
     *
     * @return the user token
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Convert to user user.
     *
     * @return the user
     */
    public User convertToUser(){
       return new User(userToken);
    }
}
