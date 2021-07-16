package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helps with filling the web elements.
 */
public class WebElementAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebElementAction() {
        driver = WebDriverManagerSingleton.getInstance().getDriver();
        wait = WebDriverManagerSingleton.getInstance().getWebDriverWait();
    }

    /**
     * Sets a webElement with a value.
     *
     * @param webElement that will be set.
     * @param text value that will set.
     */
    public void setInputField(final WebElement webElement, final String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Clicks a webElement.
     *
     * @param webElement is what we want to click.
     */
    public void clickField(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
}
