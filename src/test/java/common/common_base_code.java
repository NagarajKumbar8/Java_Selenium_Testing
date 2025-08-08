package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common_base_code {
	
	public static WebDriver driver=null;  //WebDriver declartion
	
	@BeforeSuite
	public void laucnch_browser() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
	 
	}
	
	@AfterSuite
	public void close_browser() {
		driver.quit();
	}
	
	
	public String getscreenshot(String testcase_name) throws IOException
	{
		
		TakesScreenshot ss= (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File file= new File ("/java_selenium_examples/Screenshot"+testcase_name+".png");
		FileUtils.copyFile(source, file);
		return "/java_selenium_examples/Screenshot//"+testcase_name+".png";
				
		
	}
	
}
