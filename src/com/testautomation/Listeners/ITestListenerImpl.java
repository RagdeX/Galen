package com.testautomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.testautomation.utils.BaseClass;

public class ITestListenerImpl extends BaseClass implements ITestListener {

	public static ExtentReports extent;
	
	public void onStart(ITestContext context) {
		System.out.println("Execution started"); 
		extent=setUpReport();
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Execution completed"); 
		extent.flush();
		System.out.println("Generated report. . . .");
	}
	
	public void onTestSuccess(ITestResult context) {
		System.out.println("PASS"); 
	}
	
	public void onTestFailure(ITestResult context) {
		System.out.println("FAIL"); 
	}
	
	public void onTestSkipped(ITestResult context) {
		System.out.println("SKIP"); 
	}
}
