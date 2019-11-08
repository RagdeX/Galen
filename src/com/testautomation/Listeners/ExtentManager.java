/*package com.testautomation.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.utils.BaseClass;
//import com.w2a.cucumber.zoho.steps.BaseSteps;
//import com.w2a.zoho.utilities.DriverManager;

 
  
public class ExtentManager extends BaseClass{
 
	static ExtentReports extent;
    static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	
        	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("./Reports/"+ fileName));
//        	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/Extent_Report_NUEVO.html");
 	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
 	        htmlReporter.config().setChartVisibilityOnOpen(true);
 	        htmlReporter.config().setTheme(Theme.STANDARD);
 	        htmlReporter.config().setDocumentTitle(fileName);
 	        htmlReporter.config().setEncoding("utf-8");
 	        htmlReporter.config().setReportName(fileName);
// 	        htmlReporter.start();
 	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Rahul Arora");
	        extent.setSystemInfo("Organization", "Way2Automation");
	        extent.setSystemInfo("Build no", "W2A-1234");
        }
        return extent;
    }
  
   
    public static String screenshotPath;
	public static String screenshotName;
	static int i=0;
	
	public static void captureScreenshot() {
		i = i + 1;
		File scrFile = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_"+i+".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}*/