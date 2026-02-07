package mostafa.qa.core;

import mostafa.qa.utils.ExtentManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver; // used instance in chrome page
    protected String browserName;

    // Static flag to ensure ExtentManager.setBrowserInfo is called only once (To print the type of browser only once in report )
    private static boolean isBrowserInfoSet = false;

    public WebDriver getDriver() {
        return driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    // Make chrome object and open new chrome page
    @BeforeMethod (alwaysRun = true)
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options); // set incognito tap
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // extract the browser type and save its name
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        this.browserName = caps.getBrowserName();

        // Call setBrowserInfo only once
        if (!isBrowserInfoSet) {
            ExtentManager.setBrowserInfo(browserName); // print the used browser in the report
            isBrowserInfoSet = true;
        }
    }

/*
    @AfterMethod(alwaysRun = true)
    public void tearDownClass() {

        driver.quit();
        /*
        if (driver != null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            driver.quit();
        }


    }
    */


}