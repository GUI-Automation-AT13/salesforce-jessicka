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
     * @param url the new url direction.
     */
    public static void goToUrl(final String url) {
        WebDriverManagerSingleton.getInstance().getDriver().navigate().to(url);
    }

    /**
     * Redirects to the page given.
     *
     * @param pageName the name of the page.
     */
    public static void navigateToUrlByPageName(String pageName) {
        String baseUrl = SetUp.BASE_URL.getValue();
        goToUrl(baseUrl.concat(String.format(SetUp.FEATURE_URL.getValue(), pageName)));
    }

    /**
     * Navigates to Products Page.
     *
     * @return ProductsPage.
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
