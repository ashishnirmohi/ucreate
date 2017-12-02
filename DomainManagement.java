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

public class DomainManagement {
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
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(2000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
		
	}	
	@Test(priority=1)
	public void domainManagement() throws Exception {
	WebElement setting = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[5]/a"));
	Assert.assertTrue(setting.isDisplayed());
	setting.click(); Thread.sleep(4000); 
	Actions dm = new Actions(driver);
		
	WebElement addDomainLink = driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[1]/button")); 
	Assert.assertTrue(addDomainLink.isDisplayed());
	addDomainLink.click(); 
	DomainManagement.captureScreenShot(driver);
		
	WebElement saveButton = driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/form/button")); 
	Assert.assertTrue(saveButton.isDisplayed());
	dm.moveToElement(saveButton).build().perform(); Thread.sleep(5000);
	saveButton.click(); Thread.sleep(4000); //WORKING		
	DomainManagement.captureScreenShot(driver);
				
	WebElement addDomainField = driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/form/div/div[6]/input"));
	Assert.assertTrue(addDomainField.isDisplayed());
	addDomainField.sendKeys("QA"); Thread.sleep(4000); saveButton.click(); Thread.sleep(4000);
	addDomainField.clear();
	addDomainField.sendKeys("redifmail.com"); Thread.sleep(4000); saveButton.click(); Thread.sleep(4000);  //WORKING
	DomainManagement.captureScreenShot(driver);
		
	WebElement blueThankDomain = driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/span"));
	blueThankDomain.click(); Thread.sleep(4000);  //WORKING
	DomainManagement.captureScreenShot(driver);
	
	WebElement threeDotMenu = driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/form/div/div[6]/div/a/span")); Thread.sleep(4000); 
	Assert.assertTrue(threeDotMenu.isDisplayed());
	dm.moveToElement(threeDotMenu).build().perform(); Thread.sleep(5000);
	threeDotMenu.click(); Thread.sleep(4000);  //WORKING
	DomainManagement.captureScreenShot(driver);
		
	driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/form/div/div[6]/div/ul/li[1]/a")).click(); 
	Thread.sleep(2000); //Edit button click
	addDomainField.clear(); Thread.sleep(4000); 
	addDomainField.sendKeys("REDIFFMAIL.COM"); Thread.sleep(4000); 
	DomainManagement.captureScreenShot(driver);
	saveButton.click(); Thread.sleep(4000);
	blueThankDomain.click(); 
		
	threeDotMenu.click(); Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='domain-management-tab']/div[2]/form/div/div[6]/div/ul/li[2]/a")).click();  //delete domain
	saveButton.click(); Thread.sleep(4000);
	DomainManagement.captureScreenShot(driver);
		
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
