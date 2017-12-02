	package userinterface;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	public class FeedbackUI {
	public WebDriver driver;
	private By feedback = By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[3]/a");
	private By downloadpdf = By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]/h4/a"); 
	private By quarter = By.xpath("/html/body/section/div[2]/div/div[1]/div/ul/li[2]/a");
	private By headingNPS = By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]/h1");
	private By textsharename = By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]/h3");
	private By numberofreesponde = By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[2]/p");
	
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
	}
	
	@Test (priority=1)
	public void openFeedback() throws InterruptedException {	
	WebElement feedback = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[3]/a"));
	System.out.println("Feedback link displayed: " +feedback.isDisplayed());
	feedback.click(); Thread.sleep(2000); feedback.click();Thread.sleep(4000);			
	}
	
	@Test(priority=2)
	public void getCssValue_feedbackLink_TextFontSize(){
	WebElement feedfntwt = driver.findElement(feedback);
	System.out.println("Font Size, analytics link field is : "	+ feedfntwt.getCssValue("font-size"));
	}
	
	@Test(priority=3)
	public void getCssValue_feedbackLink_TextFontFamily(){
	WebElement feedfntfm = driver.findElement(feedback);
	System.out.println("Font family, analytics link field is : " + feedfntfm.getCssValue("font-family"));
		
	}
	
	@Test(priority=4)
	public void getCssValu_feedbackLink_TextColor() {
	WebElement feedycol = driver.findElement(feedback);
	System.out.println("Font color, analytics link field is : "	+ feedycol.getCssValue("color"));
	}
	
	@Test(priority=5)
	public void getCssValue_feedbackLink_BackgroundColor() {
	WebElement feedybckcol = driver.findElement(feedback); 
	System.out.println("Background color, analytics link field before mouse hover is : "	+ feedybckcol.getCssValue("background-color"));
	Actions action = new Actions(driver);
	action.moveToElement(feedybckcol).perform();
	System.out.println("Background color, aanalytics link field after mouse hover is : "	+ feedybckcol.getCssValue("background-color"));
	System.out.println("------------------------------------------------------------------------------------------");	
	
	}
	
	@Test(priority=6)
	public void getCssValue_feedbackpdf_TextFontSize(){
	WebElement pdffntsz = driver.findElement(downloadpdf);
	System.out.println("Font Size, select share label is : "	+ pdffntsz.getCssValue("font-size"));
	
	}
	
	@Test(priority=7)
	public void getCssValue_feedbackpdf_TextFontFamily(){
	WebElement pdffntfm = driver.findElement(downloadpdf);
	System.out.println("Font family, select share label is : "	+ pdffntfm.getCssValue("font-family"));
	}
	
	@Test(priority=8)
	public void getCssValue_feedbackpdf_TextFontWeight(){
	WebElement pdffntwt = driver.findElement(downloadpdf);
	System.out.println("Font Weight, select share label is : "	+getFontWeight(pdffntwt) );
	
	}
	
	@Test(priority=9)
	public void getCssValue_feedbackpdf_TextColor() {
	WebElement pdfcol = driver.findElement(downloadpdf); 
	System.out.println("Font color, select share label before mouse hover is : "	+ pdfcol.getCssValue("color"));
	Actions actionCS = new Actions(driver);
	actionCS.moveToElement(pdfcol).perform();
	System.out.println("Font color, select share label after mouse hover is : "	+ pdfcol.getCssValue("color"));
	System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=10)
	public void getCssValue_feedbackquarter_TextFontSize(){
	WebElement quarfntsz = driver.findElement(quarter);
	System.out.println("Font Size,  heading panel text field is : "	+ quarfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=11)
	public void getCssValue_feedbackquarter_TextFontFamily(){
	WebElement quarfntfm = driver.findElement(quarter);
	System.out.println("Font family, heading panel text field is : "	+ quarfntfm.getCssValue("font-family"));
		
	}
	
	@Test(priority=12)
	public void getCssValue_feedbackquarter_TextColor() {
	WebElement quarcol = driver.findElement(quarter);
	System.out.println("Font color, heading panel text field is : "	+ quarcol.getCssValue("color"));
	}
	
	@Test(priority=13)
	public void getCssValue_feedbackquarter_TextFontWeight(){
	WebElement quarfntwt = driver.findElement(quarter);
	System.out.println("Font Weight, heading panel text field is "	+getFontWeight(quarfntwt) );
	System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	
	@Test(priority=14)
	public void getCssValue_headingNPS_TextFontSize(){
	WebElement npsfntsz = driver.findElement(headingNPS);
	System.out.println("Font Size, year filer analytics is : "	+ npsfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=15)
	public void getCssValue_headingNPS_TextFontFamily(){
	WebElement npsfntfamy = driver.findElement(headingNPS);
	System.out.println("Font family, year filer analytics is : "	+ npsfntfamy.getCssValue("font-family"));
		
	}
	
	@Test(priority=16)
	public void getCssValue_headingNPS_TextColor() {
	WebElement npscol = driver.findElement(headingNPS);
	System.out.println("Font color, heading panel text field is : "	+ npscol.getCssValue("color"));
	}
	
	@Test(priority=17)
	public void getCssValue_headingNPS_TextFontWeight(){
	WebElement npsfntwt = driver.findElement(headingNPS);
	System.out.println("Font Weight, year filer analytics is : "	+getFontWeight(npsfntwt) );
	System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=18)
	public void getCssValue_shareNameQuarter_TextFontSize(){
	WebElement shrnmfntsz = driver.findElement(textsharename);
	System.out.println("Font Size, month filter analytics is : "	+ shrnmfntsz.getCssValue("font-size"));
	
	}
	
	@Test(priority=19)
	public void getCssValue_shareNameQuarter_TextFontFamily(){
	WebElement shrnmfntfamy = driver.findElement(textsharename);
	System.out.println("Font family, month filter analytics is : "	+ shrnmfntfamy.getCssValue("font-family"));
		
	}
	
	@Test(priority=20)
	public void getCssValue_shareNameQuarter_TextColor() {
	WebElement shrnmcol = driver.findElement(textsharename);
	System.out.println("Font color, heading panel text field is : "	+ shrnmcol.getCssValue("color"));
	}
	
	@Test(priority=21)
	public void getCssValue_shareNameQuarter_TextFontWeight(){
	WebElement shrnmfntwt = driver.findElement(textsharename);
	System.out.println("Font Weight, month filter analytics is : "	+getFontWeight(shrnmfntwt) );
	System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=22)
	public void getCssValue_feedbackrespondes_TextFontSize() {
	WebElement resfntsz = driver.findElement(numberofreesponde);
	System.out.println("Font Size, button Download analytics is : "	+ resfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=23)
	public void getCssValue_feedbackrespondes_TextFontFamily(){
	WebElement resfntfmy = driver.findElement(numberofreesponde);
	System.out.println("Font family, button Download analytics is : "	+ resfntfmy.getCssValue("font-family"));
		
	}
	
	@Test(priority=24)
	public void getCssValue_feedbackrespondes_TextColor() {
	WebElement rescol = driver.findElement(numberofreesponde);
	System.out.println("Font color, button Download analytics is : "	+ rescol.getCssValue("color"));
	}
	
	@Test (priority=25)
	public void getCssvalue_feedbackrespondes_BackgroundColor() {
	WebElement resbckcol = driver.findElement(numberofreesponde);
	System.out.println("Background-color, button Download analytics is : "	+ resbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=26)
	public void getCssValue_feedbackrespondes_FontWeight(){
	WebElement resbtnfntwt = driver.findElement(numberofreesponde);
	System.out.println("Font Weight, button Download analytics is "	+getFontWeight(resbtnfntwt));
	System.out.println("------------------------------------------------------------------------------------------");
	}
	
	
	public String getFontWeight(WebElement element) {
	//Output will return as 400 for font-weight : normal, and 700 for font-weight : bold
	return element.getCssValue("font-weight");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
	Thread.sleep(4000);
	driver.close();
	System.out.println("Browser closed successgully");
	
	}
	
	}
