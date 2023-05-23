package com.yatratrip.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;



public class Listener extends ExtentReport implements ITestListener{
	public static WebDriver driver;
	 TakeScreenShot takescreentshot =new TakeScreenShot();
	public void onStart(ITestContext context) {	
		Log.info("onStart method started "+context.getName());
		System.out.println("onStart method started ");
	}

	public void onFinish(ITestContext context) {
		Log.info("onFinish method started "+context.getName());
		System.out.println("onFinish method started");
	}
	
		public void onTestStart(ITestResult result) {
				
			Log.info("New Test Started "+result.getName());
			System.out.println("New Test Started " +result.getName());
			test = extent.createTest(result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			Log.info("onTestSuccess Method "+result.getName());
			System.out.println("onTestSuccess Method " +result.getName());
			if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, "test is sccessfull tested" + result.getName());
			}
		}

		public void onTestFailure(ITestResult result) {
			Log.info("onTestFailure Method "+result.getName());
			System.out.println("onTestFailure Method " +result.getName());
			if (result.getStatus()==ITestResult.FAILURE) {
			takescreentshot.takeScreenShot(result.getName());
			}
		}

		public void onTestSkipped(ITestResult result) {
			Log.info("onTestSkipped Method "+result.getName());
			System.out.println("onTestSkipped Method " +result.getName());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			Log.info("onTestFailedButWithinSuccessPercentage "+result.getName());
			System.out.println("onTestFailedButWithinSuccessPercentage " +result.getName());
		}
	

}
