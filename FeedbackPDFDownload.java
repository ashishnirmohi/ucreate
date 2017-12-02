package adminhomepage;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class FeedbackPDFDownload {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() {
		
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Browser opened ");
	}
	
	@Test (priority = 0)
	public void Homepage() throws InterruptedException {
		
		// Home page CS login
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedTitle = "Client Share";
        String actualTitle = "";
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
		System.out.println(driver.getCurrentUrl());
		System.out.println("URL added on browser");
		driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form");
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(3000);
	}
	
	@Test
	public void Feedback()throws InterruptedException{
		// Feedback page testing 	
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[3]/a")).click(); Thread.sleep(5000); //feedback
		driver.findElement(By.xpath("html/body/section/div[2]/div/div[1]/div/ul/li[2]/a")).click(); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/section/div[2]/div/div[1]/div/ul/li[3]/a")).click(); Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='feedback']/div[2]/div[1]/form/div/div[1]/h4/a")).click(); Thread.sleep(5000);		
	    driver.navigate().refresh(); Thread.sleep(3000);	    
	    Actions action = new Actions(driver);
	    WebElement we = driver.findElement(By.xpath(".//*[@id='feedback']/div[2]/div[1]/form/div/div[1]/h1/a/i"));
	    action.moveToElement(we).build().perform();	
	}
	
	@AfterTest
	public void close_browser() {		
		driver.close();
		System.out.println("Browser closed successgully");
	
	}
	
}
