package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class testngexample {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testcase1()
	{
		System.out.println("1 test");
		
	}
	@Test(groups="smoke")
	public void testcase2()
	{
		System.out.println("2 test");
		
	}
	@BeforeTest(groups="smoke")
	public void testcase3() 
	{
		System.out.println("3 test");
		
	}
	@BeforeMethod(timeOut=4000)
	public void testcase4()
	{
		System.out.println("4 test");
		
	}
	
	@Test(dataProvider = "getData", invocationCount=10)
    public void testcase5(String Username, String Password) {
        System.out.println("5 test");
        System.out.println(Username);
        System.out.println(Password);
    }

	
	@DataProvider(name = "getData")
	public Object[][] getData() {
	    return new Object[][] {
	        {"abc@gmail.com", "Password1"},
	        {"abc2@gmail.com", "Password2"},
	        {"abc3@gmail.com", "Password3"}
	    };
	}
	
	//or
	/*
	 * @DataProvider(name = "getData") public Object[][] getData() { // Create a 2D
	 * Object array to hold test data Object[][] data = new Object[3][2];
	 * 
	 * // Set-1 data[0][0] = "abc@gmail.com"; // Fixed typo in email address
	 * data[0][1] = "Password1";
	 * 
	 * // Set-2 data[1][0] = "abc2@gmail.com"; // Fixed typo in email address
	 * data[1][1] = "Password2";
	 * 
	 * // Set-3 data[2][0] = "abc3@gmail.com"; // Fixed typo in email address
	 * data[2][1] = "Password3";
	 * 
	 * return data; // Return the data array }
	 */
    
    
    
	
	
	
}
