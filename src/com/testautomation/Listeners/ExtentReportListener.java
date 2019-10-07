package com.testautomation.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.utils.BaseClass;


public class ExtentReportListener extends BaseClass{
	
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test1 = null;
	public static ExtentTest test2 = null;
	public static Map<String, ExtentTest> scenarios = new HashMap<>();
	public static ThreadLocal<String> scenarioL = new ThreadLocal<String>();
	
	public static ExtentReports setUpReport() {
		String reportLocation = "./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);		
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report SET UP . . .");
		report.start();
		extent = new ExtentReports();
		extent.attachReporter(report);		
		extent.setSystemInfo("Application", "Galen Framework");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		System.out.println("INFO SYSTEM Extent Report");		
		return extent;
	}
	
	public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
		switch (teststatus) {
		case "FAIL":		
			extenttest.fail(MarkupHelper.createLabel("Test Step Is Failed : ", ExtentColor.RED));			
			extenttest.error(throwable.fillInStackTrace());
			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
			} catch(IOException e) {
				e.printStackTrace();
			}
			if (driver != null) {
				driver.quit();
			}		
		break;
		case "PASS":			
			extenttest.pass(MarkupHelper.createLabel("Test Step Is Passed : ", ExtentColor.GREEN));
			break;
		default:
			break;
		}
	}
	
	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Reports/Screenshots/"+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}
	
	
	public synchronized ExtentTest startScenario(String scenario) {
		ExtentTest t = null;
		if(!scenarios.containsKey(scenario)) {
			t =  extent.createTest(Feature.class, scenario);
			
			scenarios.put(scenario,  t);
		} else {
			t = scenarios.get(scenario);
		}
		return t;
	}
}
