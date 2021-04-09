package Client.Model;

/**
 * The model class User
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public class User {

    private String userUUID;
    private String userName;
    private String userMail;
    private String userPassword;
    private String userImagePath;
    private Activity userActivityState;
    private String userCustomState;
    private String userCreatedAt;
    private String userToken;

    /**
     * Instantiates a new User.
     */
    public User(){}

    /**
     * Instantiates a new User.
     *
     * @param userToken the user token
     */
    public User(String userToken){
        this.userToken = userToken;
    }

    /**
     * Instantiates a new User.
     *
     * @param userUUID      the user uuid
     * @param userName      the user name
     * @param userImagePath the user image path
     */
    public User(String userUUID, String userName, String userImagePath) {
        this.userUUID = userUUID;
        this.userName = userName;
        this.userImagePath = userImagePath;
    }

    /**
     * Instantiates a new User.
     *
     * @param userUUID          the user uuid
     * @param userName          the user name
     * @param userMail          the user mail
     * @param userPassword      the user password
     * @param userImagePath     the user image path
     * @param userActivityState the user activity state
     * @param userCustomState   the user custom state
     * @param userCreatedAt     the user created at
     * @param userToken         the user token
     */
    public User(String userUUID, String userName, String userMail, String userPassword, String userImagePath, String userActivityState, String userCustomState, String userCreatedAt, String userToken){
        this.userUUID = userUUID;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userImagePath = userImagePath;
        this.userActivityState = Activity.getActivity(Integer.parseInt(userActivityState));
        this.userCustomState = userCustomState;
        this.userCreatedAt = userCreatedAt;
        this.userToken = userToken;
    }

    /**
     * Gets user uuid.
     *
     * @return the user uuid
     */
    public String getUserUUID() {
        return userUUID;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets user mail.
     *
     * @return the user mail
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Gets user image path.
     *
     * @return the user image path
     */
    public String getUserImagePath() {
        return userImagePath;
    }

    /**
     * Gets user activity state.
     *
     * @return the user activity state
     */
    public String getUserActivityState() {
        return userActivityState.getActivity();
    }

    /**
     * Gets user custom state.
     *
     * @return the user custom state
     */
    public String getUserCustomState() {
        return userCustomState;
    }

    /**
     * Gets user created at.
     *
     * @return the user created at
     */
    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getuserToken() {
        return userToken;
    }

    /**
     * Sets user uuid.
     *
     * @param userUUID the user uuid
     */
    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets user activity state.
     *
     * @param userActivityState the user activity state
     */
    public void setUserActivityState(Activity userActivityState) {
        this.userActivityState = userActivityState;
    }

    /**
     * Sets user mail.
     *
     * @param userMail the user mail
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Set new refresh token.
     */
    public void setNewRefreshToken(){
        //TODO wird von server geladen
    }

    /**
     * Sets user custom state.
     *
     * @param userCustomState the user custom state
     */
    public void setUserCustomState(String userCustomState) {
        this.userCustomState = userCustomState;
    }

    /**
     * Sets user image path.
     *
     * @param userImagePath the user image path
     */
    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    /**
     * Sets user created at.
     *
     * @param userCreatedAt the user created at
     */
    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    /**
     * Sets token.
     *
     * @param userToken the user token
     */
    public void setuserToken(String userToken) {
        this.userToken = userToken;
    }
}
