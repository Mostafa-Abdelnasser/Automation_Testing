import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {


        // go for edge code as it contains Explanation

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


    }


}
