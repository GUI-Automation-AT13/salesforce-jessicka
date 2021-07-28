package core;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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

    /**
     * Gets the text of a web element.
     *
     * @param webElement web element to get text.
     */
    public String getTextOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if an element is present.
     * Uses an interval time to wait and find the element and return true if it is present.
     *
     * @param by - Selector of element to Find.
     * @param intervalTime - Time in milliseconds to wait.
     * @return True if the element is present, false otherwise.
     */
    public boolean isElementPresent(final By by, final int intervalTime) {
        driver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
        }
    }
}
