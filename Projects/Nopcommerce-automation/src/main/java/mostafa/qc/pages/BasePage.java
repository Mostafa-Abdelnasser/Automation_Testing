package mostafa.qc.pages;

import mostafa.qc.utils.ConfigReader;
import mostafa.qc.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateTo(String path) {
        driver.get(ConfigReader.getBaseUrl() + path);
    }

    protected void click(WebElement element) {
        waitUtils.waitForClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        waitUtils.waitForVisibility(element).clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return waitUtils.waitForVisibility(element).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return waitUtils.waitForVisibility(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}