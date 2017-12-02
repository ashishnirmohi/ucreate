		
		package datadriventest;
		import java.io.File;
		import java.io.FileInputStream;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.concurrent.TimeUnit;		
		import jxl.Workbook;
		import jxl.read.biff.BiffException;
		import org.apache.commons.io.FileUtils;
		import org.openqa.selenium.By;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.Test;
		
		public class LoginDD {
		WebDriver driver;
		jxl.Sheet s;
	
		@Test(priority=1)	
		public void launchBrowser() throws InterruptedException, BiffException, IOException, Exception{		
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://uat-clientspace.herokuapp.com");
		}
		
		@Test(priority=2)	
		public void loginDD() throws BiffException, IOException, InterruptedException {
		FileInputStream fin = new FileInputStream("D:\\Datadriven\\loginddnew.xls"); 
		Workbook wb = Workbook.getWorkbook(fin);
		s = wb.getSheet(0); 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		for (int row = 1; row < s.getRows(); row++) {
		String username = s.getCell(0, row).getContents();
		System.out.println("username is: " +username); Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username); 
		
		String password = s.getCell(1, row).getContents();
		System.out.println("password is: " +password);		
		driver.findElement(By.id("password")).sendKeys(password); 
		LoginDD.captureScreenShot(driver);
		
		driver.findElement(By.id("show-sent")).click(); 
		logoutAdmin();
			}
		}
		
		public void logoutAdmin() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[7]/a")).click(); 
		Actions actionLogout = new Actions(driver); 
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[7]/ul/li[2]/a"));
		actionLogout.moveToElement(logout).build().perform(); Thread.sleep(4000);
		LoginDD.captureScreenShot(driver);
		logout.click(); Thread.sleep(5000); //sign-out
		
		}
	
		public static void captureScreenShot(WebDriver driver) throws IOException{
		java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\login\\Screenshot.jpg"));	
		String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\login\\" + filename);
		FileUtils.copyFile(screenshot, dest);			 
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		}
}
