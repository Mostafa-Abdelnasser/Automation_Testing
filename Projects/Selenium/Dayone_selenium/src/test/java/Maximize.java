import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maximize {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // link to go to selenium Library
        // this will open all of them in the same tab with difference of 1 second
        driver.get("https://www.selenium.dev/documentation/webdriver/getting_started/install_library/");
        Thread.sleep(1000);
        driver.get("https://www.selenium.dev/documentation/webdriver/getting_started/install_library/");
        Thread.sleep(1000);
        driver.navigate().to("https://www.google.com/search?q=chatgbt&oq=cha&gs_lcrp=EgZjaHJvbWUqEAgCEAAYgwEYsQMYgAQYigUyEggAEEUYORiDARixAxiABBiKBTIMCAEQIxgnGIAEGIoFMhAIAhAAGIMBGLEDGIAEGIoFMg0IAxAuGIMBGLEDGIAEMhIIBBAAGAoYgwEYsQMYgAQYigUyDQgFEAAYgwEYsQMYgAQyEAgGEC4YgwEYsQMYgAQYigUyEAgHEAAYgwEYsQMYgAQYigUyEAgIEAAYgwEYsQMYgAQYigUyCQgJECMYJxiPAtIBCTI2NTVqMGoxNagCCLACAfEFrolFBQ_YZCPxBa6JRQUP2GQj&sourceid=chrome&ie=UTF-8");
        //driver.manage().window().maximize();
        Thread.sleep(1000);
        //driver.quit();  // close all of the taps  and test cases
        //driver.close(); // close the current open tap only



    }


}
