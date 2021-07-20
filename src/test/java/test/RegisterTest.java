package test;

import org.testng.annotations.Test;
import register.RegisterPage;
import setup.GlobalVariable;

public class RegisterTest extends RegisterPage {

    @Test
    public void successRegister(){
        openUrl();
        clickIgnoreNotification();
        clickIconLogin();
        clickButtonRegister();
        inputEmailRegister(GlobalVariable.emailLogin);
        clickButtonSubmitRegister();
        verifyModalRegister();
    }
}