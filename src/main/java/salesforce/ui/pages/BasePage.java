package salesforce.ui.pages;

import core.WebDriverManagerSingleton;
import core.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This abstract class is the base page for all pages.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElementAction webElementAction;

    /**
     * Constructor method.
     */
    public BasePage() {
        this.driver = WebDriverManagerSingleton.getInstance().getDriver();
        wait = WebDriverManagerSingleton.getInstance().getWebDriverWait();
        webElementAction = new WebElementAction();
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}
