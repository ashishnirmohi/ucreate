package logintestscenarios;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.read.biff.BiffException;

	public class LoginXLSX {
	jxl.Sheet s;
	WebDriver driver;
	
	@BeforeTest	
	public void LauchbrowserLogin() throws InterruptedException{
		System.out.println("-------------------------------------------------------------------------------");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://uat-clientspace.herokuapp.com");
		System.out.println("Successfully passed, LauchbrowserLogin()");
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	@Test
	public void InvitationExCel() throws InterruptedException, BiffException, IOException{
		FileInputStream fin = new FileInputStream("C:\\Users\\HP\\Documents\\login.xls");
		Workbook wb = Workbook.getWorkbook(fin);
		s = wb.getSheet(0);
		for (int row = 1; row < s.getRows(); row++) {
			
		String email = s.getCell(0, row).getContents();
		System.out.println("Email Address is: " + email);	
		driver.findElement(By.id("email")).sendKeys(email); Thread.sleep(3000);
		
		String password = s.getCell(1, row).getContents();
		System.out.println("Email Address is: " + email);	
		driver.findElement(By.id("password")).sendKeys(password); Thread.sleep(2000);
		driver.findElement(By.id("show-sent")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		}
	}
	
		@AfterClass
		public void closeBrowser() {
			driver.close();
		}
			
			}
