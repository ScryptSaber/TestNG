package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement signUpLoginButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement productButton;

    @FindBy(xpath = "//li[10]//a[1]")
    private WebElement loggedInAsGivenName;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//div[@class='item active']//span[1]")
    private WebElement automationTextWebElement;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsButton;


    public void clickSignUpLoginButton() {
        signUpLoginButton.click();
    }

    public void clickProductButton() {
        BrowserUtils.verifyElementDisplayed(productButton);
        productButton.click();
    }

    public String getLoggedInAsGivenNameResult() {
        return loggedInAsGivenName.getText();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public String getAutomationText() {
        return automationTextWebElement.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
    public void clickContactUsButton(){
        contactUsButton.click();
    }

}
