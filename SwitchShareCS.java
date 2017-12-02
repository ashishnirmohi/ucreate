	
		package adminhomepage;
		import java.io.File;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.concurrent.TimeUnit;
		import org.apache.commons.io.FileUtils;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.testng.Assert;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
	
		public class SwitchShareCS {
		public WebDriver driver;
		 
		@BeforeTest
		public void launchbrowser() throws IOException, InterruptedException {
			System.out.println("------------------------------------------------------------------------------------------");
			System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
			driver = new FirefoxDriver();
			driver.manage().window().maximize(); Thread.sleep(3000);	
			System.out.println("Browser opened ");
			System.out.println("Successfully passed!, launchbrowser()");
			SwitchShareCS.captureScreenShot(driver); Thread.sleep(3000);		
			System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
		@Test (priority = 0)
		public void Homepage() throws InterruptedException, IOException {		
			// Home page CS login
			Thread.sleep(3000);
			driver.navigate().to("https://uat-clientspace.herokuapp.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String expectedTitle = "Client Share";
	        String actualTitle = "";
	        actualTitle = driver.getTitle();
	
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed! - correct page title");
	        } else {
	            System.out.println("Test Failed - wrong page title");
	        }
	        System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(driver.getCurrentUrl());
			System.out.println("URL added on browser");
			System.out.println("------------------------------------------------------------------------------------------");
			driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
			driver.findElement(By.id("password")).sendKeys("Test1234");
			System.out.println("Email and password added to login form"); Thread.sleep(2000);		
			String Actualtext = driver.findElement(By.id("show-sent")).getText();
			Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
			driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);
			SwitchShareCS.captureScreenShot(driver);
			System.out.println("Login form submitted");
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			System.out.println("Moved to homepage CS,Homepage opened successfully"); System.out.println("Successfully passed!, Homepage()");	
			
		}
	
		@Test (priority = 1)
		public void switchShareOne() throws InterruptedException, IOException {		
			Actions share1 = new Actions(driver);
			WebElement sw1 = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
		    share1.moveToElement(sw1).build().perform(); Thread.sleep(5000); 
		    SwitchShareCS.captureScreenShot(driver); sw1.click(); Thread.sleep(3000);			
			WebElement sh2 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[8]/a")); Thread.sleep(3000); //scroll to share
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sh2); Thread.sleep(3000); 		
		    share1.moveToElement(sh2).build().perform(); Thread.sleep(4000);
		    SwitchShareCS.captureScreenShot(driver);  
			String sharename2 = sh2.getText(); 
			System.out.println("Share link clicked and share name  is: " +sharename2); 
			sh2.click(); Thread.sleep(3000);	
			SwitchShareCS.captureScreenShot(driver); Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl()); 
			System.out.println("------------------------------------------------------------------------------------------");	
		
		}
		
		@Test (priority = 2)
		public void switchShareTwo() throws InterruptedException, IOException {		
			Actions share2 = new Actions(driver);
			WebElement sw2 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
			share2.moveToElement(sw2).build().perform(); Thread.sleep(5000);
		    SwitchShareCS.captureScreenShot(driver); sw2.click(); Thread.sleep(3000);	
			WebElement sh3 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[14]/a")); Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sh3); Thread.sleep(3000); 		
		    share2.moveToElement(sh3).build().perform(); Thread.sleep(3000);
		    SwitchShareCS.captureScreenShot(driver);  
			String sharename3 = sh3.getText(); Thread.sleep(5000);
			System.out.println("Share link clicked and share name  is: " +sharename3); 
			sh3.click(); Thread.sleep(5000);
			SwitchShareCS.captureScreenShot(driver);		
			System.out.println(driver.getCurrentUrl()); 
			System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	
		@Test (priority = 3)
		public void switchShareThree() throws InterruptedException, IOException {	
			Actions share = new Actions(driver);
		    WebElement sw = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
		    share.moveToElement(sw).build().perform(); Thread.sleep(5000);
		    SwitchShareCS.captureScreenShot(driver); sw.click(); Thread.sleep(3000);		     
		    WebElement sh1 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[1]/a")); Thread.sleep(3000);
		    share.moveToElement(sh1).build().perform(); Thread.sleep(5000);	
		    SwitchShareCS.captureScreenShot(driver);
			String sharename1 = sh1.getText();	
			System.out.println("Share link clicked and share name  is: " +sharename1);	
			sh1.click(); Thread.sleep(5000);
			SwitchShareCS.captureScreenShot(driver); 
			System.out.println(driver.getCurrentUrl()); 
			System.out.println("------------------------------------------------------------------------------------------");
		
		}
		
		@Test (priority=4)
		public void switchShareFour() throws InterruptedException, IOException {
			Actions share3 = new Actions(driver);
			WebElement sw3 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
			share3.moveToElement(sw3).build().perform(); Thread.sleep(4000);
			SwitchShareCS.captureScreenShot(driver); sw3.click(); Thread.sleep(3000);	
			WebElement sh4 = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")); Thread.sleep(3000); // Airtel & Vodafone
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sh4); Thread.sleep(3000); 
			share3.moveToElement(sh4).build().perform(); Thread.sleep(5000);
			SwitchShareCS.captureScreenShot(driver); Thread.sleep(5000);
			String sharename4 = sh4.getText(); Thread.sleep(5000);
			System.out.println("Share link clicked and share name  is: " +sharename4); sh4.click(); 
			SwitchShareCS.captureScreenShot(driver);		
			System.out.println(driver.getCurrentUrl()); 
			System.out.println("Successfully passed!, SwitchShare()");
			
		}
		
		@Test (priority = 5)
		public void signout() throws InterruptedException, IOException {
			WebElement profilePic = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[7]/a"));
			Assert.assertTrue(profilePic.isDisplayed());
			profilePic.click(); Thread.sleep(4000);
			SwitchShareCS.captureScreenShot(driver);
			Actions actionLogout = new Actions(driver);
			WebElement logout = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[7]/ul/li[2]/a")); Thread.sleep(4000);
			Assert.assertTrue(logout.isDisplayed());
		    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(3000);
		    SwitchShareCS.captureScreenShot(driver); 	
			logout.click(); Thread.sleep(5000); //sign-out
			System.out.println("Signout done successfully");
			System.out.println("------------------------------------------------------------------------------------------");
		
		}

		@AfterTest
		public void close_browser() {		
		driver.close();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
			 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\switchshare\\Screenshot.jpg"));	
			 String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
			 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\switchshare\\" + filename);
			 FileUtils.copyFile(screenshot, dest);
			 
			}
}
