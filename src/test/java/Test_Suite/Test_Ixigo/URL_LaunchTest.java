package Test_Suite.Test_Ixigo;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URL_LaunchTest {
		
	@Test
	public void  browsermethod() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\new\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	Thread.sleep(5000);
	driver.get("https://www.ixigo.com/");
	
	}	
}
