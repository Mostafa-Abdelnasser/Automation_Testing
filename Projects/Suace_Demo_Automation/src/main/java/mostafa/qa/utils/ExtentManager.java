package mostafa.qa.utils;

import mostafa.qa.core.BaseTest;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportPath; // store the path for later use
    BaseTest baseTest;

    public static ExtentReports getInstance() {
        if (extent == null) {
            try {
                // Generate timestamp for unique report name
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                reportPath = "reports/ExtentReport_" + timestamp + ".html";

                // Ensure reports directory exists
                File reportDir = new File("reports");
                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                // Configure ExtentSparkReporter
                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
                spark.config().setReportName("Automation Report");
                spark.config().setDocumentTitle("Test Results");

                // Attach reporter
                extent = new ExtentReports();
                extent.attachReporter(spark);

                // ✅ Add system/environment info
                extent.setSystemInfo("Tester", "Mostafa Abdelnasser");
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("OS Version", System.getProperty("os.version"));
                extent.setSystemInfo("Java Version", System.getProperty("java.version"));

                //BaseTest baseTest = new BaseTest();

                //extent.setSystemInfo("Browser",baseTest.getBrowserName()); // or parameterize if multiple browsers
                //System.out.println(baseTest.getBrowserName());
                //extent.setSystemInfo("Browser","Chorme"); // or parameterize if multiple browsers
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return extent;
    }

    public static String getReportPath() {
        return reportPath;
    }
    // the version of the browser that iam working on

    public static void setBrowserInfo(String browserName) {
        if (extent != null) {
            extent.setSystemInfo("Browser", browserName);

        }
    }


}
