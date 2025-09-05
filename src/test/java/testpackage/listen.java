package testpackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listen extends baseclass implements ITestListener 
{
	public WebDriver w;
	ExtentReports extent = extentreport();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();  // to make thread safe

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("test is starting");
		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("test is finished successfully");
		try {
			
			// to get current instance of webdriver
			w = (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance()); 
			
			//getting test method name so that we can save screenshot with correct name 
			String testname = result.getMethod().getMethodName();
			
			//capturing screenshot and getting file path
			String screenshotPath =screenshot(w, testname ).getAbsolutePath();
			
			//attaching screenshot to test report
			thread.get().addScreenCaptureFromPath(screenshotPath); 
			
			//general logger 
			thread.get().log(Status.PASS, "Test is pass ");
			//Most important flushing report to generate report
			
			System.out.println("test is pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace(); // to print error
			System.out.println("failed in try");
		}
		
		extent.flush();			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		try {
			
			// to get current instance of webdriver
			w = (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance()); 
			
			//getting test method name so that we can save screenshot with correct name 
			String testname = result.getMethod().getMethodName();
			
			//capturing screenshot and getting file path
			String screenshotPath =screenshot(w, testname).getAbsolutePath();
			
			//attaching screenshot to test report
			thread.get().addScreenCaptureFromPath(screenshotPath); 
			
			//general logger 
			thread.get().log(Status.FAIL, "Test is failed ");
			thread.get().fail(result.getThrowable());

		
			System.out.println("test Failed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace(); // to print error
			System.out.println("failed in try");
		}
		//Most important flushing report to generate report
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	}
