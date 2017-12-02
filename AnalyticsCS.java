
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

	public class AnalyticsCS {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		AnalyticsCS.captureScreenShot(driver);
	}
	
	@Test (priority = 0)
	public void HomepageCS() throws InterruptedException, Exception {
		
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
		System.out.println("URL added on browser");
		driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in"); Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(2000);			
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);		
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
		public void SwitchShare() throws InterruptedException, IOException {		
		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform();
		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")).click(); Thread.sleep(2000);		
		System.out.println("Share switch link clicked");
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[32]/a")).click(); Thread.sleep(2000); 
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")).click();  Thread.sleep(2000);		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); Thread.sleep(2000);	
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=2)
		public void Analytics_landing_Page() throws InterruptedException, IOException{
			
		Actions analytic = new Actions(driver);
	    WebElement aly = driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")); Thread.sleep(3000);
	    analytic.moveToElement(aly).build().perform();
		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")).click(); Thread.sleep(8000);//analytics
		System.out.println("Analytic page opened"); AnalyticsCS.captureScreenShot(driver);
		System.out.println(driver.getCurrentUrl());
		
		WebElement csi = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csi); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement post = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", post);Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver); 
		
		WebElement postint = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postint); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
	    WebElement community = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", community); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement nps = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nps); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement community1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", community1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postint1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postint1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement post1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", post1);Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver); 
		
		WebElement csi1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csi1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("");    
		System.out.println("Analytic page scrolled, successfully passed!: Analytics_landing_Page()");
		System.out.println("------------------------------------------------------------------------------------------");
	}	

	@Test(priority=3)
	public void Analytics_Filter_MonthYear() throws InterruptedException, IOException {
		
		Actions analytic = new Actions(driver);
	    WebElement aly = driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")); Thread.sleep(3000);
	    analytic.moveToElement(aly).build().perform();
		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")).click(); Thread.sleep(4000); //analytics	
		
		driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[1]/div[2]/button")).click(); // Click month drop-down
		driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[1]/div[2]/div/ul/li[2]/a")).click(); Thread.sleep(20000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement csI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csI); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement posT = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", posT); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postI);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement communitY = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", communitY); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement npS = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", npS);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement communitY1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", communitY1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postI1);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement posT1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", posT1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement csI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csI1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("Analytic page scrolled after applying filter months, successfully passed!: Analytics_Filter_MonthYear()");		
		
	}
	

	@Test(priority=4)
	public void Analytics_SelectAllShare_Graphs() throws InterruptedException, IOException {
		
		Actions analytic = new Actions(driver);
	    WebElement aly = driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")); Thread.sleep(3000);
	    analytic.moveToElement(aly).build().perform();	AnalyticsCS.captureScreenShot(driver);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")).click(); Thread.sleep(4000);//analytics
		
		driver.findElement(By.xpath("html/body/section/form/div/div[1]/div/ul/li[2]/div/div[1]/h4/label/span")).click();Thread.sleep(28000);
		
		WebElement AcsI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcsI); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AposT = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AposT); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement ApostI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ApostI);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcommunitY = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcommunitY); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AnpS = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AnpS);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcommunitY1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcommunitY1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement ApostI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ApostI1);  Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AposT1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AposT1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcsI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcsI1); Thread.sleep(3000);
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("successfully passed!: Analytics_SelectAllShare_Graphs()");
	}

	
	@Test(priority=5)
	public void Analytics_DownloadXSLX() throws InterruptedException, IOException {
		
		Actions analytic = new Actions(driver);
	    WebElement aly = driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")); Thread.sleep(3000);
	    analytic.moveToElement(aly).build().perform();
	    AnalyticsCS.captureScreenShot(driver);
	    
		driver.findElement(By.xpath("html/body/nav/div/div[1]/a[1]")).click(); Thread.sleep(4000); //analytics	
		driver.findElement(By.xpath(".//*[@id='analytics-download-dropdown']")).click();
		driver.findElement(By.xpath(".//*[@id='analytics']/div[1]/div[3]/ul/li[2]/a")).click();
		AnalyticsCS.captureScreenShot(driver);
		driver.findElement(By.xpath(".//*[@id='analytics_email_popup']/div/div/div[3]/button")).click();
		
		System.out.println("passed: Analytics_DownloadXSLX()");
		AnalyticsCS.captureScreenShot(driver);
	}
	
	/*
	@Test(priority=6)
	public void Analytics_DownloadPDF() {
		
		// System.out.println("passed: Analytics_DownloadPDF()");
	}
	*/
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\analytics\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}

}
