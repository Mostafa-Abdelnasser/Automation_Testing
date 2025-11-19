package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class UserLoginTest extends TestBase {


    HomePage homePageObj;
    LoginPage loginPageObj;

    @Test
    public void userLoginTest(){

        homePageObj = new HomePage(driver);
        homePageObj.openLoginPage();

        loginPageObj = new LoginPage(driver);
        loginPageObj.loginData("mazoi@yahoo.com","sdfsdf12354");

    }



}
