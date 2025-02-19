package maven_java_framework.java_selenium_examples;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.management.DescriptorKey;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.common_base_code;
import io.qameta.allure.Description;

public class selenium_examples extends common_base_code {
	private int i;
	
	@Description ("Login Test example")
	//@BeforeTest(alwaysRun=true)
	@Test(invocationCount=5) //runs 5 times 
	public void login() throws InterruptedException {
		// use WebDriver so i will support all kind of browser drivers if u use specific
		// browser driver it might not support some feature
		// WebDriver driver = new ChromeDriver();
		// set implicit wait (It will wait until web objects are loaded into screen)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // open URL
		// or
		//driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize(); // full screen
		driver.navigate().refresh();
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.getTitle(); // get web page title
		System.out.println(driver.getTitle()); // print web title
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("abc@gamil.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		// Thread.sleep(5000);
		// WebElement loginsuccess = driver.findElement(By.xpath("//p[ text() = \"You
		// are successfully logged in.\" ]"));
		// System.out.println(loginsuccess .getText());

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://rahulshettyacademy.com/locatorspractice/";
		// System.out.println("actual url
		// datatype"+actualUrl.getClass().getSimpleName());
		// System.out.println("expected url
		// datatype"+expectedUr.getClass().getSimpleName());

		System.out.println("actual url: " + actualUrl);
		System.out.println("expected url: " + expectedUrl);

		if (actualUrl.equals(expectedUrl)) {
			System.out.println("logged in success");
		} else {
			System.out.println("login failed");
		}

		// or

		assertEquals(actualUrl, expectedUrl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"logout-btn\"]")).click();
		System.out.println(driver.findElement(By.xpath("//h1[text()=\"Sign in\"]")).getText());
		System.out.println("signed  out and returned to sign in");

		/*
		 * if
		 * (loginsuccess.getText().equalsIgnoreCase("You are successfully logged in."))
		 * { System.out.println("You are successfully logged in"); } else {
		 * System.out.println("Please check login details "); }
		 */

	}

	//@AfterTest
	@Test(priority=1) // priority test cases 1 is high
	public void static_dropdown() {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// static dropdown with select tag

		WebElement staticDropdown = driver
				.findElement(By.xpath("//select[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));
		// Select class for handling static dropdowns
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.id("hrefIncAdt")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// while loop for selecting multiple click
		int i = 1;
		while (i < 4) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 3 times click
			i++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// or
		for (i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 3 clicks
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

	@Test (invocationCount = 7, threadPoolSize = 3)
	public void dynamic_dropdown() throws InterruptedException {
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
	public void auto_sugestive_dropdown() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]/a"));

		for (WebElement option : options) // auto sugestive dropdown
		{
			if (option.getText().equalsIgnoreCase("India"))
				;
			{
				option.click();
				System.out.println(driver.findElement(By.id("autosuggest")).getText());

				break;
			}
		}
	}

	@Test
	public void check_box() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
//		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
//		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

		// print number of check boxes present in screen
		driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size();
		System.out.println(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size(), 6);

		// use assertions to validation checkbox
		// not selected checkbox
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

	}
	
	@Description("Calender functionality test")
	@Test
	public void calenders() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
		Thread.sleep(4000);
		// driver.findElement(By.className(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

	}

	@Test
	public void Alerts() throws InterruptedException {

		String alertname = "Nagaraj";
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
	public void Additemstocart() throws InterruptedException {

		String[] items = { "Brocolli", "Cucumber", "Beetroot", "Carrot", "Potato", "Banana", "Orange", "Pomegranate" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.xpath("//div/h4[@class=\"product-name\"]"));

		System.out.println("products" + products.size());

		for (int i = 0; i < products.size(); i++) {
			System.out.println("i val" + i);
			// Cucumber - 1 Kg split and trime get only name

			// int j=0;
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			System.out.println("first item" + formattedName);

			// check whether name u fethced is present in array list or not
			// convert array into array list

			List itemsneeded = Arrays.asList(items);
			System.out.println("itemsneeded val" + itemsneeded);
			System.out.println("check itemneed" + itemsneeded.contains(formattedName));

			// if all the itemas are found it will come out of the loop if J==3 or
			// items.length();
			if (itemsneeded.contains(formattedName)) {
				System.out.println("first item check" + formattedName);
				// j++;
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();

				//Thread.sleep(5000);

			}

			System.out.println("formattedName" + formattedName);
		}
		System.out.println(driver.findElement(By.xpath("(//td/strong)[1]")).getText());

	}

	@Test
	public void impwait() throws InterruptedException {

		selenium_examples addcartcode = new selenium_examples();
		addcartcode.Additemstocart();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		
		driver.findElement(By.xpath("//a[@class=\"cart-icon\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		driver .findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
				
	}
	
	@Test
	public void explicitwait() throws InterruptedException
	{
		selenium_examples classobj = new selenium_examples();
		classobj.impwait();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));   //(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"]")));
		//w.until(ExpectedConditions.
		//Syntax for waits
		//w.until(ExpectedConditions
		
	}
	
	@Description("Move actions testcase")
	@Test
	public void actionsdemo() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		WebElement move=driver.findElement(By.id("mousehover"));
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		driver.findElement(By.xpath("//a[text()=\"Top\"]")).click();
		WebElement Home=driver.findElement(By.xpath("//button[text()=\"Home\"]"));
		a.moveToElement(Home).contextClick().build().perform(); //right click
		Thread.sleep(5000);
		
	}
	
	@Test
	public void windohandls()
	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.xpath("//a[@class=\"blinkingText\"]")).click();
		//Window handle or new tabs
	   Set<String> windows=driver.getWindowHandles(); //parent and child windows 
	   Iterator<String> it= windows.iterator();
	   String parantId = it.next();
	   String childId = it.next();
	   
	   driver.switchTo().window(childId);
	   System.out.println(driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText());
	   //fetch only email usinf split methosd
	   //driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText();
	   String emailid= driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].trim().split(" ")[0];
	  
	   //switch back to mail window
	   driver.switchTo().window(parantId);
	   
	   driver.findElement(By.id("username")).sendKeys(emailid);
	   
		
	}
	
	@Description("Drag and drop exacmple in ingognito browser")
	@Test
	public void frames() throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        
        // Initialize the Chrome driver with options
        WebDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");
		
		//Frames handling
		//driver.switchTo().frame(0); using frame ID
		//driver.switchTo().frame(Webelement) Using Webelent
		//driver.switchTo().frame(targatred locatore) locator
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
		
		driver.findElement(By.id("draggable")).isDisplayed();
		//drag and drop
		
		Actions a = new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//switch back to main page
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void findalllinks()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//find count of links
		driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//find only footer links count
		
		WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
	
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		
		//find links only from the footer first column
		
		WebElement columndriver= footerdriver.findElement(By.xpath("//div[@id=\"gf-BIG\"]/table/tbody/tr/td[1]"));
		
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//open all the links and validate fetching page title 
		
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) 
			{
			// send keys methos used for keyboard evey7gynt
			
			String enter = Keys.chord(Keys.CONTROL, Keys.ENTER);

			columndriver.findElements(By.tagName("a")).get(i).sendKeys(enter);
			}
			//opens all the tabs
		
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> it = tabs.iterator();
			
			// HasNext will check whether the next tabs is present ot not not break the loop
			while (it.hasNext()) 
			{
				driver.switchTo().window(it.next());

				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());

			}	

		}
	
	
	@Test
	public void calendrtest() throws IOException
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String Month="8";
		String Day="8";
		String Year="2025";
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).click();
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).click();
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__month.react-date-picker__inputGroup__input--hasLeadingZero")).click();
		driver.findElement(By.xpath("//input[@name=\"year\"]")).sendKeys(Year);
		driver.findElement(By.xpath("//input[@name=\"day\"]")).sendKeys(Day);
		driver.findElement(By.xpath("//input[@name=\"month\"]")).sendKeys(Month);
		
		//driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
		
		//screenshot
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\nagar\\eclipse-workspace\\java_selenium_examples\\Screenshot\\calendertest.png"));
				
		
		
	}
	
	@Test
	public void scrolling() throws InterruptedException, IOException
	{
		
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//JavascriptExecutor is class used to handle js actions
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		//sum of table values 
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for (int i=0; i<values.size(); i++)
		{
			
			sum= sum+Integer.parseInt(values.get(i).getText());	
			
		}
		System.out.println(sum);
		int total= Integer.parseInt(driver.findElement(By.xpath("//div[@class=\"totalAmount\"]")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		//screenshot
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\nagar\\eclipse-workspace\\java_selenium_examples\\Screenshot\\sum.png"));
		
	}
	
	@Test
	public void httpscertificatehandle() throws IOException //ssl security close
	{
		//class chrome option
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		//screenshot
	
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\nagar\\eclipse-workspace\\java_selenium_examples\\Screenshot\\Screenshot1.png"));
		driver.quit();
	}
	
	
	@Test
	public void findbrokenlink() throws MalformedURLException, IOException
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		//class 
		SoftAssert a=new SoftAssert(); //SoftAssert class
		
		for (WebElement link : links)
		{
			String url= link.getAttribute("href");
			
			HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int code= connection.getResponseCode();	
			System.out.println(code);
			//soft assert
			a.assertTrue(code<400, "this link" +link.getText()+ "is broken with code" +code);
//			or
//			if(code >400)
//			{
//				System.out.println("this link" +link.getText()+"is broken with code"+code);
//				Assert.assertTrue(false);
//			}
			
		}
		
		a.assertAll(); //it will tell failed link or broken one
		
	}
	
	@Test
	public void selenium4feature() throws IOException
	{
		//Relative locators
		//driver.findElement(with(By.tagName("locatore")).above(nameEditBox)));
		
		//invoking multiple tabs or windows  
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		String Parentwindow=it.next();
		String Childwindow=it.next();
		//switch wondow
		driver.switchTo().window(Childwindow);
		driver.get("https://rahulshettyacademy.com");
		String name=driver.findElement(By.xpath("//H2/a[1]")).getText();
		driver.switchTo().window(Parentwindow);
		WebElement namefield=driver.findElement(By.xpath("(//input[@name=\"name\"])[1]"));
		namefield.sendKeys(name);
		//take specific elemet/field or partial screenshot
		File file=namefield.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\nagar\\eclipse-workspace\\java_selenium_examples\\Screenshot\\logo.png"));  // FileUtils is class 
		
		//get hight and width
		System.out.println(namefield.getRect().getDimension().getHeight());
		System.out.println(namefield.getRect().getDimension().getWidth());
		
	}
	
	@Description (" Reverse string and check palindrome")
	@Test
	public void reverseString()
	{
	    String name = "madam";
	    String reverse = "";

	    // Iterate through the string in reverse order
	    for (int i = name.length() - 1; i >= 0; i--)
	    {
	        reverse += name.charAt(i); // Correctly append characters
	    }

	    // Output the reversed string
	    System.out.println("Reversed string: " + reverse);
	    
	    //Check palindrom string 
	    if(name.equalsIgnoreCase(reverse))
	    {
	    	System.out.println("its palindrom");
	    
	    }
	    else {
	    	System.out.println("its not palindrom");
	    }
	}
	
	@Test
	public void searchcommon() throws InterruptedException
	{
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
		WebElement Searchbox= driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
		Searchbox.sendKeys("cakes");
		Searchbox.submit();
		
		List<WebElement> cakes=driver.findElements(By.xpath("//a[contains (.,\"cake\")]"));
		
		//For each loop Iterates loop for each webelement
		for (WebElement cake : cakes)
		{
			String names=cake.getText();
			System.out.println(names);
		}
		//or
		
//		for (int i=0; i<cakes.size(); i++)
//		{
//			WebElement cake= cakes.get(i);
//			String name=cake.getText();
//			
//			System.out.println(name);
//			
//		}
		
	}	

	@Test
	public void prinrepatedchar() {

		        String input = "my name is nagaraj";
		        StringBuilder checked = new StringBuilder(); // To track processed characters

		        // Outer loop to pick each character
		        for (int i = 0; i < input.length(); i++) {
		            char currentChar = input.charAt(i);

		            // Skip already processed characters
		            if (checked.toString().indexOf(currentChar) != -1) {
		                continue;
		            }

		            // Inner loop to count occurrences of the current character
		            int count = 0;
		            for (int j = 0; j < input.length(); j++) {
		                if (input.charAt(j) == currentChar) {
		                    count++;
		                }
		            }

		            // Mark the character as processed
		            checked.append(currentChar);

		            // Print the result
		            System.out.println("Character '" + currentChar + "' repeated " + count + " times.");
		        }
		    }
		

	@Test
	public void revwords()
	{
		String name="My name is nagaraj";
		String[] split= name.split(" ");
		String rev= " ";
		
		for(int i=split.length-1; i>=0; i--)
		{
			rev= rev + split[i] + " " ;	
		}
		System.out.println(rev);
	
	}
	
}







	
