package Client.Model;

public enum Role {
    STANDARD(0),
    MODERATOR(1),
    ADMINISTRATOR(2);

    private int roleInt;

    Role(int roleInt){
        this.roleInt = roleInt;
    }

    public int getRoleInt() {
        return roleInt;
    }

    public String getRole(){
        return switch (roleInt){
            case 1 -> "MODERATOR";
            case 2 -> "ADMINISTRATOR";
            default -> "STANDARD";
        };
    }

    public static Role getRole(int roleInt){
        return switch (roleInt){
            case 1 -> MODERATOR;
            case 2 -> ADMINISTRATOR;
            default -> STANDARD;
        };
    }
}
