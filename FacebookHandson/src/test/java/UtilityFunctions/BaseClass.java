package UtilityFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties properties;
    public static WebDriver driver;

    public BaseClass(WebDriver driver){
        BaseClass.driver = driver;
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    public static void driverInitializer() throws IOException {
        //To disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =new ChromeDriver(options);

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        //To read application.properties file
        FileReader reader =new FileReader("src//test//resource//Application.properties");
        properties = new Properties();
        properties.load(reader);
        driver.get(properties.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
