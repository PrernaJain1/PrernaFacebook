package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

import static UtilityFunctions.BaseClass.driver;
import static UtilityFunctions.BaseClass.generateRandomString;

public class PostUploadClass {

    public static void UploadImage() throws AWTException, InterruptedException {
        driver.findElement(By.xpath("//div[@aria-label='Account controls and settings']//div[2]//span//span")).click();
        driver.findElement(By.xpath("(//span[text()='Post'])[2]")).click();
        String s= generateRandomString(4);
        driver.findElement(By.xpath("//div[contains(@data-lexical-editor,'true')]")).sendKeys(s);
        driver.findElement(By.xpath("//span[contains(text(),'Post')]")).click();
        Thread.sleep(5000);
        By profile = By.xpath("(//*[@aria-label='Your profile'])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile));
        driver.findElement(profile).click();
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
    }
}
