package com.testautomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener {

	public static ExtentReports extent;
	
	public void onStart(ITestContext context) {
		System.out.println("Execution STARTED"); 
		extent=setUpReport();
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Execution COMPLETED"); 
		extent.flush();
		System.out.println("Extent Report GENERATED. . . .");
	}
	
	public void onTestSuccess(ITestResult context) {
		System.out.println("P A S S"); 
	}
	
	public void onTestFailure(ITestResult context) {
		System.out.println("F A I L"); 
	}
	
	public void onTestSkipped(ITestResult context) {
		System.out.println("S K I P"); 
	}
}
