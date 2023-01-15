package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{
    @FindBy(css = "div[class='product-information']")
    private WebElement productConditionWebElement;


    public WebElement getProductConditionWebElement(){
        return productConditionWebElement;
    }



}
