package cucumber.steps;

import core.WebDriverManagerSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.ProductPage;
import salesforce.ui.pages.product.ProductsPage;
import utils.SetUp;


public class Hooks {
//    public LoginPage loginPage;
//    public WebDriverManagerSingleton driverManager;
//    public PageTransporter pageTransporter;
//    public ProductPage productPage;

//    public Hooks(LoginPage loginPage, WebDriverManagerSingleton driverManager,PageTransporter pageTransporter, ProductPage productPage) {
//        this.loginPage = loginPage;
//        this.driverManager = driverManager;
//        this.pageTransporter = pageTransporter;
//        this.productPage = productPage;
//    }
    private Util util;

    public Hooks(Util util) {
        this.util = util;
    }

//    @Before
//    public void init() {
//        driverManager = WebDriverManagerSingleton.getInstance();
//        pageTransporter = new PageTransporter();
//        loginPage = pageTransporter.navigateToLoginPage();
//    }

    @Before
    public void init() {
        util.driverManager = WebDriverManagerSingleton.getInstance();
        util.pageTransporter = new PageTransporter();
        util.loginPage = util.pageTransporter.navigateToLoginPage();
    }

    @After
    public void tearDown() {
        WebDriverManagerSingleton.getInstance().quitDriver();
    }
}
