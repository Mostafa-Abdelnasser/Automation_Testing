package mostafa.qa.pages;

// src/main/java/com/mostafa/qa/pages/InventoryPage.java

import mostafa.qa.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;



public class InventoryPage extends PageBase {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDropdown;






    public boolean isLoaded() {
        return pageTitle.isDisplayed();
    }

    public void addBackpack() {
        addBackpackButton.click();
    }

    public String getCartBadgeCount() {
        try {
            return cartBadge.getText();
        } catch(RuntimeException e) {
            return "0"; // badge not present means cart is empty
        }
    }


    public void goToCart() {
        cartLink.click();
    }

    // value options: "az" (Name A→Z), "za" (Name Z→A), "lohi" (Price Low→High), "hilo" (Price High→Low)
    public void sortBy(String value) {

        // Simple select without external libs
        sortDropdown.click();
        // Use native JS select or sendKeys if needed; sendKeys works on standard selects
        sortDropdown.sendKeys(value);
        sortDropdown.click(); // stop on it with send key then click
    }


    // there is a problem here need to check (.inventory_item_price)
    public boolean arePricesSortedAscending() {
        // Always fetch fresh elements
        List<WebElement> prices = driver.findElements(By.cssSelector("inventory_item_price"));

        double prev = -Double.MAX_VALUE;
        for (WebElement priceEl : prices) {
            String text = priceEl.getText().replace("$", "").trim();
            System.out.println(text); // print each price
            double current = Double.parseDouble(text);
            if (current < prev) {
                return false; // not ascending
            }
            prev = current;
        }
        return true;
    }


}
