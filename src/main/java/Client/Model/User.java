package Client.Model;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-März-15
 */

public class User {

    private String userUUID;
    public String userName;
    public String userMail;
    public String userPassword;
    private String userImagePath;
    private Activity userActivityState;
    private String userCustomState;
    private ZonedDateTime userCreatedAt;
    public String userRefreshToken;

    public User(){}

    public User(String userName, String userMail, String userPassword){
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;

        userUUID = UUID.randomUUID().toString();
        userCreatedAt = ZonedDateTime.parse(Long.toString(System.currentTimeMillis()));
        userRefreshToken = UUID.randomUUID().toString();
    }

    public User(String userUUID, String userName, String userMail, String userPassword, String userImagePath, String userActivityState, String userCustomState, String userCreatedAt, String userRefreshToken){
        this.userUUID = userUUID;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userImagePath = userImagePath;
        this.userActivityState = Activity.getActivity(Integer.parseInt(userActivityState));
        this.userCustomState = userCustomState;
        this.userCreatedAt = ZonedDateTime.parse(userCreatedAt);
        this.userRefreshToken = userRefreshToken;
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

    public ZonedDateTime getUserCreatedAt() {
        return userCreatedAt;
    }

    public String getUserRefreshToken() {
        return userRefreshToken;
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
        userRefreshToken = "";
        userRefreshToken = UUID.randomUUID().toString();
    }

    public void setUserCustomState(String userCustomState) {
        this.userCustomState = userCustomState;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = ZonedDateTime.parse(userCreatedAt);
    }

    public void setUserRefreshToken(String userRefreshToken) {
        this.userRefreshToken = userRefreshToken;
    }
}
