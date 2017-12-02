	
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

		public class LoginCaseSenstivity {
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
		
		@Test (priority = 1)
		public void logincaseSenstivity() throws InterruptedException, Exception {
				driver.navigate().to("https://uat-clientspace.herokuapp.com");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(driver.getCurrentUrl());
				System.out.println("URL added on browser");
				WebElement email =  driver.findElement(By.id("email")); Thread.sleep(4000);
				Assert.assertTrue(email.isDisplayed());	
				email.sendKeys("AShiSHkuMaR@ucreate.co.in");
				WebElement password =  driver.findElement(By.id("password")); Thread.sleep(4000);
				Assert.assertTrue(password.isDisplayed());	
				password.sendKeys("Test1234");
				WebElement submit = driver.findElement(By.id("show-sent"));
				Assert.assertTrue(submit.isDisplayed());
				System.out.println("link under test is: " +password.getText());
			    System.out.println("Link isDisplayed yes/no: " +password.isDisplayed());
			    System.out.println("link is enabled true/false: " +password.isEnabled());
			    System.out.println("Link attribute type is: " +password.getAttribute("type"));
			    System.out.println("Link attribute value is: "+password.getAttribute("value"));
			    
			    System.out.println("link under test is: " +email.getText());
			    System.out.println("Link isDisplayed yes/no: " +email.isDisplayed());
			    System.out.println("link is enabled true/false: " +email.isEnabled());
			    System.out.println("Link attribute type is: " +email.getAttribute("type"));
			    System.out.println("Link attribute value is: "+email.getAttribute("value"));
			    submit.click();
			    LoginCaseSenstivity.captureScreenShot(driver);
   
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
