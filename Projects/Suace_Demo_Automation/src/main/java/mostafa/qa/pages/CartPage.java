package mostafa.qa.pages;

import mostafa.qa.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void removeBackpack() {
        removeBackpackButton.click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

}
