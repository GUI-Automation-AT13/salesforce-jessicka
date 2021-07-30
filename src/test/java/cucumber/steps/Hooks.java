package cucumber.steps;

import core.WebDriverManagerSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.ui.PageTransporter;

public class Hooks {

    private Util util;

    public Hooks(Util util) {
        this.util = util;
    }

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
