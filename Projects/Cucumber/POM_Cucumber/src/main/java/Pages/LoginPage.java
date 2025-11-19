package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement  passwordField;
    //xpath for the register button as it has no id
    @FindBy(className = "login-button")
    WebElement registerButton;

    public void loginData(String email1,String pwd ){

        emailField.sendKeys(email1);
        passwordField.sendKeys(pwd);
        registerButton.click();


    }









}
