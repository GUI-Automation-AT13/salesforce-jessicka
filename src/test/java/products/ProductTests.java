package products;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import static org.testng.Assert.assertEquals;

public class ProductTests extends BaseTest {
    String productName = "Product to test";
    String productCode = "Product to test code";
    String productFamilyOption = "None";
    String productDescription = "Product to test description";

    @Test
    public void aProductIsCreatedWhenJustTheRequiredFormFieldsAreFilled() {
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage.productCreatedWithJustRequiredFields(productName);
        String actualResult = productPage.getProductTitle();
        assertEquals(productName, actualResult, "Product name is incorrect");
    }

    @Test
    public void aProductIsCreatedWhenAllFormFieldsAreFilled() {
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage.productCreatedWithAllFieldsFilled(productName, productCode, productFamilyOption, productDescription);
        assertEquals(productName, productPage.getProductName(), "Product name is incorrect");
        assertEquals(productCode, productPage.getProductCode(), "Product code is incorrect");
        assertEquals(productFamilyOption, productPage.getProductFamily(), "Product family is incorrect");
        assertEquals(productDescription, productPage.getProductDescription(), "Product description is incorrect");
    }
}
