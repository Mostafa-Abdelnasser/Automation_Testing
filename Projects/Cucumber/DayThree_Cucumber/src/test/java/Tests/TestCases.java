package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases {

    // we will initiate chrome setup in order to not repeat the code
    WebDriver driver;


    @BeforeTest
    public void  BeforeTest() {
        System.out.println("Before Test Functions(TestCases)");
    }
    @BeforeMethod
    public void  setupDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

    }
    @Test
    public void lgn () {

        // creating web element for username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //creating web element for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Now login button
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

    }

    public void addtocart () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        // creating web element for username
        WebElement username = driver.findElement(By.id("user-name"));
        System.out.println(username);
        username.sendKeys("standard_user");

        //creating web element for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Now login button
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        //this is the last resort
        // Get all buttons with the same class
        //second item
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        // Access by index (e.g., 2nd button, index starts from 0)
        WebElement secondButton = buttons.get(1);
        secondButton.click();


    }
    public void Testcase3 () {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println("This is test case3");





    }








}
