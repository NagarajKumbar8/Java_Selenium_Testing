package maven_java_framework.java_selenium_examples;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.common_base_code;


public class selenium_examples 	extends common_base_code {
	private int i;

	@Test
	public void login() throws InterruptedException {
		//use WebDriver so i will support all kind of browser drivers if u use specific browser driver it might not support some feature 
		//WebDriver driver = new ChromeDriver();
		// set implicit wait (It will wait until web objects are loaded into screen)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// static dropdown with select tag
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));
		//Select class for handling static dropdowns
		Select dropdown =new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.id("hrefIncAdt")).click(); 
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//while loop for selecting multiple click
		int i=1;
		while(i<4)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); // 3 times click
			i++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//or
		for(i=1; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //3 clicks
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
	}

	@Test
	public void dynamic_dropdown() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"IXG\"]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value=\"BLR\"])[2]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());
		
		
		
	}
	
	
	@Test
	public void auto_sugestive_dropdown() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(3000);
		
		List<WebElement> options= driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]/a"));
		
		for (WebElement option : options) //auto sugestive dropdown 
		{
			if (option.getText().equalsIgnoreCase("India"));
			{
				option.click();
				System.out.println(driver.findElement(By.id("autosuggest")).getText());
				
				break;
			}	
		}	
	}
	
	@Test
	public void check_box() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
//		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
//		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		//print number of check boxes present in screen
		driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size();
		System.out.println(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size(), 6);
		
		//use assertions to validation checkbox
		//not selected checkbox
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
			
	}
	
	@Test
	public void calenders() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
		Thread.sleep(4000);
		//driver.findElement(By.className(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		System.out.println( driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println( driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
	}
	
	@Test
	public void Alerts() throws InterruptedException
	{
		
		String alertname="Nagaraj";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(alertname);
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); 
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys(alertname);
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.findElement(By.id("confirmbtn")).getText());
		driver.switchTo().alert().dismiss();
		
		
	}
	
	@Test
	public void Additemstocart () throws InterruptedException
	{
		String[] items= {"Cucumber","Cauliflower","Tomato","Potato","Banana"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> products=driver.findElements(By.cssSelector(".product-name"));
	
		for (int i=0; i<products.size(); i++);
		{
			//Cucumber - 1 Kg split and trime get only name  
			
			//int j=0;
			String[] Name=products.get(i).getText().split("-");
			String formattedName=Name[0].trim();
			
			//check whether name u fethced is present in array list or not
			//convert array into array list 
			
			List itemsneeded=Arrays.asList(items);
			
			 //if all the itemas are found it will come out of the loop  if J==3 or items.length();
			if(itemsneeded.contains(formattedName))
			{
				//j++;
				driver.findElements(By.xpath("//button[@type=\"button\"]")).get(i).click();
				
				Thread.sleep(5000);
				
//				if(j==items.length())
//				{
//					break;
//				}
				
			} 
			System.out.println(driver.findElement(By.xpath("(//td/strong)[1]")).getText());
		}
	
		
	}
			
	}
	
	
		
	
	
	
	
	
	
	
