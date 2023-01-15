package automationexercise;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TestCasesPageTest extends BaseTest {
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
    public void TestCase_07_Verify_Test_Cases_Page() {

        // Verify that home page is visible successfully
        String automationText = pages.getHomePage().getAutomationText();
        softAssert.assertEquals(automationText, "Automation", "Test case 7  Verify that home page is visible successfully");

        // Click on 'Test Cases' button
        pages.getHomePage().clickTestCasesButton();

        // Verify user is navigated to test cases page successfully
        String testCasesPageUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(testCasesPageUrl, "https://automationexercise.com/test_cases",
                "Test case 7 Verify user is navigated to test cases page successfully");


    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
