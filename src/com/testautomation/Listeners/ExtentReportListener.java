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
	public static ExtentTest test1 = null;
	public static Map<String,ExtentTest> scenarios = new HashMap<>();
	public static ThreadLocal<String> scenarioL = new ThreadLocal<String>();
	public static ExtentTest feature =null;  
	
	public static ExtentReports setUpReport() {
		String reportLocation = "./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);		
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD  );
//		report.config().setEncoding("utf-8");
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
	
	public static synchronized void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
		switch (teststatus) {
        case "FAIL":        
            extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));           
            extenttest.error(throwable.fillInStackTrace());
            try {
                extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
                } catch (IOException e) {
                e.printStackTrace();
                }

            if (driver != null) {
            	System.out.println("se cerrara el driver");
            }       
        break;

        case "PASS":            
            extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
            break;

        default:
            break;
        }
    }
		
	public static boolean testStepHandle2(String teststatus,WebDriver driver, ExtentTest extenttest,Throwable throwable) throws IOException {
		boolean flag = false;
		if (teststatus=="FAIL") {
				extenttest.fail(MarkupHelper.createLabel("Test Step is Failed EDGAR: ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
//				flag=false;
				}
				else if(teststatus=="PASS") {
					extenttest.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.GREEN));
					extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
//					flag=true;
				}
		return flag;
	}
			public static void testFail(WebDriver driver, ExtentTest extenttest,Throwable throwable) throws IOException  {
				extenttest.fail(MarkupHelper.createLabel("Test Step is Failed EDGAR : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				Assert.fail("No se pudo completar la validacion"+ throwable.fillInStackTrace());
			}
		
		/*switch (teststatus) {
		case "FAIL":		
			try {
				extenttest.fail(MarkupHelper.createLabel("Test Step is Failed : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
			} catch(IOException e) {
				e.printStackTrace();
				if (driver != null) {
				driver.quit();
			}
	}
			Assert.assertEquals("FAIL",teststatus="FAIL");
		break;
		case "PASS":			
			extenttest.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.GREEN));
			extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
			Assert.assertEquals("PASS", teststatus="PASS");
			break;
		default:
			break;
		}*/
			
	public static synchronized void testPassed (WebDriver driver, ExtentTest test) throws IOException {
		test.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.PINK));
		test.addScreenCaptureFromPath(captureScreenShot(driver));
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
	
	public static synchronized ExtentTest startScenario(String scenario) throws ClassNotFoundException {
	   	 
    	ExtentTest s = null;
//    	ExtentTest t = null;
		
          if(!scenarios.containsKey(scenario)) {
//              extent.createTest(Feature.class, "Mio");
        	   feature = extent.createTest(new GherkinKeyword("Feature"), "Galen FrameWork");
//        	  .createNode(("Scenario"),scenario);
        	  s = feature.createNode(new GherkinKeyword ("Scenario"),scenario);
        	  scenarios.put(scenario,  s);
//              t=t.createNode(Scenario.class,scenario);
//              s=t;
          } else {
              s = scenarios.get(scenario);
          }
          return s ;
	}
}
