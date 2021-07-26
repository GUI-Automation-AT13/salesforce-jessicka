package utils;

import static configfile.Configuration.dotenv;

/**
 * This enum defines setUp values.
 */
public enum SetUp {
    BASE_URL(dotenv.get("BASE_URL")),
    PRODUCT_URL(dotenv.get("PRODUCT_URL")),
    USER_NAME_SALESFORCE(dotenv.get("USER_NAME_SALESFORCE")),
    PASSWORD(dotenv.get("PASSWORD")),
    WAIT_TIME_VALUE(dotenv.get("WAIT_TIME_VALUE")),
    BROWSER(dotenv.get("BROWSER")),
    WAIT_SLEEP_TIME(dotenv.get("WAIT_SLEEP_TIME"));

    private String value;

    SetUp(String value) {
        this.value =  value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
