	
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

		public class NotificationsCS {
		public WebDriver driver;
		 
		@BeforeTest
		public void launchBrowser() {
			
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Successfully passed!, launchbrowser()");
		System.out.println("------------------------------------------------------------------------------------------");
		}
	
		@Test (priority = 0)
		public void homePage() throws InterruptedException {
		
		// Home page CS login
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
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		Thread.sleep(2000);	
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); 
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		System.out.println("Moved to homepage CS,Homepage opened successfully");
		System.out.println("------------------------------------------------------------------------------------------");
		}
	
		@Test (priority = 1)
		public void switchShare() throws InterruptedException, Exception {		
		// Switch share functionality tests		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(3000); sh.click(); 
		System.out.println("Share switch link clicked");
		
		Actions share1 = new Actions(driver);
		WebElement dallpp = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dallpp);  // scroll here
		share1.moveToElement(dallpp).build().perform(); Thread.sleep(3000); 
		dallpp.click(); Thread.sleep(3000);
		NotificationsCS.captureScreenShot(driver);
		
		Actions share2 = new Actions(driver);
		WebElement sh1 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
		share2.moveToElement(sh1).build().perform(); Thread.sleep(3000); sh1.click(); Thread.sleep(3000); 
		WebElement kg = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[10]/a")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", kg); // scroll here
		share2.moveToElement(kg).build().perform(); Thread.sleep(4000); 
		kg.click(); Thread.sleep(3000);
		System.out.println("KG Share opened, to test notifications");
		
		}
	
		@Test (priority = 2)
		public void notificationCS() throws InterruptedException, Exception {
			
		Actions bell = new Actions(driver);
		WebElement bl = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[4]/a")); 
		bell.moveToElement(bl).build().perform(); Thread.sleep(3000); 
		bl.click(); Thread.sleep(3000); 
		
		Actions Notification = new Actions(driver);
		WebElement Noti = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[4]/ul/li[2]/a")); Thread.sleep(3000); 
		
		Notification.moveToElement(Noti).build().perform(); Thread.sleep(3000); 
		Noti.click(); Thread.sleep(13000);
		System.out.println("Notification single page opened");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}

		@Test (priority = 3)
		public void signOut() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[6]/a")).click(); 
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[6]/ul/li[2]/a")); Thread.sleep(12000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(3000);
		logout.click();  //sign-out
		System.out.println("Signout done successfully");
		System.out.println("------------------------------------------------------------------------------------------");
		}	
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
		java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
		String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\notification\\" + filename);
		FileUtils.copyFile(screenshot, dest);
		 
		}

		@AfterTest
		public void closeBrowser() throws Exception {	
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
		}
		}
