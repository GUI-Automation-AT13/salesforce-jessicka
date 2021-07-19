package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of NewProductForm.
 */
public class NewProductPage extends BasePage {

    @FindBy(css = ".forceActionButton:nth-child(3) > .label")
    private WebElement saveButton;

    @FindBy(xpath = "((//div[contains(@class,'slds-grid slds-gutters_small')])[1]/div)[1]//input")
    private WebElement productNameTextBox;

    @FindBy(xpath = "((//div[contains(@class,'slds-grid slds-gutters_small')])[1]/div)[2]//input")
    private WebElement activeCheckBox;

    @FindBy(xpath = "((//div[contains(@class,'slds-grid slds-gutters_small')])[2]/div)[1]//input")
    private WebElement productCodeTextBox;

    @FindBy(xpath = "((//div[contains(@class,'slds-grid slds-gutters_small')])[2]/div)[2]//a")
    private WebElement productFamilyComboBox;

    @FindBy(xpath = "(//div[contains(@class,'slds-grid slds-gutters_small')])[3]/div//textarea")
    private WebElement productDescriptionTextArea;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
    }

    /**
     * Sets the productName.
     *
     * @param productName to set
     */
    private void setProductName(final String productName) {
        webElementAction.setInputField(productNameTextBox, productName);
    }

    /**
     * Clicks on active CheckBox.
     */
    private void clickActiveCheckBox() {
        webElementAction.clickField(activeCheckBox);
    }

    /**
     * Sets the productCode.
     *
     * @param productCode to set
     */
    private void setProductCode(final String productCode) {
        webElementAction.setInputField(productCodeTextBox, productCode);
    }

    /**
     * Selects an option of the productFamily combo box.
     *
     * @param productFamilyOption the option to select
     */
    private void selectProductFamilyOption(final String productFamilyOption) {
        webElementAction.clickField(productFamilyComboBox);
        driver.findElement(By.linkText(productFamilyOption)).click();
    }

    /**
     * Sets the productDescription.
     *
     * @param productDescription to set
     */
    private void setProductDescription(final String productDescription) {
        webElementAction.setInputField(productDescriptionTextArea, productDescription);
    }

    /**
     * Clicks on Save button.
     */
    private void clickSaveButton() {
        webElementAction.clickField(saveButton);
    }

    /**
     * Creates a product with all its fields filled.
     *
     * @param productName to set
     * @param productCode to set
     * @param productFamilyOption to set
     * @param productDescription to set
     *
     * @return a new ProductPage
     */
    public ProductPage productCreatedWithAllFieldsFilled(final String productName,
                                                         final String productCode,
                                                         final String productFamilyOption,
                                                         final String productDescription) {
        setProductName(productName);
        clickActiveCheckBox();
        setProductCode(productCode);
        selectProductFamilyOption(productFamilyOption);
        setProductDescription(productDescription);
        clickSaveButton();
        return new ProductPage();
    }

    /**
     * Creates a product with just the required fields filled.
     *
     * @param productName to set
     *
     * @return a new ProductPage
     */
    public ProductPage productCreatedWithJustRequiredFields(final String productName) {
        setProductName(productName);
        clickSaveButton();
        return new ProductPage();
    }
}
