package Tests;
/**
 * Created by onur on 10/12/21.
 */

import ErrorDictionary.errorReport;
import Pages.CheckAccount;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Users.AccountInformation;
import Users.UserPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;


public class ForgotPasswordCasesTest extends InitialTest implements errorReport {

    WebDriverWait wait;
    WebDriver driver;



    @Test
    public void T01_Enter_correct_username_for_Succesful_Forgot_Password_Process(){

        logger.info("Case 1 : When Enter Correct Username for Succesful Forgot Password Process");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        CheckAccount checkAccount = loginPage.checkAccount();
        ForgotPasswordPage forgotPasswordPage = checkAccount.forgotPasswordPage();
        forgotPasswordPage.GotoForgotPasswordButton();
        AccountInformation accountInformation = UserPool.getUserJustMail();
        forgotPasswordPage.SendMail(accountInformation.getEmail());
        forgotPasswordPage.ClickForgotPassword();
        forgotPasswordPage.failedEmailControl(ForgotPassword);
        forgotPasswordPage.ClickCloseButton();


    }
    @Test
    public void T02_Enter_Empty_username_for_Succesful_Forgot_Password_Process(){

        logger.info("Case 2 : When Enter Empty Username for  Forgot Password Process");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        CheckAccount checkAccount = loginPage.checkAccount();
        ForgotPasswordPage forgotPasswordPage = checkAccount.forgotPasswordPage();
        forgotPasswordPage.GotoForgotPasswordButton();
        forgotPasswordPage.SendMail("");
        forgotPasswordPage.ClickForgotPassword();
        forgotPasswordPage.failedEmailControl(EmptyMail);
        forgotPasswordPage.ClickCloseButton();



    }

    @Test
    public void T03_Enter_Invalid_username_for_Forgot_Password_Process(){

        logger.info("Case 3 : When Enter Empty Username for Forgot Password Process");


        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        CheckAccount checkAccount = loginPage.checkAccount();
        ForgotPasswordPage forgotPasswordPage = checkAccount.forgotPasswordPage();
        forgotPasswordPage.GotoForgotPasswordButton();
        forgotPasswordPage.SendMail("onur");
        forgotPasswordPage.ClickForgotPassword();
        forgotPasswordPage.failedEmailControl(InvalidMail);
        forgotPasswordPage.ClickCloseButton();



    }

    @Test
    public void T04_Enter_username_Doesnt_In_System_for_Forgot_Password_Process(){

        logger.info("Case 4 : When Empty Username and Empty Password");

        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        CheckAccount checkAccount = loginPage.checkAccount();
        ForgotPasswordPage forgotPasswordPage = checkAccount.forgotPasswordPage();
        forgotPasswordPage.GotoForgotPasswordButton();
        AccountInformation accountInformation = UserPool.getUserDoenstInSystem();
        forgotPasswordPage.SendMail(accountInformation.getEmail());
        forgotPasswordPage.ClickForgotPassword();
        //Boolean controlSend = forgotPasswordPage.failedEmailControl(ForgotPassword);
        //if (controlSend==Boolean.TRUE) { System.out.println("Even if the e-mail you entered is not in the system, it sends a password reset link."); }
        forgotPasswordPage.ClickCloseButton();

    }

    @Test
    public void T05_Enter_More_48_length_username_for_forget_password(){

        logger.info("Case 5 : When Username Has More 48 Length for forget password");


        homePage.AccountSıgnIn();

        logger.info("Control : https://www.n11.com/giris-yap Screen ");
        homePage.UrlControl();

        LoginPage loginPage = homePage.loginPage();
        CheckAccount checkAccount = loginPage.checkAccount();
        ForgotPasswordPage forgotPasswordPage = checkAccount.forgotPasswordPage();
        forgotPasswordPage.GotoForgotPasswordButton();
        AccountInformation accountInformation = UserPool.getUserMoreLegth48();
        forgotPasswordPage.SendMail(accountInformation.getEmail());
        if(48<forgotPasswordPage.failedEmailLegnthControl()){
            System.out.println("More than 48 characters can be entered.");
        }
        forgotPasswordPage.ClickForgotPassword();
        forgotPasswordPage.failedEmailControl(InvalidMail);
        forgotPasswordPage.ClickCloseButton();



    }




}
