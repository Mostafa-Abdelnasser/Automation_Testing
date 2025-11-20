package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class UserLogin{

    HomePage homePageObj = new HomePage(driver);
    LoginPage loginPageObj = new LoginPage(driver);

    @Given(": the user at the home page")
    public void the_user_at_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("The user at the home page");
    }
    @When(": user click on the Login button")
    public void user_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        homePageObj.openLoginPage();
        System.out.println("The user click on the Login button");

    }
//    @When(": enter his registered creds")
//    public void enter_valid_his_registered_creds() {
//        // Write code here that turns the phrase above into concrete actions
//        loginPageObj.loginData("iluio@yahoo.com","sdfsdf12354");
//
//    }
    //note test ng is only used in assertion in cucumber not opening the test
    @Then(": user should Login successfully")
    public void user_should_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("The user should Login successfully");
    }

//*************************** blog page *******************************
    @And(": enter click on blogs")
    public void enterClickOnBlogs() {
        System.out.println("Click on blogs");

    }

    @Then(": user should open blog page successfully")
    public void userShouldOpenBlogPageSuccessfully() {
        System.out.println("The user should open blog page successfully");
    }

    // this for various test cases for login instead of when
    @And(": enter {string} , {string}")
    public void enter(String email, String password) {
        loginPageObj.loginData(email,password);

    }
}
