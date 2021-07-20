package products;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import salesforce.ui.pages.product.ProductsPage;
import utils.StringToDate;
import java.text.SimpleDateFormat;

public class ProductTests extends BaseTest {
    private StringToDate stringToDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy HH:mm");
    SoftAssert softAssert = new SoftAssert();
    String productName = "Product to test";
    String productCode = "Product to test code";
    String productFamilyOption = "None";
    String productDescription = "Product to test description";

    @Test
    public void aProductIsCreatedWhenJustTheRequiredFormFieldsAreFilled() {
        stringToDate = new StringToDate();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage.setInputField("Product Name", productName).clickSaveButton();
        String actualDate = dateFormat.format(stringToDate.getTodayDate());
        String actualResult = productPage.getSpanText("Product Name");
        softAssert.assertEquals(productPage.getUserSuccessMessage(), "success\nProduct \"" + productName + "\" was created.\nClose", "Message is incorrect");
        softAssert.assertEquals(productName, actualResult, "Product name is incorrect");
        softAssert.assertEquals(actualDate, productPage.getCreatedByDate());
        productsPage = pageTransporter.navigateToProductsPage();
        softAssert.assertEquals(productName, productsPage.getProductName(productName), "Product does not exist");
        softAssert.assertAll();
    }

    @Test
    public void aProductIsCreatedWhenAllFormFieldsAreFilled() {
        stringToDate = new StringToDate();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        ProductPage productPage = newProductPage
                .setInputField("Product Name", productName)
                .clickActiveCheckBox()
                .setInputField("Product Code", productCode)
                .selectProductFamilyOption(productFamilyOption)
                .setProductDescription(productDescription)
                .clickSaveButton();
        String actualDate = dateFormat.format(stringToDate.getTodayDate());
        softAssert.assertEquals(productPage.getUserSuccessMessage(), "success\nProduct \"" + productName + "\" was created.\nClose", "Message is incorrect");
        softAssert.assertEquals(productName, productPage.getSpanText("Product Name"), "Product name is incorrect");
        softAssert.assertEquals(productCode, productPage.getSpanText("Product Code"), "Product code is incorrect");
        softAssert.assertEquals(productFamilyOption, productPage.getSpanText("Product Family"), "Product family is incorrect");
        softAssert.assertEquals(productDescription, productPage.getSpanText("Product Description"), "Product description is incorrect");
        softAssert.assertEquals(actualDate, productPage.getCreatedByDate());
        productsPage = pageTransporter.navigateToProductsPage();
        softAssert.assertEquals(productName, productsPage.getProductName(productName), "Product does not exist");
        softAssert.assertAll();
    }
}
