package test;

import news.NewsPage;
import org.testng.annotations.Test;
import setup.GlobalVariable;

public class NewsTest extends NewsPage {

    @Test(priority = 1)
    public void successViewNews() {
        openUrl();
        clickIgnoreNotification();
        clickNews();
    }
}
