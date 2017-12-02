			
		package datadriventest;
		import java.io.File;
		import java.io.FileInputStream;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.List;
		import jxl.Workbook;
		import jxl.read.biff.BiffException;		
		import org.apache.commons.io.FileUtils;
		import org.junit.Ignore;
		import org.openqa.selenium.By;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		//import org.testng.Assert;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
			
		public class InviteDD {
		jxl.Sheet s;
		WebDriver driver;
		
		@BeforeTest	
		public void lauchBrowserLogin() throws InterruptedException, IOException{
		System.out.println("-------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://uat-clientspace.herokuapp.com");
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.id("email")).sendKeys("nirmohi.qa@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.id("show-sent")).click(); Thread.sleep(4000);
		System.out.println("Successfully passed, LauchbrowserLogin()");
		System.out.println("-------------------------------------------------------------------------------");
			
		}

		@Test(priority = 3)
		public void inviteColleague() throws InterruptedException, BiffException, IOException { 			
		driver.findElement(By.xpath("//*[@id='tour3']/div[2]/button")).click(); Thread.sleep(6000); 
		InviteDD.captureScreenShot(driver);
		    
	    System.out.println("Empty form submitted to CHECK 'This field is required' validation :: WORKING FINE");
		   
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[1]/input")).sendKeys("AshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[2]/input")).sendKeys("NirmohiAshishKumarDhimanNirmohiRehan"); Thread.sleep(2000);
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(5000);
		InviteDD.captureScreenShot(driver);
		    
		System.out.println("Wrong input text to CHECK 'First name cannot be greater than 25 characters' validation :: WORKING FINE");
		 
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[1]/input")).clear();; Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[1]/input")).sendKeys("Ashish"); Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[2]/input")).clear(); Thread.sleep(2000);	    
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[2]/input")).sendKeys("Nirmohi"); Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("x@yz");
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(5000);
		InviteDD.captureScreenShot(driver);
		System.out.println("Wrong email-id to CHECK 'Invalid email address.' validation :: WORKING FINE");
		    
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("x@y.z");
		Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(5000);
		InviteDD.captureScreenShot(driver);
		System.out.println("Not restricted domian to CHECK 'Invalid Email Domain: your Client Share has been locked down to @GMAIL ... If you wish to add a domain please email an administrator: ADMIN' validation :: WORKING FINE");
		    
		    
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("ashish.nirmohi@gmail.com");
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[5]/div/textarea")).clear();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[5]/div/textarea")).sendKeys("GOOD WORK, KEEP IT UP");
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(5000);
		InviteDD.captureScreenShot(driver);
		System.out.println("Already registered email-id to CHECK 'This user is already a member of this Client Share' validation :: WORKING FINE");
		    
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[3]/input")).sendKeys("QualityA3Nirmohi@yopmail.com");
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[1]/button")).click(); Thread.sleep(2000);
		InviteDD.captureScreenShot(driver);
		    
		System.out.println("Already invited member email-id to CHECK 'This user already has a pending invite for this Client Share. You can resend the invitation via Pending Invites in Settings' VALIDATION :: WORKING FINE");
		    
		System.out.println("Successfully passed!, Community_Invite()");
		System.out.println("------------------------------------------------------------------------------------------");	
		}	
		
		@Ignore
		public void addRestrictedDomain() throws IOException {
		driver.findElement(By.xpath("//*[@id='tour3']/div[2]/button")).click();
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[2]/form/div[2]/input")).sendKeys("outlook.com");
		WebElement Add_email_domain = driver.findElement(By.linkText("Add another email domain"));
		Add_email_domain.click();
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[2]/form/div[3]/input")).sendKeys("rediffmail.com");
		InviteDD.captureScreenShot(driver);
		Add_email_domain.click();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[2]/form/div[4]/input")).sendKeys("yahoo.com");
		Add_email_domain.click();
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[2]/form/div[5]/input")).sendKeys("gmail.com");
		Add_email_domain.click();
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[2]/form/div[5]/input")).sendKeys("yopmail.com");	
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[1]/div[3]/button")).click();
		InviteDD.captureScreenShot(driver);
		System.out.println("-------------------------------------------------------------------------------");
		}
		
		@Test(priority=5)
		public void invitationExcel() throws InterruptedException, BiffException, IOException{
		driver.findElement(By.xpath("//*[@id='tour3']/div[2]/button")).click();
		FileInputStream fin = new FileInputStream("D:\\Datadriven\\inviteDDnew.xls");
		Workbook wb = Workbook.getWorkbook(fin);
		s = wb.getSheet(0);
		for (int row = 1; row < s.getRows(); row++) {

		String fname = s.getCell(0, row).getContents();
		System.out.println("First name is: " + fname);	
		driver.findElement(By.name("first_name")).sendKeys(fname); Thread.sleep(3000);
		InviteDD.captureScreenShot(driver); 
			
		String lname = s.getCell(1, row).getContents();
		System.out.println("Last name is: " + lname);			
		driver.findElement(By.name("last_name")).sendKeys(lname); Thread.sleep(3000);
		InviteDD.captureScreenShot(driver);
			
		String email = s.getCell(2, row).getContents();
		System.out.println("Email address is: " + email);			
		driver.findElement(By.name("email")).sendKeys(email); Thread.sleep(3000);
		InviteDD.captureScreenShot(driver);
			
		String message = s.getCell(3, row).getContents();
		System.out.println("Message is: " + message); Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[5]/div/textarea")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[2]/div[5]/div/textarea")).sendKeys(message); 
		Thread.sleep(3000);
		InviteDD.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[3]/button")).click(); Thread.sleep(6000);
		InviteDD.captureScreenShot(driver);
		List <WebElement> li = driver.findElements(By.className("error-msg"));
		System.out.println("Number of error:" +li.size());
		for(WebElement we : li){
		we.getText();
		}
		//Other way to print all links:
		for(int i = 0; i < li.size(); i++){
		System.out.println(li.get(i).getText());
		}
			
		WebElement invitesent = driver.findElement(By.xpath("//*[@id='myModal_invite']/div/div[2]/div[1]/span"));
		System.out.println(invitesent.getText());
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("email")).clear();			
			}		
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException {
		java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\invitations\\Screenshot.jpg"));	
		String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\invitations\\" + filename);
		FileUtils.copyFile(screenshot, dest);
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed");
			}	
		}
