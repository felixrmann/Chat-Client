package Client.Model;

public class ErrorMsg {
    private String msg;
    private String param;
    private String location;

    public String getMsg() {
        return msg;
    }

    public ErrorMsg(String msg, String param, String location){
        this.msg = msg;
        this.param = param;
        this.location = location;
    }

    public ErrorMsg(String msg){
        this.msg = msg;
    }

    public String getParam() {
        return param;
    }

    public String getLocation() {
        return location;
    }
}
