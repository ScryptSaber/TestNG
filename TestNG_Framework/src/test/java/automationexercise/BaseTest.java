package automationexercise;

import org.testng.annotations.AfterSuite;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Pages;

public class BaseTest {
    protected Pages pages = new Pages();

    public void setupSuite() {
        //This code will be executed before entire suite
        String url = ConfigReader.getProperty("url");
        String browser = ConfigReader.getProperty("browser");
        String environment = ConfigReader.getProperty("environment");

        Driver.getDriver().get(url);
        System.out.println("::::::Test Information ::::::\n\tURL :" + url + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);

    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
