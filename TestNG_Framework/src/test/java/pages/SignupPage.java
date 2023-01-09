package pages;

import org.bouncycastle.math.ec.custom.sec.SecT409Field;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {
    public SignupPage() {

    }

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInfoTitle;

    @FindBy(xpath = "//*[@id='id_gender1']")
    private WebElement id_genderMR;

    @FindBy(xpath = "//*[@id='id_gender2']")
    private WebElement id_genderMRS;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@data-qa='days']")
    private WebElement dateOfBirth_DAYs;
    @FindBy(xpath = "//*[@data-qa='months']")
    private WebElement dateOfBirth_MONTHs;

    @FindBy(xpath = "//*[@data-qa='years']")
    private WebElement dateOfBirth_YEARs;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement productsPageButton;

    @FindBy(id="newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id="optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id="first_name")
    private WebElement firstName;

    @FindBy(id="last_name")
    private WebElement lastName;

    @FindBy(id="company")
    private WebElement company;

    @FindBy(id="address1")
    private WebElement address1;

    @FindBy(id="address2")
    private WebElement address2;

    @FindBy(id="country")
    private WebElement country;

    @FindBy(id="state")
    private WebElement state;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="zipcode")
    private WebElement zipcode;

    @FindBy(id="mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;


    public String getEnterAccountInformationTitle() {
        return enterAccountInfoTitle.getText();

    }

    public void selectTitleMen() {
        id_genderMR.click();
    }

    public void selectTitleWomen() {
        id_genderMRS.click();
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void setDateOfBirth(String day, String month, String year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(String day) {
        Select select = new Select(dateOfBirth_DAYs);
        select.selectByVisibleText(day);

    }

    public void setMonth(String month) {
        Select select = new Select(dateOfBirth_MONTHs);
        select.selectByVisibleText(month);
    }

    public void setYear(String year) {
        Select select = new Select(dateOfBirth_YEARs);
        select.selectByVisibleText(year);
    }

    public void selectNewsletterCheckbox(){
        newsletterCheckbox.click();
    }
    public void selectSpecialOfferCheckbox(){
        specialOffersCheckbox.click();
    }
    public void setFirstName(String firstname){
        firstName.sendKeys(firstname);
    }
    public void setLastName(String lastname){
        lastName.sendKeys(lastname);
    }
    public void setCompany(String companyName){
        company.sendKeys(companyName);
    }

    public void setAddress1(String address_1){
        address1.sendKeys(address_1);
    }
    public void setAddress2(String address_2){
        address2.sendKeys(address_2);
    }
    public void setCountry(String countryName){
        Select select = new Select(country);
        select.selectByVisibleText(countryName);
    }
    public void setState(String stateName){
        state.sendKeys(stateName);
    }
    public void setCity(String cityName){
        city.sendKeys(cityName);
    }
    public void setZipcode(String zipCode){
        zipcode.sendKeys(zipCode);
    }
    public void setMobileNumber(String mobile_number){
        mobileNumber.sendKeys(mobile_number);
    }
    public void clickCreateAccount(){
        createAccountButton.click();
    }


    public void selectProductsPageButton() {
        productsPageButton.click();
    }
}
