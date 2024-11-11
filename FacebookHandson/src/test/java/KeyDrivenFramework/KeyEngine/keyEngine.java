package KeyDrivenFramework.KeyEngine;

import KeyDrivenFramework.Utils.util;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class keyEngine {
    public static WebDriver driver;

    public static void service(String filePath) throws IOException {

        XSSFSheet sheet = util.readFile(filePath);

        for(Row row : sheet){
            String keyword = row.getCell(0).getStringCellValue();
            String locatorType = row.getCell(1).getStringCellValue();
            String locatorValue = row.getCell(2).getStringCellValue();
            String data = row.getCell(3).getStringCellValue();

            switch (keyword){
                case "OpenBrowser":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "Navigate":
                    driver.get(data);
                    break;
                case "EnterText":
                    getElement(locatorType,locatorValue).sendKeys(data);
                    break;
                case "Click":
                    getElement(locatorType,locatorValue).click();
                    break;
                case "NA":
                    break;
                default:
                    System.out.println("Invalid Keyword: "+ keyword);
                    break;
            }
        }
    }
    public static WebElement getElement(String locatorType, String locatorValue){
        WebElement element =null;

        switch(locatorType){
            case "id":
                element = driver.findElement(By.id(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "cssSelector":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "linkText":
                element = driver.findElement(By.linkText(locatorValue));
                break;
            case "partialLinkText":
                element = driver.findElement(By.partialLinkText(locatorValue));
                break;
            case "className":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "tagName":
                element = driver.findElement(By.tagName(locatorValue));
                break;
            default:
                System.out.println("LocatorType entered is incorrect"+ locatorType);
                break;
        }
        return element;
    }

    public static void setDown(){
        driver.quit();
    }
}
