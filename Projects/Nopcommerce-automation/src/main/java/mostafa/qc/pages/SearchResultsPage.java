package mostafa.qc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".product-item")
    private List<WebElement> productItems;

    @FindBy(css = ".no-result")
    private WebElement noResultMessage;

    @FindBy(css = ".search-results")
    private WebElement searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCount() {
        return productItems.size();
    }

    public boolean hasResults() {
        return !productItems.isEmpty();
    }

    public boolean isNoResultMessageDisplayed() {
        return isDisplayed(noResultMessage);
    }

    public String getNoResultMessage() {
        return getText(noResultMessage);
    }

    public void clickProductByIndex(int index) {
        if (index < productItems.size()) {
            click(productItems.get(index));
        }
    }

    public void clickProductByName(String productName) {
        for (WebElement product : productItems) {
            WebElement title = product.findElement(By.cssSelector(".product-title"));
            if (title.getText().toLowerCase().contains(productName.toLowerCase())) {
                click(title);
                return;
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public List<String> getAllProductNames() {
        return productItems.stream()
                .map(p -> p.findElement(By.cssSelector(".product-title")).getText())
                .toList();
    }
}