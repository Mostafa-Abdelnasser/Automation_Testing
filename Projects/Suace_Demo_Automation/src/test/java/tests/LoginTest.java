package tests;


import mostafa.qa.core.BaseTest;
import mostafa.qa.pages.LoginPage;
import mostafa.qa.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

        private LoginPage loginPage;   // declared once
        private InventoryPage inventoryPage;

        @BeforeMethod(groups = {"smoke", "regression"})
        public void setUpPage() {
            loginPage = new LoginPage(driver); // initialized before each test
            inventoryPage = new InventoryPage(driver);
        }



    @Test(groups = {"smoke", "regression"})
    public void validLogin_shouldGoToInventory() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should load after valid login");
    }
    // if you want to run the login test class use priority with delay  to see effect with each test(can remove the priority and delay and still work normally)
    @Test(groups = {"regression"})
    public void lockedOutUser_shouldSeeError() {
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().toLowerCase().contains("sorry"),
                "Locked out user should see an error message");
        System.out.println(loginPage.getErrorMessage());

    }


}
