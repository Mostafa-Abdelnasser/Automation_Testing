import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceDemo_LoginPage {

    //this is a selenium () based file with (testNG framework will continue on this later)

    public static void main(String[] args) {

        // to remove the warnings in the automation process

        ChromeOptions options = new ChromeOptions();

        // Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Start Chrome with these options
        //open chrome page
        WebDriver driver = new ChromeDriver();




        //WebDriverManager.chromedriver().setup(); // this runs one time in the project to initiate the environment

        //open the website
        driver.get("https://www.saucedemo.com/v1/");
        //maximize the page
        driver.manage().window().maximize();

        /*
        String text = driver.findElement(By.id("user-name")).toString();  // this another way for saving user name id without Web element
        System.out.println(text);*/  // for displaying the values


        //finding the elements in the page and input the values in the login
        //it's better to make a web element  for each element in the page

        // creating web element for username
        WebElement username = driver.findElement(By.id("user-name"));
        System.out.println(username);
        username.sendKeys("standard_user");

        //creating web element for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // or we can find the element by class but id is the most unique thing and it's better
        String text = driver.findElement(By.className("login_password")).getText(); // the class i refer must contain text to print
        System.out.println(text);

        //Now login button
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        // after login now add to cart any element
        // if there is no unique id then we will use x-path
        // this x-path of the third item
        WebElement button = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button"));
        button.click();

        // using the class as in here is not very practical as it's not unique so we will use index
        // first item
        WebElement addcartbtn = driver.findElement(By.className("btn_inventory"));
        addcartbtn.click();

        //this is the last resort
        // Get all buttons with the same class
        //second item
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        // Access by index (e.g., 2nd button, index starts from 0)
        WebElement secondButton = buttons.get(1);
        secondButton.click();


        // okay now using main is so cool in varifying the code is actually work now need to create methods
        //in the class to be used in other class









    }



}
