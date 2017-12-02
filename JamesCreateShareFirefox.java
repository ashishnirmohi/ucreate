	
	package shareregister;
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
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class JamesCreateShareFirefox {
	public WebDriver driver;

	@BeforeTest
	public void launchbrowser() {
		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
		@Test(priority=1)
		public void LoginJamesOTP() throws InterruptedException, Exception {		
		driver.get("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("3391bc@myclientshare.com");
		driver.findElement(By.id("password")).sendKeys("CS@17@testx");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		driver.findElement(By.id("show-sent")).click();	Thread.sleep(50000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		System.out.println("OTP send to your registed email, write that on loging for to continue.");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test(priority=2)
	public void createNewNormalShare() throws InterruptedException, Exception {	
		driver.findElement(By.xpath("//*[@id='show-sent']")).click(); 
		
		// Add seller company
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='addclientshare']")).click(); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.id("seller")).sendKeys("Vodafone"); Thread.sleep(8000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[1]/div/div[1]/div[1]/a[2]/div")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[1]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Seller added");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		// Add buyer company
		driver.findElement(By.xpath("//input[@name='buyer[buyer_name]']")).sendKeys("Airtel India"); Thread.sleep(8000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[2]/div/div[1]/div[2]/a[1]/div")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[2]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Buyer added");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add ShareName
		driver.findElement(By.xpath("//input[@id='client_share_name']")).sendKeys("Normalshare0005"); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[3]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Share name added");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add email address
		driver.findElement(By.id("admin_email")).sendKeys("nirmohi.qa@gmail.com"); Thread.sleep(2000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[4]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Email admin added");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add first name 
		driver.findElement(By.xpath("//input[@id='admin_first_name']")).sendKeys("Ashish"); Thread.sleep(2000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[5]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(2000);
		System.out.println("First name admin added");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add last name
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='admin_last_name']")).sendKeys("Nirmohi"); Thread.sleep(2000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[6]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(2000);
		System.out.println("Last name admin added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//check preview share added
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/a/span")).click(); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@data-target='#share_preview_modal']")).click(); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='share_preview_modal']/div/div[1]/button")).click(); Thread.sleep(3000);	
		System.out.println("Normal share details are added successfully");
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Initiate share
		Thread.sleep(3000);	Actions initiate = new Actions(driver);
		WebElement ini =driver.findElement(By.xpath("//*[@id='clientsharerow']/td[8]/button"));
	    initiate.moveToElement(ini).build().perform(); Thread.sleep(3000);
	    JamesCreateShareFirefox.captureScreenShot(driver); ini.click();
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(20000);	
		System.out.println("Successfully passed!, CreateNewNormalShare()");
		System.out.println("---------------------------------------------------------------------------------");
		JamesCreateShareFirefox.captureScreenShot(driver);
		}
		
		
	@Test (priority=3)
	public void createNewSubcompanyShare() throws InterruptedException, IOException {	
		driver.findElement(By.xpath("//*[@id='show-sent']")).click(); 
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='addclientshare']")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.id("seller")).sendKeys("Vodafone"); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[1]/div/div[1]/div[1]/a[2]/div")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[1]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Seller company added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		// Add buyer company
		driver.findElement(By.xpath("//input[@name='buyer[buyer_name]']")).sendKeys("Airtel India"); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[2]/div/div[1]/div[2]/a[1]/div")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[2]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Buyer company added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add ShareName
		driver.findElement(By.xpath("//input[@id='client_share_name']")).sendKeys("SubCompanyShare0005"); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[3]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(3000);
		System.out.println("Sharename added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add email address
		driver.findElement(By.id("admin_email")).sendKeys("nirmohi.qa@gmail.com"); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[4]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(3000);
		System.out.println("Admin email-id added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add first name 
		driver.findElement(By.xpath("//input[@id='admin_first_name']")).sendKeys("Ashish"); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[5]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(3000);
		System.out.println("Admin first name added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Add last name
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='admin_last_name']")).sendKeys("Nirmohi"); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[6]/div/div[3]/button[2]")).sendKeys(Keys.ENTER); Thread.sleep(3000);
		System.out.println("Admin last name added");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//check preview share added
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/a/span")).click(); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@data-target='#share_preview_modal']")).click(); Thread.sleep(3000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='share_preview_modal']/div/div[1]/button")).click(); Thread.sleep(3000);	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		// Choose sub-company option from pop-up
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/a/span")).click(); Thread.sleep(5000);
		JamesCreateShareFirefox.captureScreenShot(driver);
		Actions share = new Actions(driver);
	    WebElement subcompany = driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/ul/li[4]/a")); Thread.sleep(5000); //sub-company under 3dot
	    share.moveToElement(subcompany).build().perform(); Thread.sleep(5000);	    
	    Thread.sleep(5000);	subcompany.click(); Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mySubCompanyModal']/div/div/div[2]/label")).click(); Thread.sleep(5000); // tick check box
		JamesCreateShareFirefox.captureScreenShot(driver);
		WebElement save = driver.findElement(By.xpath("//*[@id='mySubCompanyModal']/div/div/div[3]/button[2]")); Thread.sleep(3000);
		share.moveToElement(save).build().perform(); Thread.sleep(3000);  
		Thread.sleep(5000); save.click(); 
		System.out.println("Sub-company share details are added successfully");	
		JamesCreateShareFirefox.captureScreenShot(driver);
		
		//Customize share
		driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/a/span")).click(); Thread.sleep(5000);
		Actions customize = new Actions(driver);
	    WebElement customise = driver.findElement(By.xpath("//*[@id='clientsharerow']/td[7]/div/ul/li[2]/a")); 
	    share.moveToElement(customise).build().perform(); Thread.sleep(6000); 
		customise.click(); 
		Runtime.getRuntime().exec("D:\\AutoIt\\customizewallpaper.exe"); Thread.sleep(10000);	
		JamesCreateShareFirefox.captureScreenShot(driver);
		WebElement savecustomise = driver.findElement(By.xpath("//*[@id='mySubCompanyModal']/div/div/div[3]/button[2]")); Thread.sleep(5000);
		customize.moveToElement(savecustomise).build().perform(); Thread.sleep(5000);
		save.click(); Thread.sleep(5000); JamesCreateShareFirefox.captureScreenShot(driver); Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mySubCompanyModal']/div/div/div[3]/button[2]")).click(); Thread.sleep(5000);	
		JamesCreateShareFirefox.captureScreenShot(driver);
		System.out.println("Sub-company share details are added successfully");		Thread.sleep(5000);
		
		// Initiate share		
		Actions initiate1 = new Actions(driver);
		WebElement ini1 =driver.findElement(By.xpath("//*[@id='clientsharerow']/td[8]/button"));
	    initiate1.moveToElement(ini1).build().perform(); Thread.sleep(5000);
	    ini1.click(); Thread.sleep(5000); JamesCreateShareFirefox.captureScreenShot(driver); Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button[2]")).click(); Thread.sleep(23000);	
		JamesCreateShareFirefox.captureScreenShot(driver);
		System.out.println("Successfully passed!, CreateNewSubcompanyShare()");
		System.out.println("---------------------------------------------------------------------------------");
		
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
		java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\login\\Screenshot.jpg"));	
		String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\createshare\\" + filename);
		FileUtils.copyFile(screenshot, dest);
		 
		}
	
		
		@AfterTest
		public void closewebsite() {
			//driver.quit();
		}
}
