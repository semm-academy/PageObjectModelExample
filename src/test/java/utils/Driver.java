package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Singleton Design Pattern
// Bir siniftan yalnizca bir tane nesne uretilmesine musaade eder.
public class Driver {
    private static WebDriver driver;

    // You cannot do like this, if constructor is private Driver obj = new Driver()
    private Driver() {

    }

    public static WebDriver get() {
        //if webdriver object was not created yet
        if (driver == null) {
            //create webdriver object based on browser value from properties file
            String browser = ConfigReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    //if browser type is wrong, throw exception.
                    //no browser will be opened
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        //if webdriver object was created - you can use it
        return driver;
    }

    public static void close() {
        //if driver still exist
        if (driver != null) {
            //close all browsers
            driver.quit();
            //destroy driver object, ready for gc
            driver = null;
        }
    }
}