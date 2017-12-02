	package RandD;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;


	public class DropdownTagvalues {
		public WebDriver driver;
		
		@BeforeClass
		public void loginCS() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
		System.out.println("Successfully passed!, launchbrowser()");
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in"); Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		driver.findElement(By.id("show-sent")).click(); Thread.sleep(5000);	
		String title = driver.getTitle();
		System.out.print(title);

		}		

		@Test
		 public void test() 
		  {
		   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		   
		  //Locating element by tagName and store its text in to variable dropdown.
		   String dropdown = driver.findElement(By.tagName("select")).getText();
		   System.out.print("Drop down list values are as bellow :\n"+dropdown);
		  }
		
		@AfterClass
		public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		System.out.println("Browser closed successgully");
		
		}
	}


