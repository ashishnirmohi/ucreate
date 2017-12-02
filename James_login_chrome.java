package admindashboard;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class James_login_chrome {
	public WebDriver driver;
@Test	
	public void launchbrowser() {
	//System.out.println("Opening Browser chrome browser");
	System.setProperty("webdriver.chrome.driver", "D://Softwares//crossbrowsertesting//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}	
@Test
	public void login() throws InterruptedException {
	driver.get("https://uat-clientspace.herokuapp.com");
	//driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("3391bc@myclientshare.com");
	driver.findElement(By.id("password")).sendKeys("CS@17@testx");
	driver.findElement(By.id("show-sent")).click();	
	
	//Add seller company
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
 Thread.sleep(4000);
	
	driver.findElement(By.xpath("//a[text()='ADD CLIENT SHARE']")).click();
	
	//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	 Thread.sleep(4000);
	 
	 driver.findElement(By.id("seller")).sendKeys("Vodafone");
	 
	//driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[1]/div/div[1]/div[1]/a[2]/div")).click();
	//driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[1]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	/*
	// Add buyer company
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@name='buyer[buyer_name]']")).sendKeys("Airtel India");
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[2]/div/div[1]/div[2]/a[1]/div")).click();
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[2]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	
	//Add ShareName
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='client_share_name']")).sendKeys("SeleniumAutomationChrome1");
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[3]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	
	//Add email address
	Thread.sleep(4000);
	driver.findElement(By.id("admin_email")).sendKeys("nirmohi.qa@gmail.com");
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[4]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	
	//Add first name 
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='admin_first_name']")).sendKeys("Ashish");
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[5]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	
	//Add last name
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='admin_last_name']")).sendKeys("Nirmohi");
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[6]/div/div[3]/button[2]")).sendKeys(Keys.ENTER);
	
	//check preview share added
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='clientsharerow']/td[7]/div/a/span")).click();
	driver.findElement(By.xpath(".//*[@data-target='#share_preview_modal']")).click();
	driver.findElement(By.xpath(".//*[@id='share_preview_modal']/div/div[1]/button")).click();
	
	//Initiate share
	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[text()='INITIATE']")).click();
	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[text()='INITIATE']")).click();
	driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[3]/button[2]")).click(); */
}
	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
}
