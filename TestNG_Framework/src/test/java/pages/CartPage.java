package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailBoxWebElement;

    @FindBy(id = "subscribe")
    private WebElement subscribeSubmitButton;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionTextWebElement;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement alertSuccessSubscriptionWebElement;
    @FindBy(xpath = "//a[normalize-space()='Blue Top']")
    private WebElement blueTopProductTextWebElement;

    @FindBy(xpath = "//a[normalize-space()='Men Tshirt']")
    private WebElement menTshirtProductTextWebElement;

    @FindBy(xpath = "//td[@class='cart_price']//p[contains(text(),'Rs. 500')]")
    private WebElement blueTopPriceWebElement;

    @FindBy(xpath = "//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']")
    private WebElement blueTopQuantityWebElement;
    @FindBy(xpath = "//p[@class='cart_total_price'][normalize-space()='Rs. 500']")
    private WebElement blueTopTotalPriceWebElement;

    @FindBy(xpath = "//td[@class='cart_price']//p[contains(text(),'Rs. 400')]")
    private WebElement menTshirtPriceWebElement;
    @FindBy(xpath = "//tr[@id='product-2']//button[@class='disabled'][normalize-space()='1']")
    private WebElement menTshirtQuantityWebElement;
    @FindBy(xpath = "//p[@class='cart_total_price'][normalize-space()='Rs. 400']")
    private WebElement menTshirtTotalPriceWebElement;


    public void setSubscribeEmailBox(String email) {
        subscribeEmailBoxWebElement.sendKeys(email);
    }

    public void clickSubscribeSubmitButton() {
        subscribeSubmitButton.click();
    }

    public String getSubscriptionMessage() {
        return subscriptionTextWebElement.getText();
    }

    public String getAlertSuccessSubscribeMessage() {
        return alertSuccessSubscriptionWebElement.getText();
    }

    public String getBlueTopText() {
        return blueTopProductTextWebElement.getText();
    }

    public String getMenTshirt() {
        return menTshirtProductTextWebElement.getText();
    }

    public String getBlueTopQualifications() {
        return blueTopPriceWebElement.getText() + blueTopQuantityWebElement.getText() + blueTopTotalPriceWebElement.getText();
    }

    public String getMenTshirtQualifications() {
        return menTshirtPriceWebElement.getText() + menTshirtQuantityWebElement.getText() + menTshirtTotalPriceWebElement.getText();
    }

}
