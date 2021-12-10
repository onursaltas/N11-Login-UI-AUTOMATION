package Pages;
/**
 * Created by onur on 10/12/21.
 */

import Locators.Locator;
import Xpaths.CheckAccountConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static Xpaths.LoginConstants.dontForget;
import static org.junit.Assert.assertEquals;

public class CheckAccount extends Locator implements CheckAccountConstans  {

    private WebDriverWait wait;
    private WebDriver driver;


    public CheckAccount(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public void GotoAccount(){
        ClickByXpath(goAccount);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals("https://www.n11.com/hesabim/siparislerim", driver.getCurrentUrl());
    }



    public void accountNameControl(){
        Assert.assertEquals("qquestion answerr", GetTextByXpath(accuntName));
    }


    public void failedPasswordControl(String message){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        GetTextByXpath(ınvalidMail);
        Assert.assertEquals(message,GetTextByXpath(ınvalidMail));
    }

    public void failedEmailControl(String message){
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        Assert.assertEquals(message, GetTextByXpath(ınvalidMail));
    }


    public ForgotPasswordPage forgotPasswordPage() {

        sleep(1000);
        return new ForgotPasswordPage(driver);


    }






}
