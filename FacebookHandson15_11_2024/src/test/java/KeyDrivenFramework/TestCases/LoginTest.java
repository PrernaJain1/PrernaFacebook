package KeyDrivenFramework.TestCases;

import KeyDrivenFramework.KeyEngine.Listners;
import KeyDrivenFramework.KeyEngine.keyEngine;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Listeners(Listners.class)
public class LoginTest extends keyEngine {

    keyEngine key;
    ExtentReports extentReports;
//    Logger logger = LogManager.getLogger(LoginTest.class)


    @BeforeTest
    public void preTest(){
        key = new keyEngine();
    }

    @Test
    public void read() throws IOException {
        String FilePath = System.getProperty("user.dir")+"//src//test//resource//FileUpload//KeyDriven.xlsx";
        keyEngine.service(FilePath);
    }

    @Test
    public void mytest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("emai")).click();
    }

    @AfterTest
    public void postTest(){
        keyEngine.setDown();
    }
}
