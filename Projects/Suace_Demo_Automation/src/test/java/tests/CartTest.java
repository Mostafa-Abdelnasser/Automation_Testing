package tests;

import mostafa.qa.core.BaseTest;
import mostafa.qa.pages.LoginPage;
import mostafa.qa.pages.InventoryPage;
import mostafa.qa.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod(groups = {"smoke", "regression"})
    private void setUpPages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }


    @Test(groups = {"smoke"})
    public void addToCart_shouldUpdateBadge() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpack();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1");
        //System.out.println(inventoryPage.getCartBadgeCount());
        inventoryPage.goToCart();
        cartPage.removeBackpack();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "0");
        //System.out.println(inventoryPage.getCartBadgeCount());
    }
}
