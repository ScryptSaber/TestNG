package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class ProductTests extends BaseTest {
    // We should use soft assertion because in this testcase we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    //Launch browser
    //Navigate to url 'http://automationexercise.com'
    @Override
    @BeforeSuite
    public void setupSuite() {
        super.setupSuite();
    }


    @Test(priority = 1)
    public void TestCase_08_Verify_All_Products_And_Product_Detail_Page() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 8  Verify that home page is visible successfully");

        //Click on 'Products' button
        pages.getHomePage().clickProductsButton();

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify user is navigated to ALL PRODUCTS page successfully
        String actualAllProductText = pages.getProductsPage().getAllProductsText();
        softAssert.assertEquals(actualAllProductText, "ALL PRODUCTS",
                "Test case 8 Verify user is navigated to ALL PRODUCTS page successfully");

        //The products list is visible
        BrowserUtils.verifyElementDisplayed(pages.getProductsPage().getAllProductItemsWebElement());

        //Click on 'View Product' of first product
        pages.getProductsPage().clickFirstViewProductButton();

        // User is landed to product detail page
        String productDetailPageUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(productDetailPageUrl, "https://automationexercise.com/product_details/1",
                "Test case 8 User is landed to product detail page");

        //Verify that detail is visible: product name, category, price, availability, condition, brand
        BrowserUtils.verifyElementDisplayed(pages.getProductDetailPage().getProductConditionWebElement());

    }

    @Test(priority = 2)
    public void TestCase_09_SearchProduct() {
        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 8  Verify that home page is visible successfully");

        //Click on 'Products' button
        pages.getHomePage().clickProductsButton();

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify user is navigated to ALL PRODUCTS page successfully
        String actualAllProductText = pages.getProductsPage().getAllProductsText();
        softAssert.assertEquals(actualAllProductText, "ALL PRODUCTS",
                "Test case 8 Verify user is navigated to ALL PRODUCTS page successfully");

        //Enter product name in search input and click search button
        pages.getProductsPage().searchProduct("Men Tshirt");
        pages.getProductsPage().clickSearchButton();

        //Verify 'SEARCHED PRODUCTS' is visible
        String actualSearchedProductsMessage = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(actualAllProductText, "SEARCHED PRODUCTS",
                "Test case 8 Verify 'SEARCHED PRODUCTS' is visible");


        // Verify all the products related to search are visible //Generic string name required
        String actualSearchRelatedProduct = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(actualSearchRelatedProduct, "Men Tshirt");


    }

    @AfterSuite
    @Override
    public void afterTest() {
        super.afterTest();
    }
}
