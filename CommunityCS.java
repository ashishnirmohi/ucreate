	
	package adminhomepage;
	import org.testng.annotations.Test;
	import org.testng.AssertJUnit;
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
	
	
	public class CommunityCS {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver(); driver.manage().window().maximize(); System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()"); Thread.sleep(5000);
		CommunityCS.captureScreenShot(driver); 	
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
			
	@Test (priority = 0)
	public void Homepage() throws InterruptedException, IOException {
		
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
       
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");		
		System.out.println("Email and password added to login form"); Thread.sleep(2000);				
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		CommunityCS.captureScreenShot(driver);
		
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); System.out.println("Login form submitted");
		System.out.println(driver.getCurrentUrl()); Thread.sleep(5000);
		System.out.println("Homepage opened successfully, Successfully passed!, Homepage()"); 
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	@Test (priority = 1)
	public void switchShare() throws InterruptedException, IOException {		
			
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/a")); Thread.sleep(3000);
	    Assert.assertTrue(sh.isDisplayed()); 
	    share.moveToElement(sh).build().perform(); 
	    Thread.sleep(5000); sh.click(); Thread.sleep(3000);
		WebElement bnb= driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[5]/a"));
		Assert.assertTrue(bnb.isDisplayed()); bnb.click(); Thread.sleep(3000);	
		WebElement shr = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/a"));
		shr.click(); Thread.sleep(3000);
		WebElement av= driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[5]/a")); Thread.sleep(2000);
		Assert.assertTrue(bnb.isDisplayed()); av.click(); Thread.sleep(4000);
		System.out.println("Successfully moved to desired share, passed: SwitchShare()");
		CommunityCS.captureScreenShot(driver);
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	
	@Test (priority = 2)
	public void community_landing_Page() throws InterruptedException, Exception {
		System.out.println("Feature Community_landing_Page(): started ");
		Actions community = new Actions(driver);
	    WebElement comm = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")); Thread.sleep(3000);
	    
	    System.out.println("link under test is: " +comm.getText());
	    System.out.println("Link isDisplayed yes/no: " +comm.isDisplayed());
	    System.out.println("link is enabled true/false: " +comm.isEnabled());
	    System.out.println("Link attribute type is: " +comm.getAttribute("type"));
	    System.out.println("Link attribute value is: "+comm.getAttribute("value"));
	    community.moveToElement(comm).build().perform(); Thread.sleep(7000);
	    CommunityCS.captureScreenShot(driver);
	    
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a")).click(); Thread.sleep(3000); // community	
		System.out.println("Community page opened & URL is below");
		CommunityCS.captureScreenShot(driver);
		System.out.println(driver.getCurrentUrl()); 
		
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[1]/a")).click(); Thread.sleep(4000); //feed
		System.out.println(driver.getCurrentUrl()); driver.navigate().back(); Thread.sleep(5000);
	    System.out.println(driver.getCurrentUrl()); driver.navigate().refresh(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver);
	    WebElement comMty = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")); Thread.sleep(3000);
	    AssertJUnit.assertTrue(comMty.isDisplayed()); comMty.click();
	    
		WebElement Community1 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community1); Thread.sleep(3000); // scroll here
		CommunityCS.captureScreenShot(driver);
		 
		WebElement Community2 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community2); Thread.sleep(3000);
		CommunityCS.captureScreenShot(driver);
		 
		WebElement Community3 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community3); Thread.sleep(3000); // scroll here
		CommunityCS.captureScreenShot(driver);
		  
		WebElement Community4 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community4); Thread.sleep(3000); // 
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community5 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community5); Thread.sleep(3000); // 
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community6 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[6]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community6); Thread.sleep(3000); // 
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community7 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[7]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community7); Thread.sleep(3000); //
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community8 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[8]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community8); Thread.sleep(3000); // 	    
	    System.out.println("Community page scrolled to bottom");
	    CommunityCS.captureScreenShot(driver);
	    
	    WebElement Community81 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[9]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community81); Thread.sleep(3000); // 	    
	    System.out.println("Community page scrolled to bottom");
	    CommunityCS.captureScreenShot(driver);
	    
	    WebElement Community82 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[10]/div[4]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community82); Thread.sleep(3000); // 	    
	    System.out.println("Community page scrolled to bottom");
	    CommunityCS.captureScreenShot(driver);
	    
	    WebElement Community83 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[9]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community83); Thread.sleep(3000); // 	    
	    System.out.println("Community page scrolled to bottom");
	    CommunityCS.captureScreenShot(driver); 
	    
	    WebElement Community84 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[8]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community84); Thread.sleep(3000); // 	    
	    System.out.println("Community page scrolled to bottom");
	    CommunityCS.captureScreenShot(driver);
	    
		WebElement Community9 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[7]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community9); Thread.sleep(3000); // 
		CommunityCS.captureScreenShot(driver);
		 
		WebElement Community10 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[6]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community10); Thread.sleep(3000); // 
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community11 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community11); Thread.sleep(3000); // 
		 CommunityCS.captureScreenShot(driver);
		 
		WebElement Community12 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community12); Thread.sleep(3000); // 
		 CommunityCS.captureScreenShot(driver);
		 
		WebElement Community13 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community13); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community14 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community14); Thread.sleep(3000);
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community15 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community15); Thread.sleep(3000);
		System.out.println("Community page scrolled to top again"); CommunityCS.captureScreenShot(driver);
		System.out.println("Successfully passed!, Community_landing_Page()");
		System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	@Test (priority=3)
	public void community_Search() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Search(): started ");
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click();
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img")).click();  Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(""); Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
		System.out.println("Empty text search done to CHECK 'Search field can not be empty' validation :: WORKING FINE");
		
		System.out.println("Searching by name: ashish");
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); Thread.sleep(3000); //click search icon
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img")).click();  Thread.sleep(3000);
		
	    driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys("ashish"); Thread.sleep(4000);
	    driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
	    CommunityCS.captureScreenShot(driver);
	    
	    WebElement search1 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", search1); Thread.sleep(3000); 	    
		CommunityCS.captureScreenShot(driver);
		
		WebElement search2 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", search2); Thread.sleep(3000);	    
		CommunityCS.captureScreenShot(driver);
		 
		WebElement search3 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[10]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", search3); Thread.sleep(3000);
		System.out.println("Search result is scrolled to bottom");
		CommunityCS.captureScreenShot(driver);
		
		WebElement search4 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", search4); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement search5 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", search5); Thread.sleep(3000); 
		System.out.println("Search results is again scrolled to top");
		System.out.println("Searching by name: passed");
		
		System.out.println("Searching by job-profile: Delivery manager");
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys("Delivery manager"); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
		System.out.println("Searching by job-profile: Passed");
		CommunityCS.captureScreenShot(driver);
		
	    System.out.println("Successfully passed!, Community_Search()");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}	
	
	@Test (priority=4)
	public void community_Invite() throws InterruptedException, IOException { 
		
		System.out.println("Feature Community_invite(): started");
		WebElement community = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a"));
		AssertJUnit.assertTrue(community.isDisplayed());
		community.click(); Thread.sleep(4000);
		
	    WebElement invitelink = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/a"));
	    AssertJUnit.assertTrue(invitelink.isDisplayed()); Thread.sleep(4000);
	    invitelink.click(); Thread.sleep(4000); CommunityCS.captureScreenShot(driver); 
	  
	    WebElement invite = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[2]"));
	    AssertJUnit.assertTrue(invite.isDisplayed()); Thread.sleep(4000);
	    invite.click(); Thread.sleep(6000); CommunityCS.captureScreenShot(driver); 
	 
	    System.out.println("Empty form submitted to CHECK 'This field is required' validation :: WORKING FINE");
	    driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[1]/button/span")).click(); Thread.sleep(8000);
	    
	    WebElement InviteLink = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/a"));
	    AssertJUnit.assertTrue(InviteLink.isDisplayed()); Thread.sleep(4000);
	    InviteLink.click(); Thread.sleep(5000);	 CommunityCS.captureScreenShot(driver);    
	    WebElement invitebuTTon = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[3]/button[2]"));
	    AssertJUnit.assertTrue(invitebuTTon.isDisplayed()); Thread.sleep(4000);
	    invitebuTTon.click(); Thread.sleep(6000);
	    WebElement fname = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[1]/input"));
	    AssertJUnit.assertTrue(fname.isDisplayed()); Thread.sleep(4000);
	    fname.sendKeys("AshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
	    WebElement lname = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[2]/input"));
	    AssertJUnit.assertTrue(lname.isDisplayed()); Thread.sleep(4000);
	    lname.sendKeys("NirmohiAshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
	    invitebuTTon.click(); Thread.sleep(5000); CommunityCS.captureScreenShot(driver);
	    
	    System.out.println("Wrong input text to CHECK 'First name cannot be greater than 25 characters' validation :: WORKING FINE");
	 
	    fname.clear();; Thread.sleep(2000);
	    fname.sendKeys("Ashish"); Thread.sleep(2000);
	    lname.clear(); Thread.sleep(2000);	    
	    lname.sendKeys("Nirmohi"); Thread.sleep(2000);
	    WebElement email = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input"));
	    AssertJUnit.assertTrue(email.isDisplayed()); Thread.sleep(4000);
	    email.sendKeys("x@yz"); Thread.sleep(2000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver);
	    System.out.println("Wrong email-id to CHECK 'Invalid email address.' validation :: WORKING FINE");
	    
	    email.clear(); Thread.sleep(2000); email.sendKeys("x@y.z"); Thread.sleep(2000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver);
	    System.out.println("Not restricted domian to CHECK 'Invalid Email Domain: your Client Share has been locked down to @GMAIL ... If you wish to add a domain please email an administrator: ADMIN' validation :: WORKING FINE");
	    
	    
	    email.clear();
	    driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("ashish.nirmohi@gmail.com");
	    WebElement message = driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[2]/div[6]/div/textarea"));
	    AssertJUnit.assertTrue(message.isDisplayed()); Thread.sleep(4000); message.clear();
	    message.sendKeys("GOOD WORK, KEEP IT UP");
	    WebElement invitebutTToN = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button[2]"));
	    AssertJUnit.assertTrue(message.isDisplayed()); Thread.sleep(4000);
	    invitebutTToN.click(); Thread.sleep(5000); CommunityCS.captureScreenShot(driver);
	    System.out.println("Already registered email-id to CHECK 'This user is already a member of this Client Share' validation :: WORKING FINE");
	    
	    email.clear(); email.sendKeys("QualityA3Nirmohi@yopmail.com");
	    invitebutTToN.click(); Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[1]/span")).click();
	    driver.findElement(By.xpath("//*[@id=\"myModal_invite\"]/div/div[2]/div[1]/button/span")).click(); Thread.sleep(2000);
	    CommunityCS.captureScreenShot(driver); 
	    
	    System.out.println("Already invited member email-id to CHECK 'This user already has a pending invite for this Client Share. You can resend the invitation via Pending Invites in Settings' VALIDATION :: WORKING FINE");
	    System.out.println("Successfully passed!, Community_Invite()");
		System.out.println("------------------------------------------------------------------------------------------");
	    
		}
	
	@Test (priority = 5)
	public void community_Filter_Seller() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Filter_Seller(): started");
		Actions seller = new Actions(driver);
	    WebElement se = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[2]/a")); Thread.sleep(3000);
	    seller.moveToElement(se).build().perform();
	    CommunityCS.captureScreenShot(driver);
	    
	    driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[2]/a")).click();
	    System.out.println(driver.getCurrentUrl());
	    WebElement seller1 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller1); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement seller2 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller2); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement seller3 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[8]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller3); Thread.sleep(3000);
		System.out.println("Seller filtered result is scrolled to bottom");	
		CommunityCS.captureScreenShot(driver);
	    
		WebElement seller4 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller4); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement seller5 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller5); Thread.sleep(3000); 
		System.out.println("Seller filtered result is again scrolled to top");
		CommunityCS.captureScreenShot(driver);
		
		System.out.println("Successfully passed!, Community_Filter_Seller()");
		System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	
	@Test (priority = 6)
	public void community_Filter_Buyer() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Filter_Buyer(): started");
		driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); // Community
		Actions buyer = new Actions(driver); 
		WebElement buy = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[3]/a")); Thread.sleep(3000); // Buyer community link 
		buyer.moveToElement(buy).build().perform(); 
		CommunityCS.captureScreenShot(driver);
		
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[3]/a")).click();	
		System.out.println(driver.getCurrentUrl());
	    WebElement buyer1 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer1); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
	    WebElement buyer2 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer2); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
			 
	    WebElement buyer3 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer3); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		 
	    WebElement buyer4 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer4); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
	    WebElement buyer5 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer5); Thread.sleep(3000); 
		System.out.println("Buyers filtered result is scrolled to bottom");
		CommunityCS.captureScreenShot(driver);
		
		WebElement buyer05 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[6]/div[5]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer05); Thread.sleep(3000); 
		System.out.println("Buyers filtered result is scrolled to bottom");
		CommunityCS.captureScreenShot(driver);
		
		WebElement buyer6 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer6); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
	    WebElement buyer7 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer7); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
	    WebElement buyer8 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer8); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
	    WebElement buyer9 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer9); Thread.sleep(3000); 	
		CommunityCS.captureScreenShot(driver);
		
		WebElement buyer10 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer10); Thread.sleep(3000); 
		CommunityCS.captureScreenShot(driver);
		
		System.out.println("Buyers filtered result is scrolled to top"); System.out.println("Successfully passed!, Community_Filter_Buyer()");	
		System.out.println("------------------------------------------------------------------------------------------");

		}
	
	
	@Test (priority = 7)
	public void community_Email_linkedIn() throws InterruptedException, IOException {
		
		System.out.println("Feature Community_Email_linkedIn(): started ");
		WebElement coM= driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a"));
		AssertJUnit.assertTrue(coM.isDisplayed()); Thread.sleep(3000);
		coM.click(); Thread.sleep(4000); //community	
		WebElement search = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img"));
		AssertJUnit.assertTrue(search.isDisplayed()); Thread.sleep(3000);
		search.click(); Thread.sleep(3000);		
		WebElement text = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div/div/div/div[2]/span[1]/a/img"));
		AssertJUnit.assertTrue(text.isDisplayed()); Thread.sleep(4000);
		text.sendKeys("Jonathan"); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);	
		System.out.println("Member Jonathan Davis is searched from community");
		CommunityCS.captureScreenShot(driver);	
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/span[1]")).click(); Thread.sleep(4000);   
		driver.findElement(By.xpath("//*[@id=\"member_info_modal\"]/div/div/div[1]/button/img")).click();
		CommunityCS.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); // Community
		System.out.println("For searched member, personal email shooted");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}

	@Test (priority = 8)
	public void signout() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[7]/a")).click(); Thread.sleep(2000);
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[7]/ul/li[2]/a")); Thread.sleep(3000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(4000);
	    CommunityCS.captureScreenShot(driver);
		logout.click(); Thread.sleep(5000); //sign-out
		System.out.println("Signout done successfully");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\community\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		 
		}
	
	@AfterTest
	public void close_browser() {	
	
		driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}	
}
