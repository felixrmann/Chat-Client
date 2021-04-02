package Client.Model;

import Client.DataHandler.ConfigLoader;

/**
 * File which saves the user Data
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2021 -April-01
 */
public class Config {
    private String mode;
    private final String baseURL;

    /**
     * Instantiates a new Config.
     *
     * @param mode the mode
     */
    public Config(String mode){
        this.mode = mode;
        baseURL = ConfigLoader.loadConfig().getBaseURL();
    }

    /**
     * Sets mode.
     *
     * @param mode the mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseURL() {
        return baseURL;
    }
}
