package core;

/**
 * This enum defines browsers.
 */
public enum Browser {
    CHROME("CHROME"), EDGE("EDGE"), FIREFOX("FIREFOX");

    private String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return this.browser;
    }
}
