package mostafa.qc.pages;

import mostafa.qc.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(css = ".result")
    private WebElement successMessage;

    @FindBy(css = ".validation-summary-errors")
    private WebElement validationErrors;

    @FindBy(css = ".field-validation-error")
    private WebElement fieldError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(Constants.REGISTER_PATH);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(genderMale);
        } else {
            click(genderFemale);
        }
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void enterConfirmPassword(String password) {
        type(confirmPasswordField, password);
    }

    public void clickRegister() {
        click(registerButton);
    }

    public void register(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickRegister();
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public boolean isRegistrationSuccessful() {
        return isDisplayed(successMessage);
    }

    public String getValidationErrors() {
        return getText(validationErrors);
    }
}