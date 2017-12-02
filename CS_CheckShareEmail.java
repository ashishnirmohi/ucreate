
	package admindashboard;
	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class CS_CheckShareEmail {
	public WebDriver driver;

	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	
	}
	
	@Test(priority=1)
	public void Gmail_OTP_Authentication() throws Exception {
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("nirmohi.qa@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("RveJvd")).sendKeys(Keys.ENTER); Thread.sleep(4000);
		driver.findElement(By.name("password")).sendKeys("tiebu?3vnmrent"); 
		driver.findElement(By.className("ZFr60d")).sendKeys(Keys.ENTER); Thread.sleep(4000);		
		driver.findElement(By.className("yW")).click(); Thread.sleep(20000);
		
	}
	@AfterTest
	public void TearDown() {
		driver.close();
	}
}
