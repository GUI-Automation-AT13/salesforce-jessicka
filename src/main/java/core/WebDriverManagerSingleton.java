package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class defines WebDriver.
 */
public class WebDriverManagerSingleton {
    public static WebDriver driver;

    /**
     * Gets an instance of WebDriver according to browser.
     *
     * @param browser enum with the browser name.
     * @return an instance of WebDriver
     */
    public static WebDriver getWebDriver(Browser browser) {
        if (driver == null) {
            if (browser == Browser.CHROME) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            if (browser == Browser.EDGE) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            if (browser == Browser.FIREFOX) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
