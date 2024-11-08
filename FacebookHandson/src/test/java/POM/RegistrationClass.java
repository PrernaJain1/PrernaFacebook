package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static UtilityFunctions.BaseClass.driver;
import static UtilityFunctions.BaseClass.properties;

public class RegistrationClass {
    public static void CreateNewAccount(){
        //Click on create new account
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        //Enter details
        driver.findElement(By.name("firstname")).sendKeys(properties.getProperty("UserName"));
        driver.findElement(By.name("lastname")).sendKeys(properties.getProperty("LastName"));
        Select Day= new Select(driver.findElement(By.id("day")));
        Day.selectByValue("9");
        Select month = new Select(driver.findElement(By.name("birthday_month")));
        month.selectByIndex(8);
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("2001");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys(properties.getProperty("Email"));
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(properties.getProperty("Password"));
//        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    }
}
