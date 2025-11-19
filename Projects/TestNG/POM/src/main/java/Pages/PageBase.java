package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {


    protected WebDriver driver;
    //constructor to find the elements in page
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }





}
