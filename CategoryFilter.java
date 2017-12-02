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
	
	public class CategoryFilter {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		CategoryFilter.captureScreenShot(driver);
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
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(2000);			
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);		
		CategoryFilter.captureScreenShot(driver);
		
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
		CategoryFilter.captureScreenShot(driver);		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");	
	}
	
	@Test(priority=2)
	public void categoryFilterSample() throws Exception {
		Actions cateGory = new Actions(driver);
		WebElement categoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit')]")); Thread.sleep(4000);
		Assert.assertTrue(categoryPen.isDisplayed()); categoryPen.click(); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(3000);	
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/div/button[2]"));
		Assert.assertTrue(cancel.isDisplayed());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cancel); Thread.sleep(3000); 
		cateGory.moveToElement(cancel).build().perform(); Thread.sleep(4000); cancel.click();	
	}
	
	
	@Test(priority=3)
	public void filterPostsByCategory() throws Exception {
		Actions categorY = new Actions(driver);
		WebElement cat = driver.findElement(By.xpath("//*[@id=\"tour4\"]/ul/li[4]/a/span")); Thread.sleep(4000);
		categorY.moveToElement(cat).build().perform(); Thread.sleep(4000); cat.click(); Thread.sleep(7000);
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tour4\"]/ul/li[3]/a/img"));
		categorY.moveToElement(close).build().perform(); Thread.sleep(2000);
		Assert.assertTrue(close.isDisplayed()); close.click(); Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void editCategoryAdded() throws Exception {
		Actions edTCat = new Actions(driver);
		WebElement caTegoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit')]")); Thread.sleep(4000);
		Assert.assertTrue(caTegoryPen.isDisplayed()); caTegoryPen.click(); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(3000);	
		WebElement editCat = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/ul/li[17]/input"));
		Assert.assertTrue(editCat.isDisplayed()); Thread.sleep(3000); editCat.clear(); Thread.sleep(3000); editCat.sendKeys("categoryEdited");
		WebElement cAncel = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/div/button[2]"));
		Assert.assertTrue(cAncel.isDisplayed());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cAncel); Thread.sleep(3000); 
		edTCat.moveToElement(cAncel).build().perform(); Thread.sleep(4000); cAncel.click();	
	}
	
	@Test(priority=5)
	public void addCategoryNew() throws Exception {
		Actions canceL = new Actions(driver);
		WebElement caTegoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit')]")); Thread.sleep(4000);
		Assert.assertTrue(caTegoryPen.isDisplayed()); caTegoryPen.click(); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(3000);	
		WebElement addcat = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/ul/li[17]/input"));
		Assert.assertTrue(addcat.isDisplayed()); addcat.click();addcat.sendKeys("New");
		WebElement caNcel = driver.findElement(By.xpath("//*[@id=\\\"edit_post_category_form\\\"]/div/div/button[2]"));
		Assert.assertTrue(caTegoryPen.isDisplayed()); Thread.sleep(3000);
		canceL.moveToElement(caNcel).build().perform(); caNcel.click(); Thread.sleep(3000);
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\categoryFilter\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
}
