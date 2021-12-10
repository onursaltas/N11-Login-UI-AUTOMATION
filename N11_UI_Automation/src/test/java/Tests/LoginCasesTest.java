package Tests;
/**
 * Created by onur on 10/12/21.
 */

import ErrorDictionary.errorReport;
import Pages.*;
import Users.AccountInformation;
import Users.UserPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginCasesTest extends InitialTest implements errorReport {

    WebDriverWait wait;
    WebDriver driver;


    @Test
    public void T01_Control_Show_Pass_Flow(){

        logger.info("Case 1: Control Show Pass Flow");

        homePage.AccountSıgnIn();

        homePage.AccountSıgnIn();
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        AccountInformation accountInformation = UserPool.getUserFirst();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        if (loginPage.ClickShowPass() == Boolean.TRUE ){
            System.out.println("password can be viewed");
        }
       driver.quit();
    }

    @Test
    public void T02_Control_Dont_Forgot_Flow(){

        logger.info("Case 2: Control Dont Forgot Flow");

        homePage.AccountSıgnIn();

        homePage.AccountSıgnIn();
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        AccountInformation accountInformation = UserPool.getUserFirst();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickDontForget();
        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.GotoAccount();
        checkAccount.accountNameControl();
        driver.quit();
        driver.get("https://www.n11.com/");
        checkAccount.GotoAccount();
        checkAccount.accountNameControl();

    }

    @Test
    public void T03_Enter_correct_username_and_correct_password(){

        logger.info("Case 3 : When Enter Correct Username and Correct Password");

        homePage.AccountSıgnIn();
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        AccountInformation accountInformation = UserPool.getUserFirst();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();
        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.GotoAccount();
        checkAccount.accountNameControl();

    }
    @Test
    public void T04_Enter_incorrect_username_and_correct_password(){

        logger.info("Case 4 : When Enter Incorrect Username and Correct Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserSecond();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedEmailControl(InvalidMail);



    }

    @Test
    public void T05_Enter_correct_username_and_incorrect_password(){

        logger.info("Case 5 : When Enter Correct Username and Incorrect Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserThird();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(CorrectMail_IncorrectPassword);


    }

    @Test
    public void T06_Empty_username_and_empty_password(){

        logger.info("Case 6 : When Empty Username and Empty Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        loginPage.Username("");
        loginPage.Password("");
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedEmailControl(EmptyMail);
        checkAccount.failedPasswordControl(EmptyPassword);


    }

    @Test
    public void T07_Enter_More_48_length_username_and_valid_password(){

        logger.info("Case 7 : When Username Has More 48 Length and Valid Password");


        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserFourth();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();

        Assert.assertEquals("48", loginPage.GetUserName());
        loginPage.ClickLoginButton();
        CheckAccount checkAccount = loginPage.checkAccount();


    }
    @Test
    public void T08_Enter_More_48_length_username_and_empty_password(){

        logger.info("Case 8 : When Username Has More 48 Length and Empty Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserFıve();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        Assert.assertEquals("48", loginPage.GetUserName());
        loginPage.ClickLoginButton();
        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(EmptyPassword);


    }

    @Test
    public void T09_Enter_correct_username_and_More_15_Length_password(){

        logger.info("Case 9 : When Valid Username and Password Has More 15 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserSix();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(More15DıgıtPassword);

    }

    @Test
    public void T10_Enter_empty_username_and_More_15_Length_password(){

        logger.info("Case 10 : When Empty Username and Password Has More 15 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserSix();
        loginPage.Username("");
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedEmailControl(EmptyMail);
        checkAccount.failedPasswordControl(More15DıgıtPassword);


    }
    @Test
    public void T11_Enter_Valid_username_and_Less_6_Length_password(){

        logger.info("Case 11 : When Valid Username and Password Has Less 6 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        AccountInformation accountInformation = UserPool.getUserSeven();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(Less6DıgıtPassword);

    }
    @Test
    public void T12_Enter_empty_username_and_Less_6_Length_password(){


        logger.info("Case 12 : When Empty Username and Password Has Less 6 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        AccountInformation accountInformation = UserPool.getUserSeven();
        loginPage.Username("");
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedEmailControl(EmptyMail);
        checkAccount.failedPasswordControl(Less6DıgıtPassword);

    }

    @Test
    public void T13_Enter_More_48_length_username_and_Less_6_Length_password(){

        logger.info("Case 13 : When Username Has More 48 Length and Password Has Less 6 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserEight();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        Assert.assertEquals("48", loginPage.GetUserName());
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(Less6DıgıtPassword);

    }

    @Test
    public void T14_Enter_More_48_length_username_and_More_15_Length_password(){

        logger.info("Case 14 : When Username Has More 48 Length and Password Has More 15 Length");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();

        AccountInformation accountInformation = UserPool.getUserNine();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());
        loginPage.CloseAlert();
        Assert.assertEquals("48", loginPage.GetUserName());
        loginPage.ClickLoginButton();

        CheckAccount checkAccount = loginPage.checkAccount();
        checkAccount.failedPasswordControl(More15DıgıtPassword);

    }



}
