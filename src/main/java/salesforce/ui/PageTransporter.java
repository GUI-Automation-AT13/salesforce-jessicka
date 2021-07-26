package salesforce.ui;

import core.WebDriverManagerSingleton;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.ProductsPage;
import utils.SetUp;

/**
 * Controls navigation of pages.
 */
public class PageTransporter {

    /**
     * Redirects to new URL.
     *
     * @param url the new url direction
     */
    public void goToUrl(final String url) {
        WebDriverManagerSingleton.getInstance().getDriver().navigate().to(url);
    }

    /**
     * Navigates to Products Page.
     *
     * @return ProductsPage
     */
    public ProductsPage navigateToProductsPage() {
        goToUrl(SetUp.BASE_URL.getValue().concat(SetUp.PRODUCT_URL.getValue()));
        return new ProductsPage();
    }

    /**
     * Navigates to the login page.
     *
     * @return a LoginPage.
     */
    public LoginPage navigateToLoginPage() {
        goToUrl(SetUp.BASE_URL.getValue());
        return new LoginPage();
    }
}
