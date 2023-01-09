package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    private WebElement accountDeleted;

    public String getAccountDeletedMessage() {
        return accountDeleted.getText();
    }
}
