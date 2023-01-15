package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class CartTests extends BaseTest {
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
    public void TestCase_11_Verify_Subscription_In_Cart_Page() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 11  Verify that home page is visible successfully");

        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,600)");

        //Verify text 'SUBSCRIPTION'
        String actualSubscriptionText = pages.getCartPage().getSubscriptionMessage();
        softAssert.assertEquals(actualSubscriptionText, "SUBSCRIPTION", "Test case 11 Verify text 'SUBSCRIPTION'");


        //Enter email address in input and click arrow button
        pages.getCartPage().setSubscribeEmailBox("ed@kk");
        pages.getCartPage().clickSubscribeSubmitButton();

        //Verify success message 'You have been successfully subscribed!' is visible
        String actualSubscribeSuccessMessage = pages.getCartPage().getAlertSuccessSubscribeMessage();
        softAssert.assertEquals(actualSubscribeSuccessMessage, "You have been successfully subscribed!",
                "Test case 11 Verify success message 'You have been successfully subscribed!' is visible");


    }

    @Test
    public void TestCase_12_Add_Products_In_Cart() {
        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 12  Verify that home page is visible successfully");

        //Click on 'Products' button
        pages.getHomePage().clickProductsButton();

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        // Hover over first product and click 'Add to cart'
        BrowserUtils.hoverOver(pages.getProductsPage().getHoverOverFirstItemWebElement());
        pages.getProductsPage().clickAddToCartButton();
        // Actions a = new Actions(Driver.getDriver());
        // a.moveToElement(pages.getProductsPage().getHoverOverFirstItemWebElement());
        // pages.getProductsPage().clickAddToCartButton();


        //Click 'Continue Shopping' button
        pages.getProductsPage().clickContinueShoppingButton();

        //Hover over second product and click 'Add to cart'
        BrowserUtils.hoverOver(pages.getProductsPage().getHoverOverSecondItemWebElement());
        pages.getProductsPage().clickAddToCartSecondButton();

        //Click 'View Cart' button
        pages.getProductsPage().clickViewCartButton();

        //Verify both products are added to Cart
        String actualBlueTopText = pages.getCartPage().getBlueTopText();
        softAssert.assertEquals(actualBlueTopText, "Blue Top");
        String actualMenTshirtText = pages.getCartPage().getMenTshirt();
        softAssert.assertEquals(actualMenTshirtText, "Men Tshirt");

        //Verify their prices, quantity and total price
        String actualBlueTopQualifications = pages.getCartPage().getBlueTopQualifications();
        softAssert.assertEquals(actualBlueTopQualifications, "Blue Top1Rs. 500");

        String actualMenTshirtQualifications = pages.getCartPage().getMenTshirtQualifications();
        softAssert.assertEquals(actualMenTshirtQualifications, "Men Tshirt1Rs. 400");


    }


    @AfterSuite
    @Override
    public void afterTest() {
        super.afterTest();
    }


}
