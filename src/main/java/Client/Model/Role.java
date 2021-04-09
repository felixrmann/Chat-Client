package Client.Model;

/**
 * The enum Role
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */

public enum Role {

    STANDARD(0),
    MODERATOR(1),
    ADMINISTRATOR(2);

    private final int roleInt;

    Role(int roleInt){
        this.roleInt = roleInt;
    }

    /**
     * Gets role int.
     *
     * @return the role int
     */
    public int getRoleInt() {
        return roleInt;
    }

    /**
     * Get role string.
     *
     * @return the string
     */
    public String getRole(){
        return switch (roleInt){
            case 1 -> "MODERATOR";
            case 2 -> "ADMINISTRATOR";
            default -> "STANDARD";
        };
    }

    /**
     * Get role role.
     *
     * @param roleInt the role int
     * @return the role
     */
    public static Role getRole(int roleInt){
        return switch (roleInt){
            case 1 -> MODERATOR;
            case 2 -> ADMINISTRATOR;
            default -> STANDARD;
        };
    }
}
