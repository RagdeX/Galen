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
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.utils.BaseClass;

public class ExtentReportListener extends BaseClass{
	
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest feature = null;
	public static Map<String, ExtentTest> scenarios = new HashMap<>();
	public static ThreadLocal<String> scenarioL = new ThreadLocal<String>();
	
	public static ExtentReports setUpReport() {
		String reportLocation = "./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);		
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report SETUP METHOD");
		report.start();
		extent = new ExtentReports();
		extent.attachReporter(report);		
		extent.setSystemInfo("Application", "Galen Framework");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		System.out.println("INFO SYSTEM METHOD");		
		return extent;
	}
	
	public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) throws IOException {
		switch (teststatus) {
		case "FAIL":{		
					extenttest.fail(MarkupHelper.createLabel("Test Scenario is Failed : La validacion fallo", ExtentColor.RED));			
					extenttest.addScreenCaptureFromPath(captureScreenShot(driver()));
					extenttest.error(throwable.fillInStackTrace());
					Assert.fail("PRUEBA FALLO ASSERT TESTNG",throwable.fillInStackTrace());
			}break;
		case "PASS":{			
					extenttest.pass(MarkupHelper.createLabel("Test Step Is Passed : ", ExtentColor.GREEN));
					extenttest.addScreenCaptureFromPath(captureScreenShot(driver()));
			}break;
		default:{
			}break;
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
	
	public synchronized ExtentTest startScenario(String scenario) throws ClassNotFoundException {
		ExtentTest scenario1=null;
		if(!scenarios.containsKey(scenario)) {
			feature = extent.createTest(new GherkinKeyword("Feature"), "Galen Framework");
			scenario1 = feature.createNode(new GherkinKeyword("Scenario"), scenario);
			scenarios.put(scenario,scenario1);
		} else {
			scenario1 = scenarios.get(scenario);
		}
		return scenario1;
	}
}
