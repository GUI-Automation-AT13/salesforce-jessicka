package salesforce.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of ProductsPage.
 */
public class ProductsPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement newProductButton;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newProductButton));
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    public NewProductPage clickNewProductButton() {
        webElementAction.clickField(newProductButton);
        return new NewProductPage();
    }
}
