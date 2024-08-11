package maven_java_framework.java_selenium_examples;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.common_base_code;


public class selenium_examples 	extends common_base_code {
	@Test
	public void login() throws InterruptedException {
		//use WebDriver so i will support all kind of browser drivers if u use specific browser driver it might not support some feature 
		//WebDriver driver = new ChromeDriver();
		// set implicit wait (It will wait until web objects are loaded into screen)
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");  // open URL
		//or
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize(); // full screen
		driver.navigate().refresh(); 
		driver.getCurrentUrl(); 
		System.out.println(driver.getCurrentUrl()); 
		driver.getTitle(); //get web page title
		System.out.println(driver.getTitle()); //print web title 
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("abc@gamil.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		// Thread.sleep(5000);
		//WebElement loginsuccess = driver.findElement(By.xpath("//p[ text() = \"You are successfully logged in.\" ]"));
		//System.out.println(loginsuccess		.getText());

		
		
		
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl= "https://rahulshettyacademy.com/locatorspractice/";
		//System.out.println("actual url datatype"+actualUrl.getClass().getSimpleName());
		//System.out.println("expected url datatype"+expectedUr.getClass().getSimpleName());
	
		System.out.println("actual url: "+actualUrl);
		System.out.println("expected url: "+expectedUrl);
		
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("logged in success");
		}else {
			System.out.println("login failed");
		}
		
		//or
		
		assertEquals(actualUrl, expectedUrl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"logout-btn\"]")).click();
		System.out.println(driver.findElement(By.xpath("//h1[text()=\"Sign in\"]")).getText());
		System.out.println("signed  out and returned to sign in");
		
		
		
		

		/*if (loginsuccess.getText().equalsIgnoreCase("You are successfully logged in.")) {
			System.out.println("You are successfully logged in");
		} else {
			System.out.println("Please check login details ");
		}
		*/
			

	}
	
	@Test
	public void static_dropdown()
	{
		driver.get("");
		
	}

}
