	package shareregister;
	import org.openqa.selenium.By;
	//import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	public class ResendInvites {
	public WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void LoginJamesOTP() throws InterruptedException, Exception {		
	driver.get("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("3391bc@myclientshare.com");
	driver.findElement(By.id("password")).sendKeys("CS@17@testx");
	JamesCreateShareFirefox.captureScreenShot(driver);
	
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(50000);
	JamesCreateShareFirefox.captureScreenShot(driver);
	
	System.out.println("OTP send to your registed email, write that on loging for to continue.");
	System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test
	public void resendInvites() throws InterruptedException {
		
		
	}
	@AfterTest
	public void close(){
	driver.quit();
	}
}
