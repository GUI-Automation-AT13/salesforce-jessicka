package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This abstract class is the base page for all pages.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor method.
     *
     * @param driver with the driver needed.
     */
    public BasePage(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}
