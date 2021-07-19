package salesforce.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of ProductPage.
 */
public class ProductPage extends BasePage {

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement productTitle;

    @FindBy(xpath = "(//span[contains(@class,'test-id__field-value')]/span[not(contains(@class,'uiOutputDateTime'))])[1]")
    private WebElement productNameSpan;

    @FindBy(css = "img.checked")
    private WebElement activeCheckBoxChecked;

    @FindBy(css = "img.unchecked")
    private WebElement activeCheckBoxUnchecked;

    @FindBy(xpath = "(//span[contains(@class,'test-id__field-value')]/span[not(contains(@class,'uiOutputDateTime'))])[3]")
    private WebElement productCodeSpan;

    @FindBy(xpath = "(//span[contains(@class,'test-id__field-value')]/span[not(contains(@class,'uiOutputDateTime'))])[4]")
    private WebElement productFamilySpan;

    @FindBy(xpath = "(//span[contains(@class,'test-id__field-value')]/span[not(contains(@class,'uiOutputDateTime'))])[5]")
    private WebElement productDescriptionSpan;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));
    }

    /**
     * Gets the title message.
     *
     * @return a String with the message.
     */
    public String getProductTitle() {
        return webElementAction.getTextOfElement(productTitle);
    }

    /**
     * Gets the product name.
     *
     * @return a String with the product name.
     */
    public String getProductName() {
        return webElementAction.getTextOfElement(productNameSpan);
    }

    /**
     * Gets the product code.
     *
     * @return a String with the product code.
     */
    public String getProductCode() {
        return webElementAction.getTextOfElement(productCodeSpan);
    }

    /**
     * Gets the product family.
     *
     * @return a String with the product family.
     */
    public String getProductFamily() {
        return webElementAction.getTextOfElement(productFamilySpan);
    }

    /**
     * Gets the product description.
     *
     * @return a String with the product description.
     */
    public String getProductDescription() {
        return webElementAction.getTextOfElement(productDescriptionSpan);
    }
}
