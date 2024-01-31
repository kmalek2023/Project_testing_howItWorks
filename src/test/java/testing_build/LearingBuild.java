package testing_build;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LearingBuild {
	
	WebDriver driver;

	//Element lists
	By USER_NAME_FIELD = By.xpath("//input[@name='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@type='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@type='submit']");
	By DASHBOARD_HEADER_FIELD =  By.xpath("//strong[contains(text(), 'Dashboard')]");
	
	
	
	//test data or mock data
	String browser ;
	String url;
	String userName;
	String password;
	

	String dashboardValidationText = "Dashboard";
	String userAlertValidationText = "Please enter your user name";
	
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
