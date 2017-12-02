	package RandD;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;

	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class CSPrintAllLinks {
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
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("analytics@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("@Test1234");
		WebElement submit = driver.findElement(By.id("show-sent"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show-sent")));
		submit.click();	
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));	 
		System.out.println(links.size());
		for (int i = 1; i<links.size(); i=i+1)	{
			
			System.out.println(links.get(i).getText());
			
		}
	}
		@AfterTest
		public void closebrowser() {
		driver.close();
			}
}