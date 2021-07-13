package products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.ui.pages.ProductPage;
import static configfile.Configuration.dotenv;

public class ProductsTests extends BaseTest {

    @Test
    public void testCreateProductWithJustRequiredFields() {
        ProductPage productPage = loginPage.loginSuccessfully(dotenv.get("USER_NAME_SALESFORCE"), dotenv.get("PASSWORD"));
    }
}
