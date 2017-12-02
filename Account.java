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
	
	public class Account {
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser(){
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}

	@Test (priority=0)
	public void accountLogin() throws Exception {
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("settingud01@yopmail.com"); Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("@Test1234"); Thread.sleep(3000);
	Account.captureScreenShot(driver);
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(2000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
	}	
	
	@Test(priority=1) 
	public void accountPassword() throws InterruptedException, IOException { 
	WebElement setting4 = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a")); Thread.sleep(4000);
	setting4.click(); Thread.sleep(4000); 
	Thread.sleep(4000);
	driver.findElement(By.linkText("Account")).click();	
	driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[1]/input")).sendKeys("@Test1234");
	driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[2]/input")).sendKeys("Test1234");
	driver.findElement(By.name("new_confirm_password")).click();  Thread.sleep(4000); 	
	driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[3]/input")).sendKeys("Test1234");
	Account.captureScreenShot(driver);
	driver.findElement(By.xpath("//*[@id='password-tab']/div[2]/form/button")).click(); Thread.sleep(4000); 	
	System.out.println(driver.getCurrentUrl());
	driver.navigate().refresh();
	Account.captureScreenShot(driver);
	
	}
	
	@Test (priority=3)
	public void resetPassword() throws InterruptedException, IOException {
	WebElement setting5 = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	setting5.click(); Thread.sleep(4000); 	
	driver.findElement(By.linkText("Account")).click();	
	driver.findElement(By.name("current_password")).sendKeys("Test1234");
	driver.findElement(By.name("new_password")).sendKeys("@Test1234");
	driver.findElement(By.name("new_confirm_password")).click();  Thread.sleep(4000); 	
	driver.findElement(By.name("new_confirm_password")).sendKeys("@Test1234");
	Account.captureScreenShot(driver);
	driver.findElement(By.xpath("//*[@id='password-tab']/div[2]/form/button")).click(); Thread.sleep(4000); 	
	System.out.println(driver.getCurrentUrl());
	driver.navigate().refresh();
	Account.captureScreenShot(driver);
	
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
