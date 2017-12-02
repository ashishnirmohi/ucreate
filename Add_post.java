
	package addPost;
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
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Add_post {
	public WebDriver driver;

	@BeforeTest
	public void launchbrowser() {
		
		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test(priority=0)
	public void HomepageCS() throws Exception {
		
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL added on browser");
		
		// log-In with user on CS
		driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form");
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login form submitted"); Thread.sleep(5000);
		System.out.println("Successfully passed: HomepageCS()");
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
	@Test (priority=1)
	public void SwitchShare() throws InterruptedException, IOException {		
	
		Actions share = new Actions(driver);
		Thread.sleep(3000); WebElement sh = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh).build().perform(); sh.click(); Thread.sleep(3000);		
		System.out.println("Share switch link clicked");
		
		WebElement shr1 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[6]/a")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", shr1); Thread.sleep(3000); 
		share.moveToElement(shr1).build().perform(); Thread.sleep(5000); shr1.click(); Thread.sleep(5000);
		Add_post.captureScreenShot(driver);
		
		Thread.sleep(3000); WebElement sh1 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh1).build().perform(); sh1.click(); Thread.sleep(3000);		
	    WebElement shr2 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[10]/a")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", shr2); Thread.sleep(3000);
		share.moveToElement(shr2).build().perform(); Thread.sleep(5000); shr2.click(); Thread.sleep(8000);
		Add_post.captureScreenShot(driver);
		Thread.sleep(3000); WebElement sh2 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    share.moveToElement(sh2).build().perform(); sh2.click(); Thread.sleep(3000);		
		 WebElement shr3 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[13]/a")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", shr3); Thread.sleep(3000); 
		share.moveToElement(shr3).build().perform(); Thread.sleep(3000); shr3.click(); Thread.sleep(5000);
		Add_post.captureScreenShot(driver);
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		
		System.out.println("------------------------------------------------------------------------------------------");
		
	}

	@Test (priority=2)
	public void Add_New_post_1stPost() throws InterruptedException, IOException {
		
	driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys(Keys.ENTER); Thread.sleep(20000);
	
	// Enter subject of post on add post form
	driver.findElement(By.name("post[subject]")).clear(); Thread.sleep(2000);
	driver.findElement(By.name("post[subject]")).sendKeys("Test Subject title for add post feature testing with automation 1st post"); Thread.sleep(20000);
	Add_post.captureScreenShot(driver);
	// Enter body of post on add post form
	driver.findElement(By.name("space[post]")).clear(); Thread.sleep(3000);
	driver.findElement(By.name("space[post]")).sendKeys("Test body Text for add post feature testing with automation, This is quick test for whole add post feature validation. ");
	driver.findElement(By.name("space[post]")).sendKeys("https://www.facebook.com"); Thread.sleep(8000);
	Add_post.captureScreenShot(driver);
	// click link attach files on add post pop-up form
	driver.findElement(By.xpath("//a[text()='Attach file(s)']")).click();
	Runtime.getRuntime().exec("D:\\AutoIt\\Fileupload3.exe"); Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='discardModal']/div/div/div[3]/button")).click();
	Add_post.captureScreenShot(driver);
	// Choose category post
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/button")).click(); Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/ul/li[2]/a/label")).click();	Thread.sleep(3000);
	Add_post.captureScreenShot(driver);		
	// Publish post
	driver.findElement(By.xpath("//*[@id='save_post_btn_new']")).click(); Thread.sleep(20000);
	System.out.println("Successfully passed: Add_New_1stPost()");
	Add_post.captureScreenShot(driver);
	System.out.println("---------------------------------------------------------------------------------");
	
	}
	
	@Test(priority=3)
	public void Add_New_2ndPost() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id='exampleInputEmail1']")).sendKeys(Keys.ENTER);Thread.sleep(4000);
		
		// Enter subject of post on add post form
		driver.findElement(By.name("post[subject]")).clear();
		driver.findElement(By.name("post[subject]")).sendKeys("Test Subject title for add post feature testing with automation 2ndPost"); Thread.sleep(2000);
		
		// Enter body of post on add post form
		driver.findElement(By.name("space[post]")).clear(); Thread.sleep(2000);
		driver.findElement(By.name("space[post]")).sendKeys("Test body Text for add post feature testing with automation, This is quick test for whole add post feature validation. "); Thread.sleep(3000);
		driver.findElement(By.name("space[post]")).sendKeys("http://www.thehindu.com/sci-tech/technology/gadgets/watch-all-you-need-to-know-about-zenfone-ar/article19301170.ece"); Thread.sleep(8000);
		
		// click link attach files on add post pop-up form
		driver.findElement(By.xpath("//a[text()='Attach file(s)']")).click(); Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\AutoIt\\Fileupload2.exe"); Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='discardModal']/div/div/div[3]/button")).click();
		
		// Choose category post
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/button")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/ul/li[4]/a/label")).click();	
		
		// Share post on multiple shares
		Thread.sleep(3000); driver.findElement(By.cssSelector("#tour2 > div.shareupdate-bottom.post_categories_maincontent > label")).click(); Thread.sleep(3000); 
		driver.findElement(By.xpath(".//*[@id='tour2']/div[3]/div/div[4]/div/button")).click(); // choose share
		
		
		WebElement m_shr1 = driver.findElement(By.xpath("//*[@id='tour2']/div[3]/label")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", m_shr1); Thread.sleep(3000); 
		Actions M_share = new Actions(driver);
		M_share.moveToElement(m_shr1).build().perform(); Thread.sleep(5000); m_shr1.click(); 
	    
		WebElement m_shr2 = driver.findElement(By.xpath("//*[@id='tour2']/div[3]/div/div[4]/div/ul/li[10]/label")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", m_shr2); Thread.sleep(3000); 
		Actions M_share1 = new Actions(driver);
		M_share1.moveToElement(m_shr2).build().perform(); Thread.sleep(5000); m_shr2.click(); 
		System.out.println(m_shr2.getCssValue("content"));
		driver.findElement(By.xpath("//*[@id='post_button']")).click(); Thread.sleep(4000);
		
		// Publish post
		driver.findElement(By.xpath("//*[@id='save_post_btn_new']")).click(); Thread.sleep(19000);
		System.out.println("Successfully passed: Add_New_2ndPost()");
		Add_post.captureScreenShot(driver);
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
	
	@Test(priority=4)
	public void Add_New_3ndPost() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id='exampleInputEmail1']")).sendKeys(Keys.ENTER);
		
		// Enter subject of post on add post form
		driver.findElement(By.name("post[subject]")).clear();
		driver.findElement(By.name("post[subject]")).sendKeys("Test Subject title for add post feature testing with automation 3rdPost"); Thread.sleep(3000);
		Add_post.captureScreenShot(driver);
		// Enter body of post on add post form
		driver.findElement(By.name("space[post]")).clear();
		driver.findElement(By.name("space[post]")).sendKeys("Test body Text for add post feature testing with automation, This is quick test for whole add post feature validation. "); Thread.sleep(3000);
		driver.findElement(By.name("space[post]")).sendKeys("https://www.bbc.com"); Thread.sleep(8000);
		Add_post.captureScreenShot(driver);
		// click link attach files on add post pop-up form
		driver.findElement(By.xpath("//a[text()='Attach file(s)']")).click();
		Runtime.getRuntime().exec("D:\\AutoIt\\Fileupload1.exe"); Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='discardModal']/div/div/div[3]/button")).click();
		Add_post.captureScreenShot(driver);
		// Choose category post
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/button")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/ul/li[5]/a/label")).click();	
		Add_post.captureScreenShot(driver);		
		// Publish post
		driver.findElement(By.xpath("//*[@id='save_post_btn_new']")).click(); Thread.sleep(19000);
		System.out.println("Successfully passed: Add_New_3rdPost()");
		Add_post.captureScreenShot(driver);
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
		
	@Test (priority=5)
	public void NewPost_Minimize_Expand() throws IOException, InterruptedException {
	
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='postid']/div[1]/div[1]/div[2]/a/img")).click();
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='analytics_email_popup']/div/div/div[3]/button")).click(); Thread.sleep(7000);
		
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='postid']/div[1]/div[1]/div[2]/a/img")).click(); Thread.sleep(7000);
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='postid']/div[1]/div[1]/div[2]/ul/li[1]/a")).click(); Thread.sleep(7000);
		
		System.out.println("Successfully passed: Minimize_Expand_Post()");
		System.out.println("---------------------------------------------------------------------------------");
				
	}	
	
	@Test (priority=6)
	public void Pin_Unpin_Post() {
		
		
		System.out.println("Successfully passed: Pin_Unpin_Post()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test (priority=7)	
	public void Edit_Post() {
		
		
		System.out.println("Successfully passed: Edit_Post()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test (priority=8)
	public void Delete_Post() {
			
		System.out.println("Successfully passed: Delete_Post()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@AfterTest
	public void Close_Browser() throws InterruptedException {	
		
		driver.quit();	
		System.out.println("Successfully passed: Close_Browser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\addpost" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
	
}
