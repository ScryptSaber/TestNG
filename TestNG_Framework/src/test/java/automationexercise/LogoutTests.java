package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class LogoutTests extends BaseTest {
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
    public void TestCase_04_Logout_User() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 4  Verify that home page is visible successfully");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'Login to your account' is visible
        String loginToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(loginToYourAccountMessage, "Login to your account", "Test case 4  Verify 'Login to your account' is visible");

        //Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress("erd@kms.com");
        pages.getLoginPage().setLoginEmailPassword("qwerty");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify that 'Logged in as username' is visible.
        softAssert.assertTrue(pages.getHomePage().getLoggedInAsGivenNameResult().contains("Logged in as " + ConfigReader.getProperty("name")), "Error !! No contains Logged result");

        // Click 'Logout' button
        pages.getHomePage().clickLogoutButton();

        //Verify that user is navigated to login page
        String loginPageUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(loginPageUrl, "https://automationexercise.com/login", "Test case 4 Verify that user is navigated to login page");

    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}