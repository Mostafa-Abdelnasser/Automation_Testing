package Tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {

    HomePage homePageObj ;
    RegistrationPage registrationPageObj ;

    @Test
    public void userRegistrationSuccessfully(){
        homePageObj= new HomePage(driver);
        homePageObj.openRegistrationPage();

        registrationPageObj = new RegistrationPage(driver);
        registrationPageObj.registrationData("ebondk","welly","mazoi@yahoo.com","sdfsdf12354","sdfsdf12354");
        String result = registrationPageObj.registrationMsg.getText();
        System.out.println(result);
        //this compare two values
        //Assert.assertEquals(result,"Your registration completed");
        //check if the value is there
        //if there is a problem it will inform me
        //Assert.assertTrue(registrationPageObj.registrationMsg.getText().contains("Your registration completed"));
        //need to check this
        //Assert.assertTrue(false);


    }






}
