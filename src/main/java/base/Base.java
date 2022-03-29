package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import  org.apache.log4j.LogManager;
import  org.apache.log4j.Logger;
public class Base {

    public static WebDriver driver;
    public static Properties prop;

    public static void initialization() {

        System.setProperty("webdriver.chrome.driver", "C:\\SdetSoftwares\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public static void FailedTest() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\vypant\\FinalSeleniumMainProject\\src\\main\\java\\data\\SS\\\\FailedTest.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
