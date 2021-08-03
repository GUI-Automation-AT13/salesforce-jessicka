package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of ProductPage.
 */
public class ProductPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement productTitle;

    @FindBy(xpath = "//span[text()='Created By']/../..//span[contains(@class,'uiOutputDateTime')]")
    private WebElement createdByDate;

    @FindBy(xpath = "//div/span[text()='Product Description']/../..//span/span")
    private WebElement descriptionTextArea;

    private By activeCheckBoxChecked = By.xpath("//span[contains(@data-aura-class, 'uiImage uiOutputCheckbox')]/img");
    private static final String SPAN_XPATH = "//div/span[text()='%s']/../..//span/span";

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));
    }

    /**
     * Gets the text of spans.
     *
     * @param fieldName the name of the field
     * @return the text of a span
     */
    public String getSpanText(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(String.format(SPAN_XPATH, fieldName))));
    }

    /**
     * Gets if product is active.
     *
     * @return true if it is active, false if not
     */
    public boolean isActive() {
        WebElement checkbox = driver.findElement(activeCheckBoxChecked);
        return  checkbox.getAttribute("alt").contains("True");

    }

    /**
     * Gets the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
        return webElementAction.getTextOfElement(descriptionTextArea);
    }

    /**
     * Verifies if an element is empty.
     *
     * @param fieldName the name of the field.
     * @return True if the element is empty, false otherwise.
     */
    public Boolean isEmpty(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(String.format(SPAN_XPATH, fieldName)))).isEmpty();
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    public String getUserSuccessMessage() {
        return webElementAction.getTextOfElement(successMessage);
    }

    /**
     * Gets the date in which the product was created.
     *
     * @return a String with the date.
     */
    public String getCreatedByDate() {
        return webElementAction.getTextOfElement(createdByDate);
    }

    /**
     * Gets the product tittle.
     *
     * @return a String with the tittle.
     */
    public String getProductTittle() {
        return webElementAction.getTextOfElement(productTitle);
    }
}
