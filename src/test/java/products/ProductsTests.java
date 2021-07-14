package products;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.ProductPage;
import utils.SetUp;

public class ProductsTests extends BaseTest {

//    @Test
    public void testCreateProductWithJustRequiredFields() {
        ProductPage productPage = loginPage.loginSuccessfully(SetUp.USER_NAME_SALESFORCE.getValue(), SetUp.PASSWORD.getValue());
    }
}
