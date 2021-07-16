package salesforce.ui;

import core.WebDriverManagerSingleton;
import salesforce.ui.pages.ProductPage;
import utils.SetUp;

/**
 * Controls navigation of pages.
 */
public class PageTransporter {

    public void goToUrl(final String url) {
        WebDriverManagerSingleton.getInstance().getDriver().navigate().to(url);
    }

    public ProductPage navigateToProductsPage() {
        goToUrl(SetUp.BASE_URL.getValue().concat(SetUp.PRODUCT_URL.getValue()));
        return new ProductPage();
    }
}
