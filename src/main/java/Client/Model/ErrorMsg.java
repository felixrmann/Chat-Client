package Client.Model;

/**
 * The type Error msg.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - April - 01
 */

public class ErrorMsg {
    private final String msg;
    private String param;
    private String location;

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Instantiates a new Error msg.
     *
     * @param msg      the msg
     * @param param    the param
     * @param location the location
     */
    public ErrorMsg(String msg, String param, String location){
        this.msg = msg;
        this.param = param;
        this.location = location;
    }

    /**
     * Instantiates a new Error msg.
     *
     * @param msg the msg
     */
    public ErrorMsg(String msg){
        this.msg = msg;
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    public String getParam() {
        return param;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }
}
