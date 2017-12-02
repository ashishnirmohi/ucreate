		package admindashboard;
		//import org.junit.BeforeClass;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.edge.EdgeDriver;
		//import org.openqa.selenium.edge.EdgeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		//import org.testng.annotations.AfterClass;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Parameters;
		import org.testng.annotations.Test;
		
		public class CrossBrowserScript {
		public WebDriver driver;
		@Parameters("browser")
		@BeforeTest

		public void launchbrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")) {
		System.out.println("Opening Browser firefox");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		}
	
		else if (browser.equalsIgnoreCase("chrome")) { 
		System.out.println("Opening Browser chrome browser");
		System.setProperty("webdriver.chrome.driver", "D://Softwares//crossbrowsertesting//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		}
	
		else if(browser.equalsIgnoreCase("edge")){
		System.out.println("Opening Browser edge browser");
		System.setProperty("webdriver.edge.driver", "D://Softwares//crossbrowsertesting//MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		}
	
		else if(browser.equalsIgnoreCase("opera")){
		System.out.println("Opening Browser opera browser");
		System.setProperty("webdriver.edge.driver", "D://Softwares//crossbrowsertesting//operadriver_win64//operadriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		}
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		}

		@Test
		public void login(){
			driver.findElement(By.id("email")).sendKeys("3391bc@myclientshare.com");
			driver.findElement(By.id("password")).sendKeys("CS@17@testx");
			driver.findElement(By.id("show-sent")).click();
		}
		@AfterTest
		public void close() {
			driver.quit();
		}
		}
