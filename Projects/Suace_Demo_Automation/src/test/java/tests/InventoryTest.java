package tests;

import mostafa.qa.core.BaseTest;
import mostafa.qa.pages.InventoryPage;
import mostafa.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;


    @BeforeMethod(groups = {"smoke", "regression"})
    private void setUpPages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test(groups = {"smoke"})
    public void inventory_shouldLoadAfterValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded after login");
    }

    @Test(groups = {"smoke", "regression"})
    public void addBackpack_shouldUpdateCartBadgeToOne() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpack();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1",
                "Cart badge should show 1 after adding backpack");
        System.out.println("Cart badge count is " + inventoryPage.getCartBadgeCount());
    }

    @Test(groups = {"regression"})
    public void sort_lowToHigh_shouldOrderPricesAscending() {
        loginPage.login("standard_user", "secret_sauce");

        // Perform sort by "Price (low to high)"
        inventoryPage.sortBy("Price (low to high)");

        // Validate ascending order of visible prices
        Assert.assertTrue(inventoryPage.arePricesSortedAscending(),
                "Prices should be sorted ascending after applying Low to High");

    }
}
