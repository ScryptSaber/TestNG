package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class ContactTests extends BaseTest {
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
    public void TestCase_06_Contact_Us_Form() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 2  Verify that home page is visible successfully");


        //Click on 'Contact Us' button
        pages.getHomePage().clickContactUsButton();

        //Verify 'GET IN TOUCH' is visible
        String actualGetInTouchMessage = pages.getContactUsPage().getGetInTouchMessage();
        softAssert.assertEquals(actualGetInTouchMessage, "GET IN TOUCH", "Test Case 6 Verify 'GET IN TOUCH' is visible");

        // Enter name, email, subject and message
        pages.getContactUsPage().setNameBox(ConfigReader.getProperty("name"));
        pages.getContactUsPage().setEmailBox("erd@kms.com");
        pages.getContactUsPage().setSubjectBox("Test Automation");
        pages.getContactUsPage().setMessageBox("Test Automation part is good but pop-ups are really boring.Please prevent all of them.");


        // Upload file
        pages.getContactUsPage().setUploadFileButton("C:\\Users\\ASUS\\Desktop\\kali1.png");


        //Click 'Submit' button
        pages.getContactUsPage().clickSubmitButton();

        //Click OK button
        Driver.getDriver().switchTo().alert().accept();

        //Verify success message 'Success! Your details have been submitted successfully.' is visible
        String actualSuccessMessage = pages.getContactUsPage().getAlertSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, "Success! Your details have been submitted successfully.",
                "Test Case 6 Verify success message 'Success! Your details have been submitted successfully.' is visible");

        //Click 'Home' button and verify that landed to home page successfully
        pages.getContactUsPage().clickHomeButton();
        String homePageUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(homePageUrl, "https://automationexercise.com", "Test case 6 :Verify that landed to home page successfully");


    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
