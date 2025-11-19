package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
         super(driver);

    }

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id ="register-button")
    WebElement registerButton;
    @FindBy(className = "result")
    public WebElement registrationMsg;

    public void registrationData(String fn ,String ln,String email1,String pwd,String confirmPwd ){

        genderMale.click();
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        email.sendKeys(email1);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(confirmPwd);
        registerButton.click();


    }








}
