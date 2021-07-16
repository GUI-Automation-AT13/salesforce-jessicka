package base;

import core.WebDriverManagerSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import utils.SetUp;

public class BaseTest {
    protected LoginPage loginPage;
    protected WebDriver driver;
    protected WebDriverManagerSingleton webDriverManagerSingleton;
    protected PageTransporter pageTransporter;

    @BeforeClass
    public void setUp() {
        webDriverManagerSingleton = WebDriverManagerSingleton.getInstance();
        this.driver = webDriverManagerSingleton.getDriver();
        driver.get(SetUp.BASE_URL.getValue());
        pageTransporter = new PageTransporter();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManagerSingleton.getInstance().getDriver().quit();
    }
}
