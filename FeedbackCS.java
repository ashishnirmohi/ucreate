
		package adminhomepage;
		import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
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

		public class FeedbackCS {
		public WebDriver driver;
		 
		@BeforeTest
		public void launchbrowser() throws IOException, InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		System.out.println("Browser opened Successfully passed!, launchbrowser()");
		
		}
	
		@Test (priority = 0)
		public void Homepage() throws InterruptedException, IOException {
		
		// Home page CS login
		Thread.sleep(5000);	
		System.out.println("------------------------------------------------------------------------------------------");
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
		System.out.println("URL added on browser");
		driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(2000);		
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		FeedbackCS.captureScreenShot(driver);
		
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);
		System.out.println("Login form submitted, moved to homepage CS, Homepage opened successfully");

		}
	
		@Test (priority = 1)
		public void SwitchShare() throws InterruptedException, IOException {				
		// Switch share functionality tests	
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform();	
	    FeedbackCS.captureScreenShot(driver);
	    
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")).click(); 
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[32]/a")).click(); 
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")).click();		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); //Airtel & vodafone
		System.out.println("Successfully moved to desired share, passed: SwitchShare()");
		FeedbackCS.captureScreenShot(driver); Thread.sleep(5000);		
		System.out.println("-----------------------------------------------------");
	
		}
	
		@Test (priority = 2)
		public void Feedback()throws InterruptedException, IOException {
			
		// Feedback page testing 
		Actions action = new Actions(driver);
	    WebElement fb = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[3]/a"));
	    action.moveToElement(fb).build().perform();	 Thread.sleep(5000);  
	    System.out.println("Hover link text is: " +fb.getText());
	    System.out.println("link is displayed: "+fb.isDisplayed()); Thread.sleep(3000); 
	    System.out.println("link is enabled: " +fb.isEnabled());
	    System.out.println("link is selected: " +fb.isSelected());
		fb.click(); Thread.sleep(3000); System.out.println("Feedback page opened"); 
		FeedbackCS.captureScreenShot(driver);
		System.out.println("Successfully passed!, hoverQuestionFeedback()");

		}
	
		@Test(priority=3)
		public void hoverQuestionFeedback() throws IOException, InterruptedException {
			
		// Hover on ? feedback
		WebElement questions= driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]/h1/a/i")); Thread.sleep(12000);
		Actions hQ = new Actions(driver);
		hQ.moveToElement(questions).build().perform(); Thread.sleep(5000);
		FeedbackCS.captureScreenShot(driver); Thread.sleep(3000);
		System.out.println("Net Promoter Score 50 ? - working");    
		System.out.println("Successfully passed!, hoverQuestionFeedback()");
				
		}
		@Ignore
		//@Test(priority=4)
		public void scrollFeedbackComments() throws InterruptedException {
			
		// scroll history quarters feedbacks 
		Actions action2 = new Actions(driver);
		WebElement fd1 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd1); Thread.sleep(3000); 		
		action2.moveToElement(fd1).build().perform(); Thread.sleep(4000);	

		WebElement fd2 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[4]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd2); Thread.sleep(3000); 		
		WebElement fd3 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[6]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd3); Thread.sleep(3000); 
		WebElement fd4 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[10]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd4); Thread.sleep(3000); 
			
		WebElement fb5 = driver.findElement(By.xpath("//*[@id=\\\"feedback\\\"]/div[2]/div[1]/form/div/div[6]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fb5); Thread.sleep(3000); 	
		
		WebElement fb6 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[3]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fb6); Thread.sleep(3000);		
		System.out.println("Successfully passed!, scrollFeedbackComments()");
		
		}
		
		@Ignore
		//@Test(priority=5)
		public void hoverFeedbackQuarters() throws InterruptedException, IOException {
			
		// Hover Feedback quarters 
		Actions action1 = new Actions(driver);
		WebElement aj17 = driver.findElement(By.xpath("html/body/section/div[2]/div/div[1]/div/ul/li[2]/a")); Thread.sleep(3000);
		action1.moveToElement(aj17).build().perform(); Thread.sleep(4000);
		aj17.click(); Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='feedback']/div[2]/div[1]/form/div/div[1]/h4/a")).click(); // download feedback
		FeedbackCS.captureScreenShot(driver);	
		}
		
		@Test (priority = 6)
		public void Signout() throws InterruptedException, IOException {
		driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[7]/a")).click(); Thread.sleep(2000);
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[7]/ul/li[2]/a")); Thread.sleep(4000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(3000);
	    FeedbackCS.captureScreenShot(driver);
		logout.click(); Thread.sleep(5000); //sign-out
		System.out.println("Signout done successfully");
		
		}
	
		public static void captureScreenShot(WebDriver driver) throws IOException{
		java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\feedback\\Screenshot.jpg"));	
		String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\feedback\\" + filename);
		FileUtils.copyFile(screenshot, dest);
		 
		}

		@AfterTest
		public void close_browser() {		
		driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
		}


}
