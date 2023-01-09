package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreated;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;

    public String getAccountCreatedMessage() {
        return accountCreated.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
