package com.testautomation.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public Logger logger;
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test1 = null;
	public static ExtentTest test2 = null;
	
	    public WebDriver driver() {
	        return  DriverSetUp.getDriver();
	    }
	    
	    public void startDriver(String browserName) {
	        WebDriver driver = driver();
			if(browserName.equals("Chrome")) {
	        System.setProperty("webdriver.chrome.driver", ".\\utilities\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        driver = new ChromeDriver(chromeOptions);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        DriverSetUp.setDriver(driver);
			}
			else if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\utilities\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().setSize(new Dimension(1280, 800));
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        DriverSetUp.setDriver(driver);
			}
	    }
	  
		public static ExtentReports setUpReport() {
			String reportLocation = "./Reports/Extent_Report.html";
			report = new ExtentHtmlReporter(reportLocation);		
			report.config().setDocumentTitle("Automation Test Report");
			report.config().setReportName("Automation Test Report");
			report.config().setTheme(Theme.STANDARD);		
			System.out.println("Extent Report location initialized . . .");
			report.start();
			extent = new ExtentReports();
			extent.attachReporter(report);		
			extent.setSystemInfo("Application", "Galen Framework");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			System.out.println("System Info. set in Extent Report");		
			return extent;
		}
		
		public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
			switch (teststatus) {
			case "FAIL":		
				extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				if (driver != null) {
					driver.quit();
				}		
			break;
			case "PASS":			
				extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
				break;
			default:
				break;
			}
		}
	  
}
