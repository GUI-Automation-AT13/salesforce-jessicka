package products;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import static org.testng.Assert.assertEquals;

public class ProductTests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    String productName = "Product to test";
    String productCode = "Product to test code";
    String productFamilyOption = "None";
    String productDescription = "Product to test description";

//    @Test
//    public void aProductIsCreatedWhenJustTheRequiredFormFieldsAreFilled() {
//        NewProductPage newProductPage = productsPage.clickNewProductButton();
//        ProductPage productPage = newProductPage.productCreatedWithJustRequiredFields(productName);
//        String actualResult = productPage.getProductTitle();
//        assertEquals(productName, actualResult, "Product name is incorrect");
//    }
//
//    @Test
//    public void aProductIsCreatedWhenAllFormFieldsAreFilled() {
//        NewProductPage newProductPage = productsPage.clickNewProductButton();
//        ProductPage productPage = newProductPage.productCreatedWithAllFieldsFilled(productName, productCode, productFamilyOption, productDescription);
//        assertEquals(productName, productPage.getProductName(), "Product name is incorrect");
//        assertEquals(productCode, productPage.getProductCode(), "Product code is incorrect");
//        assertEquals(productFamilyOption, productPage.getProductFamily(), "Product family is incorrect");
//        assertEquals(productDescription, productPage.getProductDescription(), "Product description is incorrect");
//    }

    @Test
    public void aProductIsCreatedWhenJustTheRequiredFormFieldsAreFilled() {
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage.setInputField("Product Name", productName).clickSaveButton();
        String actualResult = productPage.getSpanText("Product Name");
        softAssert.assertEquals(productPage.getUserSuccessMessage(), "success\nProduct \"" + productName + "\" was created.\nClose", "Message is incorrect");
        softAssert.assertEquals(productName, actualResult, "Product name is incorrect");
        softAssert.assertAll();
    }

    @Test
    public void aProductIsCreatedWhenAllFormFieldsAreFilled() {
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage
                .setInputField("Product Name", productName)
                .clickActiveCheckBox()
                .setInputField("Product Code", productCode)
                .selectProductFamilyOption(productFamilyOption)
                .setProductDescription(productDescription)
                .clickSaveButton();
        softAssert.assertEquals(productPage.getUserSuccessMessage(), "success\nProduct \"" + productName + "\" was created.\nClose", "Message is incorrect");
        softAssert.assertEquals(productName, productPage.getSpanText("Product Name"), "Product name is incorrect");
        softAssert.assertEquals(productCode, productPage.getSpanText("Product Code"), "Product code is incorrect");
        softAssert.assertEquals(productFamilyOption, productPage.getSpanText("Product Family"), "Product family is incorrect");
        softAssert.assertEquals(productDescription, productPage.getSpanText("Product Description"), "Product description is incorrect");
        softAssert.assertAll();
    }
}
