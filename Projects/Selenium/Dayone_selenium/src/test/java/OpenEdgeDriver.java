import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenEdgeDriver {


    public static void main(String[] args) {

        // initiating the setup to work with edge
        WebDriverManager.edgedriver().setup();
        // opening edge as it's in the constructor of webdriver
        WebDriver driver = new EdgeDriver();


        /*
        // Step 1: Setup EdgeDriver automatically
        WebDriverManager.edgedriver().setup();

        // Step 2: Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Step 3: Open a website
        driver.get("https://www.google.com");

        // Step 4: Print page title to verify
        System.out.println("Title: " + driver.getTitle());

        // Step 5: Close browser
        driver.quit();


*/

    }


}
