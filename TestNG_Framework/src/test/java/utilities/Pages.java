package utilities;

import pages.*;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ProductsPage productsPage;

    private AccountCreatedPage accountCreatedPage;

    private DeleteAccountPage deleteAccountPage;
    private ContactUsPage contactUsPage;

    private ProductDetailPage productDetailPage;
    private CartPage cartPage;


    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.productsPage = new ProductsPage();
        this.accountCreatedPage = new AccountCreatedPage();
        this.deleteAccountPage = new DeleteAccountPage();
        this.contactUsPage = new ContactUsPage();
        this.productDetailPage = new ProductDetailPage();
        this.cartPage = new CartPage();

    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public AccountCreatedPage getAccountCreatedPage() {
        return accountCreatedPage;
    }

    public DeleteAccountPage getDeleteAccountPage() {
        return deleteAccountPage;
    }

    public ContactUsPage getContactUsPage() {
        return contactUsPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }


}
