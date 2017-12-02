	package settings;
		
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
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

	public class UserManagement {
	WebDriver driver;
			
	@BeforeTest	
	public void Lauchbrowser(){
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}
		
	@Test (priority=0)
	public void loginAdmin() throws Exception {
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("settingud01@yopmail.com"); Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("@Test1234"); Thread.sleep(3000);
	UserManagement.captureScreenShot(driver);
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(4000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
	}		
	
	@Test(priority=2)
	public void userManagement() throws InterruptedException, Exception {
	WebElement settingUM = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(settingUM.isDisplayed());
	settingUM.click(); 
	
	driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[2]/a")).click(); 	
	WebElement hoverUserRow = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]")); 
	Assert.assertTrue(hoverUserRow.isDisplayed());
	Actions tdm = new Actions(driver);
	tdm.moveToElement(hoverUserRow).build().perform(); 
	UserManagement.captureScreenShot(driver);Thread.sleep(2000);
		
	}
	
	@Test (priority=3)
	public void editCompany() throws InterruptedException, IOException {
	Thread.sleep(4000);
	WebElement settingEC = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(settingEC.isDisplayed()); Thread.sleep(2000); settingEC.click(); 
	WebElement userM = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[2]/a")); 
	Assert.assertTrue(userM.isDisplayed());
	Actions tdm1 = new Actions(driver);
	tdm1.moveToElement(userM).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(4000);
	userM.click(); Thread.sleep(5000); // user management Tab clicking
	
	WebElement hoverUserRow1 = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]")); 
	Assert.assertTrue(hoverUserRow1.isDisplayed());
	tdm1.moveToElement(hoverUserRow1).build().perform(); Thread.sleep(4000);	
	
	WebElement threeDotEC = driver.findElement(By.xpath("//*[@id='user-management-tab']/div[3]/div[1]/div[2]/div[4]/div/a/span")); Thread.sleep(2000);
	Assert.assertTrue(threeDotEC.isDisplayed());
	tdm1.moveToElement(threeDotEC).build().perform(); Thread.sleep(4000); threeDotEC.click();
	
	WebElement editCompany = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]/div[4]/div/ul/li[1]/a")); //edit company 
	Assert.assertTrue(editCompany.isDisplayed());  
	tdm1.moveToElement(editCompany).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(3000); editCompany.click(); 
	UserManagement.captureScreenShot(driver);
	driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]/div[3]/span[3]/div/div/button/span[1]")).click(); 
	UserManagement.captureScreenShot(driver);
	WebElement chcm = driver.findElement(By.xpath("//a/span[contains(text(),'ucreate')]")); Thread.sleep(2000);
	Assert.assertTrue(chcm.isDisplayed());
	tdm1.moveToElement(chcm).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(4000); chcm.click(); 
	WebElement cancelEC = driver.findElement(By.xpath("//*[@id=\"editcompany\"]/div/div/div[3]/button")); 
	Assert.assertTrue(cancelEC.isDisplayed());
	tdm1.moveToElement(cancelEC).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(4000);
	cancelEC.click(); Thread.sleep(4000); //Cancel click company change	
	
	}
	
	@Test (priority=4)
	public void promoteAdminsterator() throws InterruptedException, IOException {
	Thread.sleep(4000);
	WebElement settingPTA = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(settingPTA.isDisplayed());
	settingPTA.click(); Thread.sleep(4000);
	WebElement userMgmt = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[2]/a"));
	Assert.assertTrue(userMgmt.isDisplayed());
	Actions tdm2 = new Actions(driver);
	tdm2.moveToElement(userMgmt).build().perform(); Thread.sleep(4000);
	userMgmt.click(); Thread.sleep(4000);
	WebElement hoverUserRow2 = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]")); 
	Assert.assertTrue(hoverUserRow2.isDisplayed());
	
	tdm2.moveToElement(hoverUserRow2).build().perform(); Thread.sleep(4000);
	WebElement threeDotPTA = driver.findElement(By.xpath("//*[@id='user-management-tab']/div[3]/div[1]/div[2]/div[4]/div/a/span"));
	Assert.assertTrue(threeDotPTA.isDisplayed());
	tdm2.moveToElement(threeDotPTA).build().perform(); Thread.sleep(5000); threeDotPTA.click();	
	WebElement promoteAdmin = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]/div[4]/div/ul/li[2]/a")); 
	Assert.assertTrue(promoteAdmin.isDisplayed());
	tdm2.moveToElement(promoteAdmin).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(5000); 
	promoteAdmin.click(); UserManagement.captureScreenShot(driver);
	WebElement cancelPromote = driver.findElement(By.xpath("//*[@id=\"promoteuser\"]/div/div/div[3]/button")); 
	Assert.assertTrue(cancelPromote.isDisplayed());
	tdm2.moveToElement(cancelPromote).build().perform(); UserManagement.captureScreenShot(driver); Thread.sleep(5000);
	cancelPromote.click(); Thread.sleep(5000);	
	
	}
	
	@Test (priority=5)
	public void removeUser() throws InterruptedException, IOException {
	Thread.sleep(4000);
	WebElement settingRU = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(settingRU.isDisplayed());
	settingRU.click(); Thread.sleep(5000);
	WebElement userMg = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[2]/a")); 
	Assert.assertTrue(userMg.isDisplayed());
	Actions tdm3 = new Actions(driver);
	tdm3.moveToElement(userMg).build().perform(); Thread.sleep(5000);
	userMg.click(); Thread.sleep(4000);
	WebElement hoverUserRow3 = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div[1]/div[2]")); 	
	Assert.assertTrue(hoverUserRow3.isDisplayed());
	tdm3.moveToElement(hoverUserRow3).build().perform(); Thread.sleep(5000);
	WebElement threeDotRU = driver.findElement(By.xpath("//*[@id='user-management-tab']/div[3]/div[1]/div[2]/div[4]/div/a/span"));
	Assert.assertTrue(threeDotRU.isDisplayed());
	tdm3.moveToElement(threeDotRU).build().perform(); Thread.sleep(5000);
	threeDotRU.click(); UserManagement.captureScreenShot(driver); Thread.sleep(5000);
		
	WebElement removeUsr = driver.findElement(By.xpath("//*[@id=\"user-management-tab\"]/div[3]/div/div[2]/div[4]/div/ul/li[3]/a")); 
	Assert.assertTrue(removeUsr.isDisplayed());
	tdm3.moveToElement(removeUsr).build().perform(); Thread.sleep(3000);
	Thread.sleep(3000); removeUsr.click(); Thread.sleep(3000);
	WebElement cancelRemoveUser = driver.findElement(By.xpath("//*[@id=\"removeuserpopup\"]/div/div/div[3]/button"));
	Assert.assertTrue(cancelRemoveUser.isDisplayed());
	tdm3.moveToElement(cancelRemoveUser).build().perform(); Thread.sleep(5000);
	cancelRemoveUser.click(); Thread.sleep(5000);
	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
	java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
	String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
	File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\settings\\" + filename);
	FileUtils.copyFile(screenshot, dest);				 
	}
				
	@AfterTest
	public void close_browser() throws Exception {	
	Thread.sleep(3000);
	driver.close();
	System.out.println("Browser closed successgully");
	System.out.println("------------------------------------------------------------------------------------------");
	}
	}
