package tests;

import mostafa.qa.core.BaseTest;
import mostafa.qa.pages.LoginPage;
import mostafa.qa.pages.InventoryPage;
import mostafa.qa.pages.CartPage;
import mostafa.qa.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod(groups = {"smoke", "regression"})
    private void setUpPages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }


    @Test(groups = {"smoke"})
    public void validCheckout_shouldShowConfirmation() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.goToCart();

        cartPage.proceedToCheckout();
        checkoutPage.fillInfo("Mostafa", "QA", "12345");
        checkoutPage.continueCheckout();
        checkoutPage.finishOrder();

        Assert.assertTrue(checkoutPage.getConfirmationMessage().toUpperCase().contains("THANK YOU"),
                "Order confirmation should display THANK YOU");
    }
}
