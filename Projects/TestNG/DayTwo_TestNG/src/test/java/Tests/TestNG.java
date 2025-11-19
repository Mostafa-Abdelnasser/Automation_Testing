package Tests;

import org.testng.annotations.*;

public class TestNG {


    // we will see difference between methods
    @BeforeMethod
    public void  BeforeMethod() {


        System.out.println("Before Method");

    }
    @BeforeClass
    public void  BeforeClass() {


        System.out.println("Before Class Functions");

    }
    @BeforeSuite
    public void  BeforeSuit() {


        System.out.println("Before Suit");

    }

    @BeforeTest
    public void  BeforeTest() {
        System.out.println("Before Test Functions");
    }


    @Test
    public void  Test1() {
        System.out.println("Test1");

    }
    @Test
    public void  Test2() {
        System.out.println("Test2");

    }





}
