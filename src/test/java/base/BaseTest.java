package base;

import core.Browser;
import core.WebDriverManagerSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.ui.pages.LoginPage;
import static configfile.Configuration.dotenv;

public class BaseTest {
    protected LoginPage loginPage;
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        this.driver = WebDriverManagerSingleton.getWebDriver(Browser.CHROME);
        driver.get(dotenv.get("BASE_URL"));
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManagerSingleton.quitDriver();
    }
}
