	
	package shareregister;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class MailRegisterShare {
	public WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {

		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginEmail() throws InterruptedException {
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("ashishkumar@ucreate.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("RveJvd")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.name("password")).sendKeys("tiebu?3vnmrent");
		driver.findElement(By.className("ZFr60d")).sendKeys(Keys.ENTER); Thread.sleep(4000);		
		driver.findElement(By.className("yW")).click();
		
	
	}
	
	@AfterTest
	public void close(){
	//driver.quit();
	}
}
