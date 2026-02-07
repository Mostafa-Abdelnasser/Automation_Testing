package mostafa.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mostafa.qa.utils.ExtentManager;
import mostafa.qa.core.BaseTest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestNGListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test failed: " + result.getThrowable());

        // Capture screenshot safely
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Add timestamp to screenshot filename to avoid overwriting
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = "reports/screenshots/" + result.getMethod().getMethodName() + "_" + timestamp + ".png";

            try {
                Files.createDirectories(Paths.get("reports/screenshots/"));
                Files.copy(screenshot.toPath(), Paths.get(path));
                test.get().addScreenCaptureFromPath(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        String reportPath = ExtentManager.getReportPath();
        System.out.println("✅ Extent report generated at: " + reportPath);
            /*
            Object testInstance = context.getAllTestMethods()[0].getInstance();
            if (testInstance instanceof BaseTest) {
                WebDriver driver = ((BaseTest) testInstance).getDriver();
                if (driver instanceof RemoteWebDriver) {
                    Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
                    String browserName = caps.getBrowserName();
                    ExtentManager.setBrowserInfo(browserName);
                }
            }

             */

            try {
                File reportFile = new File(reportPath);
                if (reportFile.exists()) {
                    Desktop.getDesktop().browse(reportFile.toURI());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        // Add browser info dynamically
/*
        Object testInstance = context.getAllTestMethods()[0].getInstance();
        if (testInstance instanceof BaseTest) {
            String browserName = ((BaseTest) testInstance).getBrowserName();
            ExtentManager.setBrowserInfo(browserName);
        }
*/



    }


