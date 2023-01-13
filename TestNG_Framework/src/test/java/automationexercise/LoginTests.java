package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginTests extends BaseTest {
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
    public void TestCase_02_Login_User_With_Correct_Email_And_Password() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 2  Verify that home page is visible successfully");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'Login to your account' is visible
        String loginToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(loginToYourAccountMessage, "Login to your account", "Test case 2  Verify 'Login to your account' is visible");

        //Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress("erd@kms.com");
        pages.getLoginPage().setLoginEmailPassword("qwerty");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify that 'Logged in as username' is visible.
        softAssert.assertTrue(pages.getHomePage().getLoggedInAsGivenNameResult().contains("Logged in as " + ConfigReader.getProperty("name")), "Error !! No contains Logged result");

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualAccountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!", "ERROR : Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible\n");


    }

    @Test(priority = 2)
    public void TestCase_03_Login_User_With_Incorrect_Email_And_Password() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 2  Verify that home page is visible successfully");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'Login to your account' is visible
        String loginToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(loginToYourAccountMessage, "Login to your account", "Test case 2  Verify 'Login to your account' is visible");

        //Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress("incorrecterd@kms.com");
        pages.getLoginPage().setLoginEmailPassword("qwerty");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify error 'Your email or password is incorrect!' is visible
        String actualIncorrectLoginMessage = pages.getLoginPage().getIncorrectLoginMessage();
        softAssert.assertEquals(actualIncorrectLoginMessage, "Your email or password is incorrect!", "Test case 2 Verify error 'Your email or password is incorrect!' is visible");

    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
