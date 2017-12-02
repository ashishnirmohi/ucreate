	
	package userinterface;	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class LoginpageUI {
	public WebDriver driver;
	private By loginbutton = By.id("show-sent");
	private By forgotlink = By.linkText("Forgot your password?");	
	private By termsconditions = By.linkText("Terms and conditions");	
	private By emailaddress = By.id("email");
	private By password = By.id("password");
	
	@BeforeClass
	public void setUp() {		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Browser opened ");
		System.setProperty("webdriver.gecko.driver", "D://Softwares//crossbrowsertesting//geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
		System.out.println("Successfully passed!, launchbrowser()");
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	// UI testing login Sign in button text field
	@Test(priority=1)
	public void getCssValue_Button_LinkTextColor()  {	
		WebElement csLoginbutton = driver.findElement(loginbutton); 
		System.out.println("Color, button 'Sign In' before mouse hover is : "	+ csLoginbutton.getCssValue("color"));
		Actions action = new Actions(driver);
		action.moveToElement(csLoginbutton).perform();
		System.out.println("Color, button 'Sign In' after mouse hover is : "	+ csLoginbutton.getCssValue("color"));
		
	}
	
	@Test (priority=2)
	public void getCssvalue_ButtonBackgroundColor() {
		WebElement css = driver.findElement(By.xpath("//*[@id='show-sent']"));
		System.out.println("Background-color, button 'Sign In' is : "	+ css.getCssValue("background-color"));
		
	}
	
	@Test(priority=3)
	public void getCssValue_ButtonFontSize() {
		WebElement csLoginbutton = driver.findElement(loginbutton);
		System.out.println("Font Size, button 'Sign In' is : "	+ csLoginbutton.getCssValue("font-size"));
		
	}
	
	@Test(priority=4)
	public void getCssValue_ButtonFontWeight(){
		WebElement csLoginbutton = driver.findElement(loginbutton);
		System.out.println("Font Weight of a button "	+getFontWeight(csLoginbutton) );
		
	}
	
	@Test(priority=5)
	public void getCssValue_ButtonFontFamily(){
		WebElement csLoginbutton = driver.findElement(loginbutton);
		System.out.println("Font family, button 'Sign In' is : "	+ csLoginbutton.getCssValue("font-family"));
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	
	public String getFontWeight(WebElement element) {
		//Output will return as 400 for font-weight : normal, and 700 for font-weight : bold
		return element.getCssValue("font-weight");
	}
	
	// UI testing login form forgot password link text
	@Test(priority=6)
	public void getCssValue_ForgotLinkTextColor()  {	
		WebElement forgotpassword = driver.findElement(forgotlink); 
		System.out.println("Color, link 'Forgot your password?' before mouse hover : "	+ forgotpassword.getCssValue("color"));
		Actions action = new Actions(driver);
		action.moveToElement(forgotpassword).perform();
		System.out.println("Color, link 'Forgot your password?' after mouse hover is : "	+ forgotpassword.getCssValue("color"));	
		
	}
	
	@Test(priority=7)
	public void getCssValue_ForgotLinkFontSize()  {		
		WebElement forgotpassword = driver.findElement(forgotlink); 
		System.out.println("Font size, link 'Forgot your password?' is :"	+ forgotpassword.getCssValue("font-size"));
		
	}
	
	@Test(priority=8)
	public void getCssValue_ForgotLinkFontWeight()  {	
		WebElement forgotpassword = driver.findElement(forgotlink); 
		System.out.println("Font Weight, link 'Forgot your password?' is : "	+getFontWeight(forgotpassword) );
		
	}
	
	@Test(priority=9)
	public void getCssValue_ForgotLinkFontFamily(){
		WebElement forgotpassword = driver.findElement(loginbutton);
		System.out.println("Font family, link 'Forgot your password?' is : "	+ forgotpassword.getCssValue("font-family"));
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	// UI testing login form email text field
	@Test(priority=10)
	public void getCssValue_EmailTextFontColor()  {	
		WebElement emailtextfield = driver.findElement(emailaddress); 
		System.out.println("Color, email text field is : "	+ emailtextfield.getCssValue("color"));
		
	}
	
	@Test(priority=11)
	public void getCssValue_EmailTextFontSize()  {		
		WebElement emailtextfield = driver.findElement(emailaddress); 
		System.out.println("Font size, email text field is : "	+ emailtextfield.getCssValue("font-size"));
		
	}
	
	@Test(priority=12)
	public void getCssValue_EmailTextFontWeight()  {
		WebElement emailtextfield = driver.findElement(emailaddress); 
		System.out.println("Font Weight, email text field is : "	+getFontWeight(emailtextfield));
		
	}
	
	@Test(priority=13)
	public void getCssValue_EmailTextFontFamily(){
		WebElement emailtextfield = driver.findElement(emailaddress);
		System.out.println("Font family, email text field is : "	+ emailtextfield.getCssValue("font-family"));
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	// UI testing login form terms and conditions link text
	@Test(priority=14)
	public void getCssValue_TermsConditionsTextColor()  {
		WebElement TandC = driver.findElement(termsconditions); 
		System.out.println("Color, link 'Terms and conditions' : "	+ TandC.getCssValue("color"));
		
	}
	
	@Test(priority=15)
	public void getCssValue_TermsConditionsFontSize()  {
		WebElement TandC = driver.findElement(termsconditions); 
		System.out.println("Font size, link 'Terms and conditions' : "	+ TandC.getCssValue("font-size"));
		
	}
	
	@Test(priority=16)
	public void getCssValue_TermsConditionstFontWeight()  {
		WebElement TandC = driver.findElement(termsconditions); 
		System.out.println("Font Weight, link 'Terms and conditions' is : " + getFontWeight(TandC) );
		
	}
	
	@Test(priority=17)
	public void getCssValue_TermsConditionsFontFamily(){
		WebElement TandC = driver.findElement(termsconditions);
		System.out.println("Font family, link 'Terms and conditions' is : "	+ TandC.getCssValue("font-family"));
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	// UI testing login form password text field
	@Test(priority=18)
	public void getCssValue_PasswordTextColor()  {
		WebElement passW = driver.findElement(password); 
		System.out.println("Color, password text field is : "	+ passW.getCssValue("color"));
		
	}
	
	@Test(priority=19)
	public void getCssValue_PasswordTextFontSize()  {
		WebElement passW = driver.findElement(password); 
		System.out.println("Font size, password text field is : "	+ passW.getCssValue("font-size"));
		
	}
	
	@Test(priority=20)
	public void getCssValue_PasswordTextFontWeight()  {
		WebElement passW = driver.findElement(password); 
		System.out.println("Font Weight, password text field is : "	+getFontWeight(passW));
		
	}

	@Test(priority=21)
	public void getCssValue_PasswordTextFontFamily(){
		WebElement passW = driver.findElement(password);
		System.out.println("Font family, password text field is : "	+ passW.getCssValue("font-family"));
		System.out.println("------------------------------------------------------------------------------------------");
		
		
	}
		
	@AfterClass
	public void tearDown() {
		driver.close();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
	}
}