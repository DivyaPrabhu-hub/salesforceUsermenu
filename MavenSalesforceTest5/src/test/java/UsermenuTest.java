import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UsermenuTest {
	
	public static WebDriver driver;
	static ExtentReports reports;
	static ExtentTest logger;	
	
@BeforeTest
	public static void path(){
	
	String filFilename= new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm'.html'").format(new Date());
	
	String path = ("/Users/divya/Desktop/EXTreport/Report1.html"+filFilename);
			
	reports = new ExtentReports(path);
	
	System.setProperty("webdriver.chrome.driver","//Users//divya//Documents//chromedriver");
	 driver = new ChromeDriver();
	}
	
	@BeforeTest
public static void setupdriver(){
		

		
		logger = reports.startTest("setup driver");
		
		//System.setProperty("webdriver.chrome.driver","//Users//divya//Documents//chromedriver");
		// driver = new ChromeDriver();	
		 logger.log(LogStatus.INFO, "chrome browser launched");
		
		 driver.manage().window().maximize();
		 logger.log(LogStatus.INFO, "window maximized");
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		 driver.get("https://login.salesforce.com/");
		 logger.log(LogStatus.INFO, "salesforce login page opened");
		 
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority =1)
	public static void TC02_LogintoSFDC() 
	 {
	logger = reports.startTest("LogintoSFDC");
		 WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		 username.sendKeys("divyaprabhu@company.com");
		 logger.log(LogStatus.INFO, "Username Entered");
		 
		 WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		 password.sendKeys("sales1984");
		 logger.log(LogStatus.INFO, "password entered as sales1984");
		 
		 WebElement Loginbutton = driver.findElement(By.xpath("//input[@id='Login']"));
		 Loginbutton.click();
		 logger.log(LogStatus.INFO, "login button clicked");
		 
		 reports.endTest(logger);
		 reports.flush();
	 }
	
		 @Test(priority =2)
		 
		 public static void usermenu(){
			 
			 logger = reports.startTest("usermenu");
			 WebElement UsermenuDropdown = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			 UsermenuDropdown.click();
			 logger.log(LogStatus.INFO, "usermenu opened");	
			 
			 reports.endTest(logger);
			 reports.flush();
	 }
	@AfterTest
	public static void teardownDriver()throws InterruptedException{
		 
		 Thread.sleep(5000);
		 System.out.println("close the browser");
		 driver.quit();

	}

}