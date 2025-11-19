package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


// put this after extends  from test base
// then make test base abstract test ng to run cucumber
@CucumberOptions(

        // points to  contain the path of the feature
        features = "src/test/java/Features", // can be written with curly brackets or not
        // points to where the test cases
        glue = {"StepDefinitions"},
        // type of report that I want
        plugin = {"pretty", "html:target/cucumber-html-report-new.html"},
        // choose a specific test to run
        tags = "@login"


)

public class TestRunner extends AbstractTestNGCucumberTests {





}
