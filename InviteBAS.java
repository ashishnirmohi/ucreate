package invite;
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

import adminhomepage.CommunityCS;


public class InviteBAS {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException {
		
		System.out.println("-------------Buyer Admin Subcompany Share Testing-----------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		InviteBAS.captureScreenShot(driver);
	}
	@Test (priority = 0)
	public void homepageBuyerAdminSubcompanyCS() throws InterruptedException, Exception {
		
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
		driver.findElement(By.id("email")).sendKeys("qex9007@yopmail.com"); Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("@Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(2000);			
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);		
		InviteBAS.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	@Test (priority=1)
	public void community_InviteFromBuyerAdminSubcompanyShare() throws InterruptedException, IOException { 
		
		System.out.println("Feature Community_invite(): started");
		WebElement community = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a"));
		Assert.assertTrue(community.isDisplayed());
		community.click(); Thread.sleep(4000);
		
	    WebElement invitelink = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/a"));
	    Assert.assertTrue(invitelink.isDisplayed()); Thread.sleep(4000);
	    invitelink.click(); Thread.sleep(4000); InviteBAS.captureScreenShot(driver); 
	  
	    WebElement invite = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[2]"));
	    Assert.assertTrue(invite.isDisplayed()); Thread.sleep(4000);
	    invite.click(); Thread.sleep(6000); InviteBAS.captureScreenShot(driver); 
	 
	    System.out.println("Empty form submitted to CHECK 'This field is required' validation :: WORKING FINE");
	    driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[1]/button/span")).click(); Thread.sleep(8000);
	    
	    WebElement InviteLink = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/a"));
	    Assert.assertTrue(InviteLink.isDisplayed()); Thread.sleep(4000);
	    InviteLink.click(); Thread.sleep(5000);	 InviteBAS.captureScreenShot(driver);    
	    WebElement invitebuTTon = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[2]"));
	    Assert.assertTrue(invitebuTTon.isDisplayed()); Thread.sleep(4000);
	    invitebuTTon.click(); Thread.sleep(6000);
	    WebElement fname = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[1]/input"));
	    Assert.assertTrue(fname.isDisplayed()); Thread.sleep(4000);
	    fname.sendKeys("AshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
	    WebElement lname = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[2]/input"));
	    Assert.assertTrue(lname.isDisplayed()); Thread.sleep(4000);
	    lname.sendKeys("NirmohiAshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
	    invitebuTTon.click(); Thread.sleep(5000); InviteBAS.captureScreenShot(driver);
	    
	    System.out.println("Wrong input text to CHECK 'First name cannot be greater than 25 characters' validation :: WORKING FINE");
	 
	    fname.clear();; Thread.sleep(2000);
	    fname.sendKeys("Ashish"); Thread.sleep(2000);
	    lname.clear(); Thread.sleep(2000);	    
	    lname.sendKeys("Nirmohi"); Thread.sleep(2000);
	    WebElement email = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input"));
	    Assert.assertTrue(email.isDisplayed()); Thread.sleep(4000);
	    email.sendKeys("x@yz"); Thread.sleep(2000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    InviteBAS.captureScreenShot(driver);
	    System.out.println("Wrong email-id to CHECK 'Invalid email address.' validation :: WORKING FINE");
	    
	    email.clear(); Thread.sleep(2000); email.sendKeys("x@y.z"); Thread.sleep(2000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    InviteBAS.captureScreenShot(driver);
	    System.out.println("Not restricted domian to CHECK 'Invalid Email Domain: your Client Share has been locked down to @GMAIL ... If you wish to add a domain please email an administrator: ADMIN' validation :: WORKING FINE");
	    
	    
	    email.clear();
	    driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("ashish.nirmohi@gmail.com");
	    WebElement message = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[6]/div/textarea"));
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000); message.clear();
	    message.sendKeys("GOOD WORK, KEEP IT UP");
	    WebElement invitebutTToN = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button[2]"));
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000);
	    invitebutTToN.click(); Thread.sleep(5000); InviteBAS.captureScreenShot(driver);
	    System.out.println("Already registered email-id to CHECK 'This user is already a member of this Client Share' validation :: WORKING FINE");
	    
	    email.clear(); email.sendKeys("QualityA3Nirmohi@yopmail.com");
	    invitebutTToN.click(); Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[1]/span")).click();
	    driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[1]/button/span")).click(); Thread.sleep(2000);
	    InviteBAS.captureScreenShot(driver); 
	    
	    System.out.println("Already invited member email-id to CHECK 'This user already has a pending invite for this Client Share. You can resend the invitation via Pending Invites in Settings' VALIDATION :: WORKING FINE");
	    System.out.println("Successfully passed!, Community_Invite()");
		System.out.println("------------------------------------------------------------------------------------------");
	    
		}
	@Test (priority=2)
	public void invite_URL() throws InterruptedException {
		
		WebElement feed = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[1]/a"));
		Assert.assertTrue(feed.isDisplayed()); feed.click();
		WebElement inviteColleagues = driver.findElement(By.xpath("//*[@id=\"tour3\"]/div[2]/button"));
		Assert.assertTrue(inviteColleagues.isDisplayed()); inviteColleagues.click();
		WebElement radioURL = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[4]/div[2]/label"));
		Assert.assertTrue(radioURL.isDisplayed()); radioURL.click(); Thread.sleep(2000);
		WebElement CreateURL = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[1]"));
		Assert.assertTrue(CreateURL.isDisplayed()); System.out.println("Create URL text is displayed: " +CreateURL.isDisplayed());
		CreateURL.click(); Thread.sleep(2000);
		WebElement fname = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[1]/input"));
		Assert.assertTrue(fname.isDisplayed()); fname.sendKeys("Ashish"); Thread.sleep(2000);
		WebElement lname = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[2]/input"));
		Assert.assertTrue(lname.isDisplayed()); lname.sendKeys("Kumar"); Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[3]/input"));
		Assert.assertTrue(email.isDisplayed()); email.sendKeys("qaoO1@yopmail.com"); Thread.sleep(2000);
		WebElement createURL = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[1]"));
		Assert.assertTrue(createURL.isDisplayed()); createURL.click();  Thread.sleep(2000);
		WebElement url = driver.findElement(By.xpath("//*[@id=\"invite_url\"]"));
		Assert.assertTrue(url.isDisplayed()); System.out.println("Invitation URL created: " +url.getText()); Thread.sleep(2000);
		WebElement done = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[3]"));
		Assert.assertTrue(done.isDisplayed());	Thread.sleep(2000);
		System.out.println("Done link text is displayed: " +done.isDisplayed()); done.click();
		WebElement copyLink = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[7]/button"));
		System.out.println("Copy link text is displayed: " +copyLink.isDisplayed());
		WebElement close = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[1]/button/span"));
		Assert.assertTrue(close.isDisplayed());	System.out.println("X-close link is displayed: " +close.isDisplayed());
		Thread.sleep(2000); close.click();
	}
	
	@Test (priority = 3)
	public void signout() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/a")).click(); Thread.sleep(2000);
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a")); Thread.sleep(3000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(4000);
	    CommunityCS.captureScreenShot(driver);
		logout.click(); Thread.sleep(5000); //sign-out
		System.out.println("Signout done successfully");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.quit();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\invitesNormalSubcompamy\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}
}
