		
		package RandD;
		
		import java.util.List;
		import org.openqa.selenium.By;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class CSURLs {
		WebDriver driver;
		private static String[] links = null;     
		private static int linksCount = 0;
		
		@BeforeTest	
		public void Lauchbrowser(){		
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
			
	}
		
		@Test
		public void CSHomepage() throws InterruptedException {
			driver.navigate().to("https://uat-clientspace.herokuapp.com");		
			driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
			driver.findElement(By.id("password")).sendKeys("@Test1234");
			driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);
			
			System.out.println(driver.getCurrentUrl()); Thread.sleep(3000);
			List<WebElement> alllinks = driver.findElements(By.tagName("a"));     
		    linksCount = alllinks.size();     
		    links= new String[linksCount];     
		    System.out.println("Print All links on a web page :");     
		    for(int i=0;i<linksCount;i++) {     
		    links[i] = alllinks.get(i).getAttribute("href");     
		    System.out.println(alllinks.get(i).getAttribute("href")); 
		     } 
	}
}