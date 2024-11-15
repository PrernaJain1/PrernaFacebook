package KeyDrivenFramework.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentClass {


    public static ExtentReports getReport(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/Spark.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA","Prerna");

        return extent;
    }
}
