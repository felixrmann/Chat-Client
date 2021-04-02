package Client.Model;

import java.util.UUID;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-15
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

    public User(){}
    
    public User(String userName, String userMail, String userPassword, String userToken){
        
    }

    public User(String userName, String userMail, String userPassword){
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;

        userUUID = UUID.randomUUID().toString();
        userCreatedAt = String.valueOf(System.currentTimeMillis());
        userToken = UUID.randomUUID().toString();
    }

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

    public String getUserUUID() {
        return userUUID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public String getUserActivityState() {
        return userActivityState.getActivity();
    }

    public String getUserCustomState() {
        return userCustomState;
    }

    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    public String getuserToken() {
        return userToken;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserActivityState(Activity userActivityState) {
        this.userActivityState = userActivityState;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setNewRefreshToken(){
        userToken = "";
        userToken = UUID.randomUUID().toString();
        //TODO wird von server geladen
    }

    public void setUserCustomState(String userCustomState) {
        this.userCustomState = userCustomState;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public void setuserToken(String userToken) {
        this.userToken = userToken;
    }
}
