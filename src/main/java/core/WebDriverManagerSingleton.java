package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SetUp;

/**
 * This class defines WebDriver.
 */
public class WebDriverManagerSingleton {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    private static WebDriverManagerSingleton instance = null;

    /**
     * Constructor of page WebDriverManagerSingleton.
     */
    public WebDriverManagerSingleton() {
        initialize();
    }

    /**
     * Gets an instance of WebDriver according to browser.
     *
     * @param browser enum with the browser name.
     * @return an instance of WebDriver
     */
    public WebDriver getWebDriver(String browser) {
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
        }

        return driver;
    }

    /**
     * Initializes the settings for the driver.
     */
    public  void initialize() {
        DriverManagerType driverManagerType = DriverManagerType.valueOf(SetUp.BROWSER.getValue());
        WebDriverManager.getInstance(driverManagerType).setup();
        this.driver = getWebDriver(SetUp.BROWSER.getValue());
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts()
                .implicitlyWait(Long.parseLong(SetUp.WAIT_TIME_VALUE.getValue()), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, Long.parseLong(SetUp.WAIT_TIME_VALUE.getValue()),
                Long.parseLong(SetUp.WAIT_SLEEP_TIME.getValue()));
    }

    /**
     * Gets Instance of WebDriverManagerSingleton.
     *
     * @return instance of WebDriverManagerSingleton.
     */
    public static WebDriverManagerSingleton getInstance() {
        if (instance == null || instance.driver == null) {
            instance = new WebDriverManagerSingleton();
        }
        return instance;
    }

    /**
     * Gets the WebDriver.
     *
     * @return the WebDriver.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets the WebDriverWait.
     *
     * @return the WebDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void closeDriver() {
        driver.close();
        driver = null;
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
