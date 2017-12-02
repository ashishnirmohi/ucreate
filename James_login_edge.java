package admindashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class James_login_edge {
	public WebDriver driver;
	
@BeforeTest	
	public void launchbrowser() {
		//System.out.println("Opening Browser edge browser");
		System.setProperty("webdriver.edge.driver", "D://Softwares//crossbrowsertesting//MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();	
}

@Test
public void login() {
	driver.get("https://uat-clientspace.herokuapp.com");
	//driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("3391bc@myclientshare.com");
	driver.findElement(By.id("password")).sendKeys("CS@17@testx");
	driver.findElement(By.id("show-sent")).click();	
}

@AfterTest
	public void closewebsite() {
		driver.quit();
		
	}
}
