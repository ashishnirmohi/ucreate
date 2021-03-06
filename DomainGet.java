package RandD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DomainGet {
	public WebDriver driver;
	
	@BeforeClass
	public void loginCS() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();	
	System.out.println("Successfully passed!, launchbrowser()");
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in"); Thread.sleep(2000);
	driver.findElement(By.id("password")).sendKeys("Test1234");
	driver.findElement(By.id("show-sent")).click(); Thread.sleep(5000);	
	}
	
	@Test
	 public void test () 
	 {  
	  String CurrentURL = driver.getCurrentUrl();
	  System.out.println("My Current URL Is  : "+CurrentURL);
	  
	  //Get and store domain name in variable
	  JavascriptExecutor javascript = (JavascriptExecutor) driver;
	  String DomainUsingJS=(String)javascript.executeScript("return document.domain");  
	  System.out.println("My Current URL Is  : "+DomainUsingJS);
	 }
	
	@AfterClass
	public void tearDown() throws InterruptedException {
	Thread.sleep(4000);
	driver.close();
	System.out.println("Browser closed successgully");
	
	}
}
