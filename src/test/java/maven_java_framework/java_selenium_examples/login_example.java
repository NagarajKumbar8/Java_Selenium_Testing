package maven_java_framework.java_selenium_examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login_example {
	@Test
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.manage().window().maximize(); // full screen
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.getTitle();
		System.out.println(driver.getTitle());
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("abc@gamil.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// Thread.sleep(5000);
		//WebElement loginsuccess = driver.findElement(By.xpath("//p[ text() = \"You are successfully logged in.\" ]"));
		//System.out.println(loginsuccess.getText());
		
		
		
		
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl= "https://rahulshettyacademy.com/locatorspractice/1";
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
		
		
		
		/*if (loginsuccess.getText().equalsIgnoreCase("You are successfully logged in.")) {
			System.out.println("You are successfully logged in");
		} else {
			System.out.println("Please check login details ");
		}
		*/
		driver.quit();

	}

}
