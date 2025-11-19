package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);

    }

    //find the register element in nob commerce page
    @FindBy(xpath ="/html/body/div[6]/header/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement register ;

    //find the login element in this page
    @FindBy(className = "ico-login")
    WebElement login ;


    public void openRegistrationPage(){

        register.click();

    }


    public void openLoginPage(){

        login.click();

    }




}
