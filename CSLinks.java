package RandD;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CSLinks{
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser(){		
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		}
	
	@Test
		public void CSHomepage() throws InterruptedException, Exception{
			driver.navigate().to("https://uat-clientspace.herokuapp.com");		
			driver.findElement(By.id("email")).sendKeys("settingud01@yopmail.com"); Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys("@Test1234"); Thread.sleep(2000); 
			driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Number of Links in the Page is " + links.size());
			for (int i = 1; i<links.size(); i=i+1) {
			System.out.println("Name of Link# " +links.get(i).getText());
			
			}
		}	
	
	@AfterTest
	public void closebrowser() throws InterruptedException {
			System.out.println("Browser closed"); Thread.sleep(2000);
			driver.close();
	}
}