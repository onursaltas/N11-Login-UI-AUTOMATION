package Tests;
/**
 * Created by onur on 10/12/21.
 */
import Locators.*;
import Pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class InitialTest   {

    public static  WebDriver driver;
    public WebDriverWait wait;
    public static HomePage homePage;
    public static Logger logger;



    String browser = "chrome";
    @BeforeClass
    public void setUp() {

        logger= Logger.getLogger("N11 UI Automation");//added Logger
        PropertyConfigurator.configure("log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);


        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }  else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 15);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        logger.info("Go To N11 Web Page");
        String url = "https://www.n11.com/";
        driver.get(url);
        driver.manage().window().maximize();

        logger.info("Verify N11 Web Page From Title");
        String actualTitle = driver.getTitle();
        String expectedTitle = "n11.com - Hayat Sana Gelir";
        Assert.assertEquals(expectedTitle, actualTitle);

        homePage = new HomePage(driver);

    }

    @AfterClass
    public static void tearDown() {
        logger.info("Close Browser");
        driver.quit();
    }



}
