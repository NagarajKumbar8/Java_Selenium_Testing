package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class common_base_code {
	
	public static WebDriver driver=null;  //WebDriver declartion
	
	@BeforeSuite
	public void laucnch_browser() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterSuite
	public void close_browser() {
		driver.quit();
	}
	
}
