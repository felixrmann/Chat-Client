package Client.Model;

public class OverErrorMsg {

    private ErrorMsg[] errors;

    public OverErrorMsg(ErrorMsg[] errors){
        this.errors = errors;
    }

    public String getErrorMsg(){
        return errors[0].getMsg();
    }

    public String getParam(){
        return errors[0].getParam();
    }

    public String getLocation(){
        return errors[0].getLocation();
    }
}
