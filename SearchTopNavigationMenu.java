	package adminhomepage;
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
	import java.io.File;
	import java.io.IOException;

	public class SearchTopNavigationMenu {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		SearchTopNavigationMenu.captureScreenShot(driver);
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
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(5000);	
		SearchTopNavigationMenu.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
		}
	
	@Test (priority=1)
	public void switchShare() throws InterruptedException, IOException {		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); sh.click();	
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); Thread.sleep(5000);	// airtel & vodafone
		SearchTopNavigationMenu.captureScreenShot(driver);		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");		
		}
	
	@Test (priority=2)
	public void searchMainNavigation() throws Exception {
		Actions search = new Actions(driver);
		WebElement seachicon = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/a/img"));
		Assert.assertTrue(seachicon.isDisplayed()); Thread.sleep(3000);	
		search.moveToElement(seachicon).build().perform(); Thread.sleep(3000);
		seachicon.click(); Thread.sleep(3000); SearchTopNavigationMenu.captureScreenShot(driver);	
		WebElement close = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/div[1]/span/img"));
		Assert.assertTrue(close.isDisplayed()); Thread.sleep(3000);	
		search.moveToElement(close).build().perform(); Thread.sleep(3000);
		close.click(); Thread.sleep(3000);	
	}
	
	@Test (priority=3)
	public void searchMemberName() throws Exception {
		Actions seArch = new Actions(driver);
		WebElement sEachicon = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/a/img"));
		Assert.assertTrue(sEachicon.isDisplayed()); Thread.sleep(3000);	
		seArch.moveToElement(sEachicon).build().perform(); Thread.sleep(3000);
		sEachicon.click(); Thread.sleep(3000);		
		WebElement searchText = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
		Assert.assertTrue(searchText.isDisplayed()); Thread.sleep(3000); SearchTopNavigationMenu.captureScreenShot(driver);	
		searchText.click(); Thread.sleep(3000); searchText.sendKeys("ashish"); searchText.sendKeys(Keys.ENTER);
		SearchTopNavigationMenu.captureScreenShot(driver);	
		WebElement clOse = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/div[1]/span/img"));
		Assert.assertTrue(clOse.isDisplayed()); Thread.sleep(3000);	
		seArch.moveToElement(clOse).build().perform(); Thread.sleep(3000);
		clOse.click(); Thread.sleep(3000);	
		
	}
	
	@Test (priority=4)
	public void searchFileName() throws Exception {	
		Actions Search = new Actions(driver);
		WebElement sEachicon = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/a/img"));
		Assert.assertTrue(sEachicon.isDisplayed()); Thread.sleep(3000);	
		Search.moveToElement(sEachicon).build().perform(); Thread.sleep(3000);
		sEachicon.click(); Thread.sleep(3000);	SearchTopNavigationMenu.captureScreenShot(driver);		
		WebElement searchText = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
		Assert.assertTrue(searchText.isDisplayed()); Thread.sleep(3000);	
		searchText.click(); Thread.sleep(3000); searchText.sendKeys("annual_report_2009"); searchText.sendKeys(Keys.ENTER);
		SearchTopNavigationMenu.captureScreenShot(driver);	
		WebElement Close = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/div[1]/span/img"));
		Assert.assertTrue(Close.isDisplayed()); Thread.sleep(3000);	
		Search.moveToElement(Close).build().perform(); Thread.sleep(3000);
		Close.click(); Thread.sleep(3000);	
		}
		 
	@Test (priority=5)
	public void searchPostBodytext() throws Exception{
		Actions SearCh = new Actions(driver);
		WebElement seachIcon = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/a/img"));
		Assert.assertTrue(seachIcon.isDisplayed()); Thread.sleep(3000);	
		SearCh.moveToElement(seachIcon).build().perform(); Thread.sleep(3000);
		seachIcon.click(); Thread.sleep(3000);		
		WebElement searchText = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
		Assert.assertTrue(searchText.isDisplayed()); Thread.sleep(3000);	
		searchText.click(); Thread.sleep(3000); searchText.sendKeys("Querty"); searchText.sendKeys(Keys.ENTER);
		SearchTopNavigationMenu.captureScreenShot(driver);	
		WebElement Close = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/div[1]/span/img"));
		Assert.assertTrue(Close.isDisplayed()); Thread.sleep(3000);	
		SearCh.moveToElement(Close).build().perform(); Thread.sleep(3000);
		Close.click(); Thread.sleep(3000);	
		}
	
	@Test (priority=6)
	public void searchPostSubject() throws Exception {
		Actions SearcH = new Actions(driver);
		WebElement seachIcoN = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/a/img"));
		Assert.assertTrue(seachIcoN.isDisplayed()); Thread.sleep(3000);	
		SearcH.moveToElement(seachIcoN).build().perform(); Thread.sleep(3000);
		seachIcoN.click(); Thread.sleep(3000);		
		WebElement searchText = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
		Assert.assertTrue(searchText.isDisplayed()); Thread.sleep(3000);	
		searchText.click(); Thread.sleep(3000); searchText.sendKeys("Lorem"); searchText.sendKeys(Keys.ENTER);
		SearchTopNavigationMenu.captureScreenShot(driver);	
		WebElement Close = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[4]/div[1]/span/img"));
		Assert.assertTrue(Close.isDisplayed()); Thread.sleep(3000);	
		SearcH.moveToElement(Close).build().perform(); Thread.sleep(3000);
		Close.click(); Thread.sleep(3000);
		}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
		
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\searchMain\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
}
