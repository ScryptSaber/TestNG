package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;

public class SubscriptionTest extends BaseTest {
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
    public void TestCase_10_Verify_Subscription_In_Home_Page() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 8  Verify that home page is visible successfully");

        //Scroll down to footer
        BrowserUtils.scrollDown("200");

        //Verify text 'SUBSCRIPTION'
        String actualSubscriptionText = pages.getHomePage().getSubscriptionText();
        softAssert.assertEquals(actualSubscriptionText, "SUBSCRIPTION", "Test case 8 Verify text 'SUBSCRIPTION'");

        //Enter email address in input and click arrow button
        pages.getHomePage().setEmailSubscriptionBox("ed@kk");
        pages.getHomePage().clickSubscriptionSubmitButton();

        //Verify success message 'You have been successfully subscribed!' is visible
        String actualSubscribeSuccessMessage = pages.getHomePage().getAlertSuccessSubscribeMessage();
        softAssert.assertEquals(actualSubscribeSuccessMessage, "You have been successfully subscribed!",
                "Test case 8 Verify success message 'You have been successfully subscribed!' is visible");


    }

    @AfterSuite
    @Override
    public void afterTest() {
        super.afterTest();
    }
}
