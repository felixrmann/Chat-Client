package Client.Model;

/**
 * The model class OverErrorMsg
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public class OverErrorMsg {

    private final ErrorMsg[] errors;

    /**
     * Instantiates a new Over error msg.
     *
     * @param errors the errors
     */
    public OverErrorMsg(ErrorMsg[] errors){
        this.errors = errors;
    }

    /**
     * Get error msg string.
     *
     * @return the string
     */
    public String getErrorMsg(){
        return errors[0].getMsg();
    }

    /**
     * Get param string.
     *
     * @return the string
     */
    public String getParam(){
        return errors[0].getParam();
    }

    /**
     * Get location string.
     *
     * @return the string
     */
    public String getLocation(){
        return errors[0].getLocation();
    }
}
