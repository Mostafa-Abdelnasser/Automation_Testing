package mostafa.qc.pages;

import mostafa.qc.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(css = ".login-button")
    private WebElement loginButton;

    @FindBy(css = ".message-error")
    private WebElement errorMessage;

    @FindBy(css = ".validation-summary-errors")
    private WebElement validationErrors;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(Constants.LOGIN_PATH);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getValidationErrors() {
        return getText(validationErrors);
    }
}