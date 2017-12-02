	package logintestscenarios;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;	
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
	public class ResetPassword {
	public WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
			System.out.println("------------------------------------------------------------------------------------------");
			System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
			driver = new FirefoxDriver();
			driver.manage().window().maximize();		
			System.out.println("Browser opened ");
			System.out.println("Successfully passed!, launchbrowser()");
			System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	@Test
	public void changePassword() throws InterruptedException {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		System.out.println("URL added on browser");
		WebElement email =  driver.findElement(By.id("email")); Thread.sleep(4000);
		WebElement password =  driver.findElement(By.id("password")); Thread.sleep(4000);
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(password.isDisplayed());
		
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\login\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
	
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
		Thread.sleep(4000);
		driver.quit();	
		}	
}
