package base;

import core.WebDriverManagerSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.ProductsPage;
import utils.SetUp;

public class BaseTest {
    protected LoginPage loginPage;
    protected WebDriverManagerSingleton webDriverManagerSingleton;
    protected PageTransporter pageTransporter;

    protected ProductsPage productsPage;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        pageTransporter = new PageTransporter();
        webDriverManagerSingleton = WebDriverManagerSingleton.getInstance();
        loginPage = pageTransporter.navigateToLoginPage();
        homePage = loginPage.loginSuccessfully(SetUp.USER_NAME_SALESFORCE.getValue(), SetUp.PASSWORD.getValue());
        productsPage = pageTransporter.navigateToProductsPage();
    }

    @AfterTest
    public void tearDown() {
        WebDriverManagerSingleton.getInstance().quitDriver();
    }
}
