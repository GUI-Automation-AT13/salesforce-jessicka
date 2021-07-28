package cucumber.steps;

import core.WebDriverManagerSingleton;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.ProductPage;

public class Util {
    public LoginPage loginPage;
    public WebDriverManagerSingleton driverManager;
    public PageTransporter pageTransporter;
    public ProductPage productPage;
}
