	package RandD;	
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import java.net.HttpURLConnection;
	import java.net.URL;	
	import org.junit.AfterClass;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class CSBrokenLinks {
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser(){		
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
		public void loginShare() throws InterruptedException, Exception{
			driver.navigate().to("https://uat-clientspace.herokuapp.com");		
			driver.findElement(By.id("email")).sendKeys("nirmohi.qa@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test1234");
			driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(5000);
	        List<WebElement> links = driver.findElements(By.tagName("a")); 
	        System.out.println("Total links are: " +links.size());
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        for(int i=0;i<links.size();i++)
	        {	
	            WebElement ele= links.get(i);
	            String url=ele.getAttribute("href");
	            verifyLinkActive(url); }	        	        
	}
	
    public String verifyLinkActive(String linkUrl) {
    	try 
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(200000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }      
        } catch (Exception e) {
        	System.out.println(e);
        }
		return linkUrl;		
    }	
    
    @Test(priority=2)
    public void logoutShare() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/a")).click(); Thread.sleep(4000);		
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a")); Thread.sleep(4000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(3000);
		logout.click(); Thread.sleep(3000); //sign-out
		System.out.println("Signout done successfully");		
    }
    
	@AfterClass 	
	public void tearDown() {
		driver.close();
		System.out.println("Browser closed.");
	}
}