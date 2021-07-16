package products;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.ProductPage;
import utils.SetUp;

public class ProductsTests extends BaseTest {

    @Test
    public void testCreateProductWithJustRequiredFields() {
        loginPage = new LoginPage();
        HomePage homePage = loginPage.loginSuccessfully(SetUp.USER_NAME_SALESFORCE.getValue(), SetUp.PASSWORD.getValue());

        ProductPage productPage = pageTransporter.navigateToProductsPage();
    }
}
