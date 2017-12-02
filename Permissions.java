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
	public class Permissions {
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser(){
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}
	
	@Test (priority=0)
	public void permissionlogin() throws Exception {
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("settingud01@yopmail.com"); Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("@Test1234"); Thread.sleep(3000);
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(2000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
	
	
	}	
		
	@Test(priority=7)
	public void permissionOff() throws InterruptedException, IOException {
	WebElement setting6 = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(setting6.isDisplayed());
	setting6.click(); Thread.sleep(4000); 
	Thread.sleep(4000);
	driver.findElement(By.linkText("Permissions")).click();	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/div[1]/label")).click(); Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/div[2]/label")).click(); Thread.sleep(2000);	
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/button")).click(); Thread.sleep(4000);
	Permissions.captureScreenShot(driver);
	System.out.println(driver.getCurrentUrl());
	driver.navigate().refresh();
	driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[1]/a")).click();
	
	}
	
	@Test(priority=6)
	public void permissionOn() throws InterruptedException, IOException {
	WebElement setting7 = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(setting7.isDisplayed());
	setting7.click(); Thread.sleep(4000); 
	Thread.sleep(4000);
	driver.findElement(By.linkText("Permissions")).click();	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/div[1]/label")).click(); Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/div[2]/label")).click(); Thread.sleep(2000);	
	driver.findElement(By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/button")).click(); Thread.sleep(4000);
	Permissions.captureScreenShot(driver);
	System.out.println(driver.getCurrentUrl());
	driver.navigate().refresh();
	driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[1]/a")).click();
	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
	java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
	String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
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
