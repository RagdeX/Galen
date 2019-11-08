package com.testautomation.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import cucumber.api.Scenario;
import com.testautomation.utils.BaseClass;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener {
	
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
		System.out.println("FAIL FAIL FAIL");
//		try {
//			test1.fail(MarkupHelper.createLabel("MIA MIA : ", ExtentColor.RED));
//			test1.error(context.toString());
//			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void onTestSkipped(ITestResult context) {
		System.out.println("SKIP"); 
	}
	
	public static void testFail(WebDriver driver, ExtentTest extenttest,Throwable throwable) throws IOException  {
		extenttest.fail(MarkupHelper.createLabel("Test Step is Failed : ", ExtentColor.RED));			
		extenttest.error(throwable.fillInStackTrace());
		extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
//		Assert.fail("No se pudo completar la validacion"+ throwable.fillInStackTrace());
	}
	
}
