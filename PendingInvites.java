	package settings;
		
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class PendingInvites {
	WebDriver driver;
		
	@BeforeTest	
	public void Lauchbrowser(){
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}
	
	@Test (priority=0)
	public void loginAdmin() throws Exception {
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("settingud01@yopmail.com"); Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("@Test1234"); Thread.sleep(3000);
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(2000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
	
	}	
	
	@Test (priority=4)
	public void pendingInvites() throws InterruptedException, IOException {
	WebElement setting3 = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(setting3.isDisplayed());
	setting3.click(); Thread.sleep(4000); 
	driver.findElement(By.xpath("//*[@id='temp_trigger']")).click();	
	PendingInvites.captureScreenShot(driver);
	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
	java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
	String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
	File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\settings\\" + filename);
	FileUtils.copyFile(screenshot, dest);
		 
	}
		
	@AfterTest
	public void close_browser() throws Exception {	
	Thread.sleep(3000);
	driver.close();
	System.out.println("Browser closed successgully");
	System.out.println("------------------------------------------------------------------------------------------");
	}
}
