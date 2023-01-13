package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    private WebElement getInTouchMessageWebElement;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameBox;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subjectBox;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageBox;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement alertSuccessMessageWebElement;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    private WebElement homeButton;


    public String getGetInTouchMessage() {
        return getInTouchMessageWebElement.getText();
    }

    public void setNameBox(String name) {
        nameBox.sendKeys(name);
    }

    public void setEmailBox(String email) {
        emailBox.sendKeys(email);
    }

    public void setSubjectBox(String subject) {
        subjectBox.sendKeys(subject);
    }

    public void setMessageBox(String message) {
        messageBox.sendKeys(message);
    }

    public void setUploadFileButton(String file) {
        uploadFileButton.sendKeys(file);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getAlertSuccessMessage() {
        return alertSuccessMessageWebElement.getText();
    }

    public void clickHomeButton() {
        homeButton.click();
    }


}
