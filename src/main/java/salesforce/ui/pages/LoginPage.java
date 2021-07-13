package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class returns an instance of LoginPage.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    /**
     * Sets the userName.
     *
     * @param userName to set
     */
    private void setUsername(final String userName) {
        userNameTextBox.sendKeys(userName);
    }

    /**
     * Sets the password.
     *
     * @param password to set
     */
    private void setPassword(final String password) {
        passwordTextBox.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    /**
     * Logs in successfully.
     *
     * @param userName to set
     * @param password to set
     *
     * @return a ProductPage instance
     */
    public ProductPage loginSuccessfully(final String userName, final String password) {
        setUsername(userName);
        setPassword(password);
        clickLoginButton();
        return new ProductPage(driver);
    }
}
