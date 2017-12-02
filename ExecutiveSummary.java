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
	
	public class ExecutiveSummary {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		ExecutiveSummary.captureScreenShot(driver);
	}
	
	@Test (priority = 0)
	public void homepageCS() throws InterruptedException, Exception {
		
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
		ExecutiveSummary.captureScreenShot(driver);
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
		public void switchShare() throws InterruptedException, IOException {				
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform(); sh.click();	
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); Thread.sleep(2000);	// airtel & vodafone
		ExecutiveSummary.captureScreenShot(driver);		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");	
	}
	
	@Test(priority=2)
		public void executiveSummary() throws InterruptedException, IOException {
		Actions exe = new Actions(driver);
		WebElement executivePen = driver.findElement(By.xpath("//a[contains(@id,'inc')]")); Thread.sleep(4000);
		Assert.assertTrue(executivePen.isDisplayed()); executivePen.click(); Thread.sleep(4000);
		ExecutiveSummary.captureScreenShot(driver); Thread.sleep(3000);
		WebElement executiveSummary = driver.findElement(By.xpath("//textarea[contains(@class,'summary')]")); Thread.sleep(3000);
		Assert.assertTrue(executiveSummary.isDisplayed()); executiveSummary.clear(); Thread.sleep(2000);
		ExecutiveSummary.captureScreenShot(driver); Thread.sleep(3000); 	
		executiveSummary.sendKeys("Summary Edited for testing !!"); ExecutiveSummary.captureScreenShot(driver);	Thread.sleep(3000);	 
		WebElement saveExecutive = driver.findElement(By.xpath("//button[contains(@class,'executive_btn')]"));
		Assert.assertTrue(saveExecutive.isDisplayed()); exe.moveToElement(saveExecutive).build().perform(); Thread.sleep(3000);
		saveExecutive.sendKeys(Keys.ENTER); Thread.sleep(7000);
	}
	
	
	@Test(priority=3)
	public void executiveSummaryValidation() throws InterruptedException, IOException {
		
		WebElement executivePeN = driver.findElement(By.xpath("//a[contains(@id,'inc')]")); Thread.sleep(4000);
		Assert.assertTrue(executivePeN.isDisplayed()); executivePeN.click(); Thread.sleep(4000);
		ExecutiveSummary.captureScreenShot(driver); Thread.sleep(3000);
		
		WebElement executiveSummarY = driver.findElement(By.xpath("//textarea[contains(@class,'summary')]")); Thread.sleep(4000);
		Assert.assertTrue(executiveSummarY.isDisplayed()); executiveSummarY.clear(); Thread.sleep(4000);
		ExecutiveSummary.captureScreenShot(driver);	Thread.sleep(3000);
		
		WebElement saVeExecutive = driver.findElement(By.xpath("//button[contains(@class,'executive_btn')]"));
		Assert.assertTrue(saVeExecutive.isDisplayed()); saVeExecutive.click(); Thread.sleep(4000);
		ExecutiveSummary.captureScreenShot(driver);	Thread.sleep(3000);
		
		WebElement mandateSummary = driver.findElement(By.xpath("//label[contains(@id,'space')]"));
		Assert.assertTrue(mandateSummary.isDisplayed()); System.out.println("Mandatory summary message is: " +mandateSummary.getText());
		ExecutiveSummary.captureScreenShot(driver);	Thread.sleep(3000);
		
		WebElement fileuPload = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/span/span[1]")); Thread.sleep(4000);
		Assert.assertTrue(fileuPload.isDisplayed()); Thread.sleep(3000);
		System.out.println("Link text is: " +fileuPload.getText()); Thread.sleep(3000);
		fileuPload.click(); String alertMessage= driver.switchTo().alert().getText();
	    System.out.println(alertMessage); Thread.sleep(5000); driver.switchTo().alert().accept();
	    
	    WebElement cancelSummary = driver.findElement(By.xpath("//button[contains(@class,'cancel')]")); Thread.sleep(4000);
		Assert.assertTrue(cancelSummary.isDisplayed()); 
		ExecutiveSummary.captureScreenShot(driver);	Thread.sleep(3000); cancelSummary.click();
	}

	@Test(priority=4)
	public void executiveSummaryFilesDelete() throws Exception {
		Actions delete = new Actions(driver);
		WebElement executivePEN = driver.findElement(By.xpath("//a[contains(@id,'inc')]")); Thread.sleep(4000);
		Assert.assertTrue(executivePEN.isDisplayed()); executivePEN.click(); Thread.sleep(4000);	
		ExecutiveSummary.captureScreenShot(driver); Thread.sleep(4000);	
		
		WebElement deleteFiles = driver.findElement(By.xpath("//img[contains(@class,'summary_files')]"));
		Assert.assertTrue(deleteFiles.isDisplayed()); deleteFiles.click(); Thread.sleep(3000);
		
		WebElement saveExecUtiVe = driver.findElement(By.xpath("//button[contains(@class,'executive_btn')]"));
		delete.moveToElement(saveExecUtiVe).build().perform(); Thread.sleep(3000);
		Assert.assertTrue(saveExecUtiVe.isDisplayed()); saveExecUtiVe.sendKeys(Keys.ENTER); Thread.sleep(9000);
	}
	
	
	@Test(priority=5)
	public void executiveSummaryFilesUpload() throws Exception {
		Actions exeUpload = new Actions(driver);
		WebElement executivePen = driver.findElement(By.xpath("//a[contains(@id,'inc')]")); Thread.sleep(4000);
		Assert.assertTrue(executivePen.isDisplayed()); executivePen.click(); Thread.sleep(4000);	
		ExecutiveSummary.captureScreenShot(driver); Thread.sleep(4000);	
		
		WebElement fileupload = driver.findElement(By.xpath("//*[@id='content']/div[3]/span/span[1]"));
		Assert.assertTrue(fileupload.isDisplayed()); System.out.println(fileupload.getText());
		fileupload.click(); Thread.sleep(3000); 
		Runtime.getRuntime().exec("D:\\AutoIt\\executivefileupload.exe"); Thread.sleep(16000);
		WebElement saveExecUtive = driver.findElement(By.xpath("//button[contains(@class,'executive_btn')]"));
		Assert.assertTrue(saveExecUtive.isDisplayed()); exeUpload.moveToElement(saveExecUtive).build().perform(); Thread.sleep(3000);
		saveExecUtive.sendKeys(Keys.ENTER); Thread.sleep(9000);
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\executiveSummary\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
}
