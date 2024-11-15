package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static UtilityFunctions.BaseClass.driver;
import static UtilityFunctions.BaseClass.properties;

public class LoginClass {

    public static void LogInFacebook() throws InterruptedException {
        Actions a =new Actions(driver);
        //Enter email
        WebElement userEmail=driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']"));
        a.moveToElement(userEmail).sendKeys(properties.getProperty("Email")).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Enter password
        WebElement pass = driver.findElement(By.xpath("//input[@aria-label='Password']"));
        a.moveToElement(pass).click().sendKeys(properties.getProperty("Password")).build().perform();

        //Click on login
        driver.findElement(By.cssSelector("button[name='login']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
}
