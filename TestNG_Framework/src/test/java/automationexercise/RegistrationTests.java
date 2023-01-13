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

    // We should use soft assertion because in this testcase we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    //Launch browser and navigate to Url 'http://automationexercise.com'
    @Override
    @BeforeSuite
    public void setupSuite() {
        super.setupSuite();
    }

    @Test(priority = 0)
    public void TestCase_1_Register_User() {

        //Click on 'Signup/Login' button
        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'New User Signup!' is visible
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName(ConfigReader.getProperty("name"));
        pages.getLoginPage().setSignupEmailAddressBox("erd1@kms.com");

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
        pages.getSignupPage().setFirstName(ConfigReader.getProperty("name"));
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

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify that 'Logged in as username' is visible.
        softAssert.assertTrue(pages.getHomePage().getLoggedInAsGivenNameResult().contains("Logged in as " + ConfigReader.getProperty("name")), "Error !! No contains Logged result");

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualAccountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!", "ERROR : Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible\n");

    }

    @Test
    public void TestCase_01_Register_User_Without_Delete_Account() {
        //Launch browser and navigate to Url 'http://automationexercise.com'
        //Click on 'Signup/Login' button

        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'New User Signup!' is visible
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName(ConfigReader.getProperty("name"));
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
        pages.getSignupPage().setFirstName(ConfigReader.getProperty("name"));
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

        //Dismiss pop-ups by navigating back and forward page
        BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify that 'Logged in as username' is visible.
        softAssert.assertTrue(pages.getHomePage().getLoggedInAsGivenNameResult().contains("Logged in as " + ConfigReader.getProperty("name")), "Error !! No contains Logged result");

    }

    @Test(priority = 3)
    public void TestCase_05_Register_User_With_Existing_Email() {
        //Click on 'Signup/Login' button
        pages.getHomePage().clickSignUpLoginButton();

        //Verify 'New User Signup!' is visible
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 5 - Verify 'New User Signup!' is visible");

        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName(ConfigReader.getProperty("name"));
        pages.getLoginPage().setSignupEmailAddressBox("erd@kms.com");

        // Click 'Signup' button
        pages.getLoginPage().clickSignupButton();

        //Verify error 'Email Address already exist!' is visible
        String actualAlreadyExistMessage = pages.getLoginPage().getAlreadyExistEmailMessage();
        softAssert.assertEquals(actualAlreadyExistMessage, "Email Address already exist!", "Test Case 5 Email Address already exist!");


    }


    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
