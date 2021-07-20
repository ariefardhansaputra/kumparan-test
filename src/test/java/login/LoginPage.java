package login;

import org.openqa.selenium.By;
import setup.SetupWebsite;

public class LoginPage extends SetupWebsite {

    public void openUrl() {
        driver.get("https://kumparan.com/login");
    }

    public void clickIgnoreNotification() {
        try {
            Thread.sleep(5000);
            Boolean notification = driver.findElements(By.id("onesignal-slidedown-cancel-button")).size() != 0;
            if (notification){
                driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputEmailLogin(String email) {
        try{
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@data-qa-id=\"input-email\"]")).sendKeys(email);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inputPasswordLogin(String password) {
        driver.findElement(By.xpath("//*[@data-qa-id=\"input-password\"]")).sendKeys(password);
    }

    public void buttonSubmitLogin() {
        driver.findElement(By.xpath("//*[@data-qa-id=\"btn-save\"]")).click();
    }

    public void verifyLogin() {
        try {
            Thread.sleep(2000);
            Boolean alert = driver.findElements(By.xpath("//*[@data-qa-id=\"main-section\"]/div/div[2]/div/div/div[2]/div/span")).size() != 0;
            System.out.println(alert);
            if (alert) {
                System.out.println("Login Failed");
            } else {
                System.out.println("Login Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginWithGoogle(){
        try{
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@data-qa-id=\"btn-login-google\"]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputGmail(String email){
        try{
            Thread.sleep(2000);
            String winHandleBefore = driver.getWindowHandle();

            for(String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            driver.findElement(By.id("identifierId")).sendKeys(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickButtonNextGoogle(){
        driver.findElement(By.id("identifierNext")).click();
    }

    public void inputPasswordGmail(String password){
        try{
            Thread.sleep(2000);
            driver.findElement(By.name("password")).sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickButtonNextPassword(){
        driver.findElement(By.id("passwordNext")).click();
    }
}