package Client.Model;

/**
 * The enum Result
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 - March - 15
 */
public enum Result {

    SUCCESS(0),
    NOACTION(1),
    DUPLICATE(2),
    ERROR(3);

    private int code;

    Result(int code) {
        this.setCode(code);
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }
}