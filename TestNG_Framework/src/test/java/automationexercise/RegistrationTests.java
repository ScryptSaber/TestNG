package automationexercise;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class RegistrationTests extends BaseTest {

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setupSuite() {
        //This code will be executed before entire suite
        String url = ConfigReader.getProperty("url");
        String browser = ConfigReader.getProperty("browser");
        String environment = ConfigReader.getProperty("environment");

        Driver.getDriver().get(url);
        System.out.println("::::::Test Information ::::::\n\tURL :" + url + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);

    }

    @Test(priority = 0)
    public void TestCase_1_Register_User() {

        //Launch browser and Navigate to url 'http://automationexercise.com'
        //Click on 'Signup/Login' button

        pages.getHomePage().clickSignUpLoginButton();
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();

        //Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName("Erdem");
        pages.getLoginPage().setSignupEmailAddressBox("erd@kms.com");

        // Click 'Signup' button
        pages.getLoginPage().clickSignupButton();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInfoTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInfoTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        // Fill details: Title, Name, Email, Password, Date of birth
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword("qwerty");
        pages.getSignupPage().setDateOfBirth("13", "April", "1999");

        //Select checkbox 'Sign up for our newsletter!'
        //Select checkbox 'Receive special offers from our partners!'
        pages.getSignupPage().selectNewsletterCheckbox();
        pages.getSignupPage().selectSpecialOfferCheckbox();


        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        pages.getSignupPage().setFirstName("Erdem");
        pages.getSignupPage().setLastName("Kamis");
        pages.getSignupPage().setCompany("Inar");
        pages.getSignupPage().setAddress1("Dallas");
        pages.getSignupPage().setAddress2("Texas");
        pages.getSignupPage().setCountry("United States");
        pages.getSignupPage().setState("Texas");
        pages.getSignupPage().setCity("Dallas");
        pages.getSignupPage().setZipcode("1234");
        pages.getSignupPage().setMobileNumber("0913456357");

        //Click 'Create Account button'
        pages.getSignupPage().clickCreateAccount();

        //Verify that 'ACCOUNT CREATED!' is visible
        String actualAccountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(actualAccountCreatedMessage, "ACCOUNT CREATED!", "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n");

        //Click 'Continue' button
        pages.getAccountCreatedPage().clickContinueButton();

        //Verify that 'Logged in as username' is visible
        softAssert.assertTrue(pages.getHomePage().getLoggedInAsGivenNameResult().contains("Logged in as"), "Error !! No contains Logged result");

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualAccountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!", "ERROR : Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible\n");


    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
