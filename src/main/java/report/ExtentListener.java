package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
   

 

    @Override
    public void onStart(ITestContext context) {
        // Generate a unique filename with a timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String reportName = "ExtentReport_" + timestamp + ".html";

        // Configure ExtentSparkReporter with the unique filename
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/" + reportName);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add System Information to the Report
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Start logging the test in ExtentReports
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log a pass result in ExtentReports
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log a failure result in ExtentReports
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());

        // Capture and attach screenshot for failure
//        try {
//            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
//            test.addScreenCaptureFromPath(screenshotPath);
//        } catch (IOException e) {
//            test.log(Status.FAIL, "Failed to attach screenshot: " + e.getMessage());
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log a skipped result in ExtentReports
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        test.log(Status.SKIP, result.getThrowable());

        // Capture and attach screenshot for skipped tests
//        try {
//            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
//            test.addScreenCaptureFromPath(screenshotPath);
//        } catch (IOException e) {
//            test.log(Status.SKIP, "Failed to attach screenshot: " + e.getMessage());
//        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Log a partial success result
        test.log(Status.WARNING, "Test Failed but within success percentage: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Finalize the report generation
        extent.flush();
    }

    // Method to capture screenshots
//    private String captureScreenshot(String methodName) throws IOException {
//        // Check if the driver is a valid instance of TakesScreenshot
//        if (driver instanceof TakesScreenshot) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File srcFile = ts.getScreenshotAs(OutputType.FILE);
//
//            // Ensure the screenshot directory exists, if not, create it
//            File screenshotDir = new File("screenshots");
//            if (!screenshotDir.exists()) {
//                screenshotDir.mkdirs();
//            }
//
//            String screenshotPath = "screenshots/" + methodName + ".png";
//            FileUtils.copyFile(srcFile, new File(screenshotPath));
//            return screenshotPath;
//        } else {
//            throw new IOException("Driver does not support screenshot capture");
//        }
 //   }
}
