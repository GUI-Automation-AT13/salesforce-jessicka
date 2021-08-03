package cucumber.steps;

import core.WebDriverManagerSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.entities.Product;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;

public class Hooks {
    private Product product;
    public LoginPage loginPage;
    public WebDriverManagerSingleton driverManager;
    public PageTransporter pageTransporter;

    public Hooks(Product product) {
        this.product = product;
    }

    @Before
    public void init() {
        driverManager = WebDriverManagerSingleton.getInstance();
        pageTransporter = new PageTransporter();
        loginPage = pageTransporter.navigateToLoginPage();
    }

    @After
    public void tearDown() {
        WebDriverManagerSingleton.getInstance().quitDriver();
    }
}
