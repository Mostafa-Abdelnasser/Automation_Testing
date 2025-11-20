package StepDefinitions;

import Pages.HomePage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static StepDefinitions.Hooks.driver;


public class UserRegistration {

    HomePage homePageObj = new HomePage(driver); ;
    RegistrationPage registrationPageObj = new RegistrationPage(driver);;

// run from the extends in the test runner
    @Given(": the user in the home page")
    public void the_user_in_the_home_page() {
        System.out.println("The user in the home page");

    }

    @When(": user click on the register button")
    public void user_click_on_the_register_button() {
        // Write code here that turns the phrase above into concrete actions
        homePageObj.openRegistrationPage();
        System.out.println("user clicked on the register button");
    }
//    @When(": enter valid creds")
//    public void enter_valid_creds() {
//        // Write code here that turns the phrase above into concrete actions
//        registrationPageObj.registrationData("ebondk","welly","mpp@yahoo.com","sdfsdf12354","sdfsdf12354");
//
//    }
    @Then(": user should register successfully")
    public void user_should_register_successfully() {
        // Write code here that turns the phrase above into concrete actions
        String result = registrationPageObj.registrationMsg.getText();
        System.out.println(result);
        //this compare two values
        Assert.assertEquals(result,"Your registration completed"); // if there is something wrong the test will fail this the only feedback
        //Assert.assertTrue(registrationPageObj.registrationMsg.getText().contains("Your registration completed"));
    }

    //creating different inputs rather than only passing it to the function
    @And(": enter {string} , {string} , {string} , {string}")
    public void enter(String firstname, String lastname, String email, String password) {

        registrationPageObj.registrationData(firstname,lastname,email,password,password); // last one is password confirm

    }
}
