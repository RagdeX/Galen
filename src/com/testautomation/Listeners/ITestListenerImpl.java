package com.testautomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener {

	public static ExtentReports extent;
	
	public void onStart(ITestContext context) {
		System.out.println("Execution STARTED LISTENER TESTNG"); 
		extent=setUpReport();
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Execution COMPLETED LISTENER TESTNG "); 
		extent.flush();
		System.out.println("Extent Report GENERATED LISTENER TESTG");
	}
	
	public void onTestSuccess(ITestResult context) {
		System.out.println("PASS LISTENER TESTNG"); 
	}
	
	public void onTestFailure(ITestResult context) {
		System.out.println("FAIL LISTENER TESTNG"); 
	}
	
	public void onTestSkipped(ITestResult context) {
		System.out.println("SKIP LISTENER TESTNG"); 
	}
}
