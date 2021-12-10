package Pages;
/**
 * Created by onur on 10/12/21.
 */

import Locators.Locator;
import Xpaths.CheckAccountConstans;
import Xpaths.ForgotPasswordConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPage extends Locator implements ForgotPasswordConstants {

    private WebDriverWait wait;
    private WebDriver driver;


    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public void GotoForgotPasswordButton(){
        sleep(1000);
        ClickById(forgotPassword);
    }


    public void SendMail(String mail){
        sleep(1000);
        SendById(usernameTextBoxForgot,mail);
    }


    public void ClickForgotPassword(){

        sleep(1000);
        ClickById(sendLinkPassword);
    }
    public void ClickCloseButton(){
        sleep(1000);
        ClickByXpath(closePopUp);
    }


    public void failedPasswordControl(String message){
        sleep(1000);
        Assert.assertEquals(message, GetTextByXpath("d"));
    }

    public void failedEmailControl(String message){
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        sleep(1000);
        Assert.assertEquals(message, GetTextByXpath(emailOutputForgotPassword));
    }

    public Integer failedEmailLegnthControl(){
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        sleep(1000);
       Integer solution = GetTextByXpath(emailOutputForgotPassword).length();

        return solution;
    }

    /*
    public boolean failedEmailControl(String message) {
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        sleep(1000);
        Boolean solution = Assert.assertEquals(message, GetTextByXpath(emailOutputForgotPassword));
        return solution;
    }

*/





}
