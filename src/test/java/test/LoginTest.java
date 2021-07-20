package test;

import login.LoginPage;
import org.testng.annotations.Test;
import setup.GlobalVariable;

public class LoginTest extends LoginPage {

    @Test(priority = 1)
    public void successLogin() {
        openUrl();
        clickIgnoreNotification();
        inputEmailLogin(GlobalVariable.emailLogin);
        inputPasswordLogin(GlobalVariable.passwordLogin);
        buttonSubmitLogin();
        verifyLogin();
    }

    @Test(priority = 2)
    public void failedLoginWithWrongPassword() {
        openUrl();
        clickIgnoreNotification();
        inputEmailLogin(GlobalVariable.emailLogin);
        inputPasswordLogin(GlobalVariable.passwordIncorrect);
        buttonSubmitLogin();
        verifyLogin();
    }

    @Test(priority = 3)
    public void failedLoginWithEmailNotRegister() {
        openUrl();
        clickIgnoreNotification();
        inputEmailLogin(GlobalVariable.emailUnregistered);
        inputPasswordLogin(GlobalVariable.passwordLogin);
        buttonSubmitLogin();
        verifyLogin();
    }

    @Test(priority = 4)
    public void successLoginWithGoogle() {
        openUrl();
        clickIgnoreNotification();
        loginWithGoogle();
        inputGmail(GlobalVariable.emailLogin);
        clickButtonNextGoogle();
        inputPasswordGmail(GlobalVariable.passwordGoogle);
        clickButtonNextPassword();
    }
}