package KeyDrivenFramework.TestCases;

import KeyDrivenFramework.KeyEngine.keyEngine;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginTest implements ITestListener {

    keyEngine key;

//    Logger logger = LogManager.getLogger(LoginTest.class)

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public void preTest(){
        extentReports = new ExtentReports();
        extentSparkReporter =new ExtentSparkReporter("target/Spark.html");
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("KeyDriven");
        extentSparkReporter.config().setReportName("Test Report");

        key = new keyEngine();
    }

    @Test
    public void read() throws IOException {
        extentReports.createTest("KeywordDriven").log(Status.PASS, "Working fine");
        String FilePath = System.getProperty("user.dir")+"//src//test//resource//FileUpload//KeyDriven.xlsx";
        keyEngine.service(FilePath);
    }

    @AfterTest
    public void postTest(){
        extentReports.flush();
        keyEngine.setDown();
    }
}
