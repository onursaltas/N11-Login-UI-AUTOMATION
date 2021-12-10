package Pages;
/**
 * Created by onur on 10/12/21.
 */

import Locators.Locator;
import Xpaths.LoginConstants;
import Xpaths.URLConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Locator implements LoginConstants , URLConstants {


    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }


    public void Username(String name) {
        sleep(1000);
        SendById(usernameTextBox,name);
    }
    public Integer GetUserName() {
        sleep(1000);
        Integer mailLegth=GetTextById(usernameTextBox).length();
        return mailLegth;

    }

    public void Password(String password) {
        sleep(1000);
        SendById(passwordTextBox,password);
    }

    public void CloseAlert() {
        sleep(1000);
        ClickByXpath(closeAlert);
    }

    public void ClickLoginButton() {
        sleep(1000);
        ClickById(loginButton);
    }

    public void ClickDontForget(){
        sleep(1000);
        ClickById(dontForget);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    public Boolean ClickShowPass(){


        if(IsDisplayed(passwordTextBox) == Boolean.FALSE ){
            sleep(1000);
            ClickById(dontForget);
        }
        sleep(1000);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return IsDisplayed(passwordTextBox);
    }

    public CheckAccount checkAccount() {
        sleep(3000);
        return new CheckAccount(driver);
    }

    public void ClickAppleWithLogin() {
        sleep(1000);
        ClickByXpath(appleWithLogin);

        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualAppleURL, expectedURL);
    }
    public void ClickFastLogin() {
        sleep(1000);
        ClickByXpath(fastLogin);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualFastLoginUrl, expectedURL);
    }
    public void ClickLoginWithFacebook() {
        sleep(1000);
        ClickByXpath(loginWithFacebook);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualFacebookUrl, expectedURL);
    }
    public void ClickDogusLink() {
        sleep(1000);
        ClickByXpath(doguslink);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualDogusUrl, expectedURL);
    }
    public void ClickSkLink() {
        sleep(1000);
        ClickByXpath(skLink);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualSkUrl, expectedURL);
    }
    public void ClickKvkkLink() {
        sleep(1000);
        ClickByXpath(kvkkLink);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualKvkkUrl, expectedURL);
    }
    public void ClickConditionLink() {
        sleep(1000);
        ClickByXpath(conditionLink);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualConditionOfUserUrl, expectedURL);
    }
    public void ClickSıgnInLink() {
        sleep(1000);
        ClickByXpath(sıgnIn);
        String expectedURL = driver.getCurrentUrl();
        Assert.assertEquals(actualSıgnInUrl, expectedURL);
    }







}
