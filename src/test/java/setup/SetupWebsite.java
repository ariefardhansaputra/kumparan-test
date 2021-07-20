package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class SetupWebsite {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Select select;
	public static GlobalVariable variable;
	
	@BeforeTest
	public static void setup() {

		String OS = System.getProperty("os.name").toLowerCase();
		System.out.println("os.name: " + OS);

		if (OS.indexOf("win") >= 0) {
			System.out.println("This is Windows");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver/chromedriver_windows.exe");
		} else if (OS.indexOf("mac") >= 0) {
			System.out.println("This is Mac");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver/chromedriver_mac");
		} else if (OS.indexOf("nix") >= 0
				|| OS.indexOf("nux") >= 0
				|| OS.indexOf("aix") > 0) {
			System.out.println("This is Unix or Linux");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver/chromedriver_linux");
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		variable = new GlobalVariable();
		wait = new WebDriverWait(driver, 60);
	}
}