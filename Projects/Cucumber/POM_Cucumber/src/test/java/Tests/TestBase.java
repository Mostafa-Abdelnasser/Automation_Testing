//package Tests;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeMethod;
//// extends abstract testng cucumber (Helps in running cucumber)
//public class TestBase extends AbstractTestNGCucumberTests {
//
//   public static WebDriver driver;
//    //Before running any function
//    @BeforeMethod
//    public void startDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://localhost:5000/");
//
//
//
//    }
//}
