package Tests;
/**
 * Created by onur on 10/12/21.
 */

import ErrorDictionary.errorReport;
import Pages.CheckAccount;
import Pages.LoginPage;
import Users.AccountInformation;
import Users.UserPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AllUrlControlsTest extends InitialTest implements errorReport {

    WebDriverWait wait;
    WebDriver driver;



    @Test
    public void T01_Enter_Login_With_Apple(){

        logger.info("Case 1 : Login With Apple");

        homePage.AccountSıgnIn();
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickAppleWithLogin();



    }
    @Test
    public void T02_Enter_Fast_Login(){

        logger.info("Case 2 : Fast login");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickFastLogin();



    }

    @Test
    public void T03_Enter_Login_With_Facebook(){

        logger.info("Case 3 : Login With Facebook");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickLoginWithFacebook();

    }

    @Test
    public void T04_Empty_Sıgn_In(){

        logger.info("Case 4 : Control Sıgn In Button");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickSıgnInLink();



    }

    @Test
    public void T05_Control_Dogus_URL(){

        logger.info("Case 5 : Control Dogus Url");


        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickDogusLink();


    }
    @Test
    public void T06_Control_KVKK_URL(){

        logger.info("Case 6 : When Username Has More 48 Length and Empty Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickKvkkLink();


    }

    @Test
    public void T07_Control_Condition_Of_User_URL(){

        logger.info("Case 7 : Control condition of user url");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickConditionLink();

    }
    @Test
    public void T08_Control_Sk_URL(){

        logger.info("Case 8 : Control Sk url");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        loginPage.ClickSkLink();

    }





}
