package Test_Suite.Test_Ixigo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class URL_LaunchTest {
	WebDriver driver;
		
	//Setting up the browser launch
	@Test(priority=1)
	public void  setup() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\new\\chromedriver.exe");
	
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("https://www.ixigo.com/");
	}
	
	//Verifying Home page of the ixigo
	@Test(priority =2)
	public void verifyPageTest() {
		String title = "ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels";
	String actualTitle=driver.getTitle();
	Assert.assertEquals(title, actualTitle);
	}	
	
	//Entering the journey details and number of passengers
	@Test(priority = 3)
	public void journeyDetailTest() throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Round Trip']")).click();
	//Entering the origin city value
	driver.findElement(By.xpath("//div[text()='From']")).click();
	WebElement from = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[6]/div/div/div[1]/div/div[1]/input"));
	from.sendKeys("Delhi");
	Thread.sleep(2000);
	from.sendKeys(Keys.ENTER);
	
	//Entering the destination city value
	driver.findElement(By.xpath("//div[text()='To']")).click();
	WebElement to =driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[6]/div/div/div[3]/div/div[1]/input"));
	to.sendKeys("Blr");
	Thread.sleep(2000);
	to.sendKeys(Keys.ENTER);
	
	//Selecting departure date
	driver.findElement(By.xpath("//input[@ placeholder='Depart']")).click();
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr/td/div[contains(text(),'25')]")).click();
	Thread.sleep(2000);
	
	//Selecting return date
	driver.findElement(By.xpath("//input[@ placeholder='Return']")).click();
	driver.findElement(By.cssSelector("body > div.rd-container.flight-ret-cal.extra-bottom.arrow-animation.rd-container-attachment > div.rd-date > div:nth-child(1) > table > tbody > tr:nth-child(5) > td:nth-child(2) > div.day.has-info")).click();
	
	//Adding number of travellers
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[6]/div/div/div[5]/div/div[1]/input")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[6]/div/div/div[5]/div/div[2]/div[2]/div[1]/div[2]/span[2]")).click();
	}
	
	//Validating result page
	@Test(priority =4)
	public void flightSearchTest() {

	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[6]/div/div/div[6]/button/div")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement el1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[1]/div/div[1]"));
	
	//Validating the result page by verifying result page title
	String expectedTitle = "New Delhi - Bengaluru, Economy Flights, roundtrip, 25 Mar - 29 Mar";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	//Validating filter options
	@Test(priority =5)
	public void validateDetailsTest() {
	String text ="Stops";
	WebElement el1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[1]/div/div[1]"));
	String t1 = el1.getText();
	System.out.print(text);
	Assert.assertEquals(text, t1);
	
	String depart ="Departure from DEL";
	WebElement el2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]"));
	String t2 = el2.getText();
	System.out.print(t2);
	Assert.assertEquals(depart, t2);
	
	String airline ="Airlines";
	WebElement el3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[3]/div/div[1]"));
	String t3 = el3.getText();
	System.out.print(t3);
	Assert.assertEquals(airline, t3);
	
	//Selecting only non-Stop flights
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]/span/div[1]/span[1]/span")).click();
	}
	
	//Printing the airline details
	@Test(priority = 6)
	public void airlineDetailsTest() {
		
		driver.quit();
	}
}
