package Client.Model;

public enum Activity {
    OFFLINE (0),
    ONLINE (1),
    IDLE (2),
    DONOTDISTURB (3),
    INVISIBLE (4);

    private final int activityInt;

    Activity(int activityInt){
        this.activityInt = activityInt;
    }

    public int getActivityInt() {
        return activityInt;
    }

    public String getActivity(){
        return switch (activityInt) {
            case 1 -> "Online";
            case 2 -> "Idle";
            case 3 -> "Do not Disturb";
            case 4 -> "Invisible";
            default -> "Offline";
        };
    }

    public static Activity getActivity(int activityInt){
        return switch (activityInt){
            case 1 -> ONLINE;
            case 2 -> IDLE;
            case 3 -> DONOTDISTURB;
            case 4 -> INVISIBLE;
            default -> OFFLINE;
        };
    }
}
