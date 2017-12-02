	package adminhomepage;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
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
	
	public class TopPosts {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		TopPosts.captureScreenShot(driver);
	}
	
	@Test (priority = 0)
	public void homepageCS() throws InterruptedException, Exception {
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
		WebElement submit = driver.findElement(By.id("show-sent"));
		Actualtext= submit.getText();
		Assert.assertEquals(Actualtext, "SIGN IN", " assert failed");
		submit.sendKeys(Keys.ENTER);		
		TopPosts.captureScreenShot(driver);
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		TopPosts.captureScreenShot(driver);
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
		public void switchShare() throws InterruptedException, IOException {				
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform(); sh.click();	Thread.sleep(3000);
	    TopPosts.captureScreenShot(driver);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); Thread.sleep(2000);	// airtel & vodafone
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");	
	}
	
	@Test(priority=2)
	public void topPostsFilterSeller() throws Exception {
		Actions tpSeller = new Actions(driver);
		WebElement seller = driver.findElement(By.xpath("//*[@id=\"right-content\"]/div/div[1]/div[1]/ul/li[2]"));
		Assert.assertTrue(seller.isDisplayed()); Thread.sleep(3000);	
		System.out.println("Seller company name is: "+seller.getText());
		tpSeller.moveToElement(seller).build().perform(); Thread.sleep(3000);
		seller.click(); TopPosts.captureScreenShot(driver);  Thread.sleep(3000);		
		
	}
	
	@Test(priority=3)
	public void topPostsFilterBuyer() throws Exception {
		Actions tpBuyer = new Actions(driver);
		WebElement buyer = driver.findElement(By.xpath("//*[@id=\"right-content\"]/div/div[1]/div[1]/ul/li[3]"));
		Assert.assertTrue(buyer.isDisplayed()); Thread.sleep(3000);	
		tpBuyer.moveToElement(buyer).build().perform(); Thread.sleep(3000);
		System.out.println("Buyer company name is: "+buyer.getText());
		buyer.click(); TopPosts.captureScreenShot(driver); Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void topPostsFilterAll() throws Exception {
		Actions tpAll = new Actions(driver);
		WebElement all = driver.findElement(By.xpath("//*[@id=\"right-content\"]/div/div[1]/div[1]/ul/li[1]"));
		Assert.assertTrue(all.isDisplayed()); Thread.sleep(3000);	
		tpAll.moveToElement(all).build().perform(); Thread.sleep(3000);
		all.click(); TopPosts.captureScreenShot(driver); Thread.sleep(3000);
	}
	
	
	@Test(priority=5)
	public void topPostsFilterMonthNP() throws Exception {
		Actions month = new Actions(driver);
		WebElement lastMonth = driver.findElement(By.xpath("//span[contains(@class,'last')]"));
		Assert.assertTrue(lastMonth.isDisplayed()); Thread.sleep(3000);	
		month.moveToElement(lastMonth).build().perform(); Thread.sleep(3000);
		lastMonth.click(); TopPosts.captureScreenShot(driver); 		
		System.out.println("Previous month is: "+lastMonth.getText());Thread.sleep(3000);	
		WebElement nextMonth = driver.findElement(By.xpath("//span[contains(@id,'next')]"));
		Assert.assertTrue(nextMonth.isDisplayed()); Thread.sleep(3000);	
		month.moveToElement(nextMonth).build().perform(); Thread.sleep(3000);
		nextMonth.click(); TopPosts.captureScreenShot(driver); Thread.sleep(3000);	
		System.out.println("Next month is: "+nextMonth.getText()); Thread.sleep(3000);
	} 
	
	@Test(priority=6)
	public void topPostsSinglePage() throws Exception{
	
		WebElement toppost = driver.findElement(By.xpath("//*[@id=\"right-content\"]/div/div[1]/h4")); Thread.sleep(3000);	
		Assert.assertTrue(toppost.isDisplayed()); Thread.sleep(3000);	
		System.out.println("We are testing: " +toppost.getText()); 	
		TopPosts.captureScreenShot(driver);
		WebElement tpnov = driver.findElement(By.xpath("//p[contains(@class,'invite')]"));
		Assert.assertTrue(tpnov.isDisplayed()); Thread.sleep(3000);	
		System.out.println("Top post subject is: " +tpnov.getText()); 
		toppost.click(); Thread.sleep(3000); TopPosts.captureScreenShot(driver);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\topPosts\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
}
