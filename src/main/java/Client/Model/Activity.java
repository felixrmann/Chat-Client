package Client.Model;

/**
 * The enum Activity.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 31
 */

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

    /**
     * Gets activity int.
     *
     * @return the activity int
     */
    public int getActivityInt() {
        return activityInt;
    }

    /**
     * Get activity string.
     *
     * @return the string
     */
    public String getActivity(){
        return switch (activityInt) {
            case 1 -> "Online";
            case 2 -> "Idle";
            case 3 -> "Do not Disturb";
            case 4 -> "Invisible";
            default -> "Offline";
        };
    }

    /**
     * Get activity activity.
     *
     * @param activityInt the activity int
     * @return the activity
     */
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
