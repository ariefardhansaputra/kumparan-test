package news;

import org.openqa.selenium.By;
import setup.SetupWebsite;

public class NewsPage extends SetupWebsite {

    String title;

    public void openUrl() {
        driver.get("https://kumparan.com/");
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

    public void clickNews() {
//        title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[1]/a/span")).getText();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[1]/a/span")).click();
    }

    public void verifyNewsSelected(){
        verifyNewsSelected();
    }
}
