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

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    private WebElement testCasesButton;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionTextWebElement;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement emailSubscriptionBox;

    @FindBy(id = "subscribe")
    private WebElement subscribeSubmitButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement alertSuccessSubscribeMessageWebElement;

    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement cartButton;


    public void clickProductsButton() {
        BrowserUtils.verifyElementDisplayed(productButton);
        productButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickSignUpLoginButton() {
        signUpLoginButton.click();
    }

    public void clickTestCasesButton() {
        testCasesButton.click();
    }


    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }


    public void clickSubscriptionSubmitButton() {
        signUpLoginButton.click();
    }


    public String getLoggedInAsGivenNameResult() {
        return loggedInAsGivenName.getText();
    }


    public String getAutomationText() {
        return automationTextWebElement.getText();
    }


    public String getSubscriptionText() {
        return subscriptionTextWebElement.getText();
    }

    public void setEmailSubscriptionBox(String email) {
        emailSubscriptionBox.sendKeys(email);
    }


    public String getAlertSuccessSubscribeMessage() {
        return alertSuccessSubscribeMessageWebElement.getText();
    }

}
