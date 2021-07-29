package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.ConverterToEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Product;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductsPage;
import utils.SetUp;
import utils.StringToDate;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

public class ProductSteps {

    private StringToDate stringToDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy HH:mm");
    SoftAssert softAssert = new SoftAssert();
    String actualDate;
    ProductsPage productsPage;
    Product product;
    Set<String> fields;
    private Util util;

    public ProductSteps(Util util) {
        this.util = util;
    }

    @Given("^I login to salesforce as an? (.*?) user$")
    public void iLoginToSalesforceAsAnAdminUser(final String userType) {
        util.loginPage.loginSuccessfully(SetUp.USER_NAME_SALESFORCE.getValue(), SetUp.PASSWORD.getValue());
    }

    @When("^I navigate to (.*?) page$")
    public void iNavigateToAFeaturePage(final String pageName) {
        PageTransporter.navigateToUrlByPageName(pageName);
    }

    @When("I create a new Product with fields")
    public void iCreateANewProductWithFields(final Map<String, String> table) throws JsonProcessingException {
        productsPage = new ProductsPage();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        product = ConverterToEntity.convertMapToEntity(table, Product.class);
        fields = table.keySet();
        util.productPage = newProductPage.createProduct(table.keySet(), product);

        stringToDate = new StringToDate();
        actualDate = dateFormat.format(stringToDate.getTodayDate());
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        softAssert.assertEquals(util.productPage.getUserSuccessMessage(), "success\nProduct \"" + product.getName() + "\" was created.\nClose", "Message is incorrect");
    }

    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        softAssert.assertEquals(product.getName(), util.productPage.getSpanText("Product Name"), "Product name is incorrect");
        softAssert.assertEquals(product.getProductCode(), util.productPage.getSpanText("Product Code"), "Product code is incorrect");
        softAssert.assertEquals(product.getFamily(), util.productPage.getSpanText("Product Family"), "Product family is incorrect");
//        softAssert.assertEquals(product.getDescription(), util.productPage.getSpanText("Product Description"), "Product description is incorrect");
//        softAssert.assertEquals(product.getDescription(), util.productPage.getDescription(), "Product description is incorrect");
    }

    @And("Check The title matches")
    public void validateTheTitleMatches() {
        softAssert.assertEquals(product.getName(), util.productPage.getProductTittle(), "The tittle is incorrect");
    }

    @And("Check The created date matches")
    public void validateTheCreatedDateMatches() {
        softAssert.assertEquals(actualDate, util.productPage.getCreatedByDate());
        softAssert.assertAll();
    }
}
