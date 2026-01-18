package mostafa.qc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".ico-login")
    private WebElement loginLink;

    @FindBy(css = ".ico-register")
    private WebElement registerLink;

    @FindBy(css = ".ico-logout")
    private WebElement logoutLink;

    @FindBy(css = ".ico-account")
    private WebElement myAccountLink;

    @FindBy(css = ".ico-cart")
    private WebElement cartLink;

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(css = ".search-box-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo("/");
    }

    public void clickLogin() {
        click(loginLink);
    }

    public void clickRegister() {
        click(registerLink);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void clickMyAccount() {
        click(myAccountLink);
    }

    public void clickCart() {
        click(cartLink);
    }

    public void searchFor(String keyword) {
        type(searchBox, keyword);
        click(searchButton);
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(logoutLink);
    }

    public boolean isLoginLinkVisible() {
        return isDisplayed(loginLink);
    }
}