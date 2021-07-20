package register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import setup.SetupWebsite;

public class RegisterPage extends SetupWebsite {

    public void openUrl() {
        driver.get("https://kumparan.com/");
    }

    public void clickIgnoreNotification(){
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

    public void clickIconLogin(){
        driver.findElement(By.xpath("//*[@data-qa-id=\"profile\"]")).click();
    }

    public void clickButtonRegister(){
        try {
            Thread.sleep(2000);
            ((JavascriptExecutor)driver).executeScript("document.querySelector('[href=\"/register\"]').click()");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inputEmailRegister(String email){
        driver.findElement(By.xpath("//*[@data-qa-id=\"input-email\"]")).sendKeys(email);
    }

    public void clickButtonSubmitRegister(){
        driver.findElement(By.xpath("//*[@data-qa-id=\"btn-save\"]")).click();
    }

    public void verifyModalRegister(){
        try{
            Thread.sleep(2000);
            String popupMessage = driver.findElement(By.xpath("//*[@data-qa-id=\"content\"]/div/span")).getText();
            System.out.println(popupMessage);
            if (popupMessage.contains("Link verifikasi sudah dikirim")){
                driver.findElement(By.xpath("//*[@data-qa-id=\"btn-process\"]")).click();
                System.out.println("Register Success");
            } else {
                System.out.println("Register Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
