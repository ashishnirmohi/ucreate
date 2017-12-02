		
		package logintestscenarios;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.concurrent.TimeUnit;
		import org.apache.commons.io.FileUtils;		
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.By;
		import java.io.File;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class EmailOnly {
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
		public void LoginEmailOnly() throws InterruptedException, IOException {
		
			driver.navigate().to("https://uat-clientspace.herokuapp.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println(driver.getCurrentUrl());
			System.out.println("URL added on browser");
			WebElement email =  driver.findElement(By.id("email"));	Thread.sleep(500);
			email.sendKeys("ashishkumar@ucreate.co.in");
				
			System.out.println("link under test is: " + email.getText());
			System.out.println("Link isDisplayed yes/no: " +email.isDisplayed());
			System.out.println("link is enabled true/false: " +email.isEnabled());
			System.out.println("Link attribute type is: " +email.getAttribute("type"));
			System.out.println("Link attribute value is: "+email.getAttribute("value"));				
			WebElement submit = driver.findElement(By.id("show-sent")); Thread.sleep(3000);
			submit.click();
			EmailOnly.captureScreenShot(driver);
				
	}
	 
		public static void captureScreenShot(WebDriver driver) throws IOException{
			java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\login\\Screenshot.jpg"));
			String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
			File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\login\\" + filename);
			FileUtils.copyFile(screenshot, dest);
		 
		}
	 
		@AfterTest
		public void close_browser() throws InterruptedException {	
				Thread.sleep(6000);
				driver.quit();	
		}
	
}