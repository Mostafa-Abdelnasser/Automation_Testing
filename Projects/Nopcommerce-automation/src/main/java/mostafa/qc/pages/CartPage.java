package mostafa.qc.pages;

import mostafa.qc.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".cart-item-row")
    private List<WebElement> cartItems;

    @FindBy(css = ".order-total strong")
    private WebElement orderTotal;

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".order-summary-content")
    private WebElement emptyCartMessage;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(css = ".remove-from-cart input")
    private List<WebElement> removeCheckboxes;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(Constants.CART_PATH);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public String getOrderTotal() {
        return getText(orderTotal);
    }

    public void updateQuantity(int itemIndex, int newQty) {
        if (itemIndex < cartItems.size()) {
            WebElement qtyInput = cartItems.get(itemIndex).findElement(By.cssSelector(".qty-input"));
            type(qtyInput, String.valueOf(newQty));
            click(updateCartButton);
        }
    }

    public void removeItem(int itemIndex) {
        if (itemIndex < removeCheckboxes.size()) {
            click(removeCheckboxes.get(itemIndex));
            click(updateCartButton);
        }
    }

    public void removeAllItems() {
        for (WebElement checkbox : removeCheckboxes) {
            click(checkbox);
        }
        click(updateCartButton);
    }

    public void acceptTermsAndCheckout() {
        click(termsCheckbox);
        click(checkoutButton);
    }

    public void proceedToCheckout() {
        acceptTermsAndCheckout();
    }
}