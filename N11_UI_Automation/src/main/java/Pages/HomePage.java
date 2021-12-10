package Pages;
/**
 * Created by onur on 10/12/21.
 */

import Locators.Locator;
import Xpaths.HomeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends Locator implements HomeConstants {

    private WebDriverWait wait;
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }
    public void AccountSıgnIn(){
        sleep(1000);
        ClickByXpath(accountSıgnIn);
    }

    public void UrlControl(){

        sleep(1000);
        Assert.assertEquals("https://www.n11.com/giris-yap", driver.getCurrentUrl());

    }


    public LoginPage loginPage() {

        sleep(1000);
        Assert.assertEquals("Giriş Yap", GetTextByXpath(loginScreenControl));
        return new LoginPage(driver);


    }

}
