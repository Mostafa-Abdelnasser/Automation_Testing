package mostafa.qc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    @FindBy(css = ".product-name h1")
    private WebElement productName;

    @FindBy(css = ".product-price")
    private WebElement productPrice;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = ".qty-input")
    private WebElement quantityInput;

    @FindBy(css = ".bar-notification.success")
    private WebElement successNotification;

    @FindBy(css = "select[id*='product_attribute']")
    private WebElement productAttributeDropdown;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void setQuantity(int qty) {
        type(quantityInput, String.valueOf(qty));
    }

    public void selectAttribute(String value) {
        waitUtils.waitForVisibility(productAttributeDropdown);
        Select select = new Select(productAttributeDropdown);
        select.selectByVisibleText(value);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public void addToCart(int quantity) {
        setQuantity(quantity);
        clickAddToCart();
    }

    public boolean isSuccessNotificationDisplayed() {
        return isDisplayed(successNotification);
    }

    public String getSuccessNotificationText() {
        return getText(successNotification);
    }
}