	package RandD;
	
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class LoginPageLinks {
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser(){
	
	System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}

	@Test
	public void LinksonLoginpage() {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		List <WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Number of links:" +li.size());
		for(WebElement we : li){
		System.out.println(we.getText());
		}
		//Other way to print all links:
		for(int i = 0; i < li.size(); i++){
			System.out.println(li.get(i).getText());
			}
	}

	@AfterTest	
	public void close() {
	driver.close();
	}
	
}