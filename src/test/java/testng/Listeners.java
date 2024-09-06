package testng;

import org.testng.ITestListener;
import org.testng.ITestResult;

//itestlistner a interface which implements Testng listners
public class Listeners implements ITestListener
{
	
	@Override
	    public void onTestStart(ITestResult result) 
	 	{
	        System.out.println("Test Started: ");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) 
	    {
	        System.out.println("Test Passed: " +result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) 
	    {
	        System.out.println("Test Failed: " +result.getName());
	    }

}
