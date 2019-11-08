package com.testautomation.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import java.util.HashMap;
import java.util.Map;

import org.apiguardian.api.API;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.utils.BaseClass;

@CucumberOptions (features = "./features/",
				glue = {"com.testautomation.StepDefinitions"},
				tags = {"@SmokeTest"}) 

@API(status = API.Status.STABLE)

public class TestRunner{
	 
	 public static Map<String,ExtentTest> scenarios = new HashMap<>();
	 private TestNGCucumberRunner testNGCucumberRunner;
	
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {    	
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    @Test(dataProvider = "features")    
	    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
	    	
	    	System.out.println(cucumberFeature.toString());
	     	System.out.println("+++" + eventwrapper.toString());
	     	
	     	System.out.println("scenario 1");
//     	    test1 = extent.createTest(Feature.class, cucumberFeature.toString().toUpperCase().replaceAll("^\"|\"$", ""));
//     	    System.out.println(getTest());
     	  
//     	    test1 = test1.createNode(Scenario.class, eventwrapper.toString().toUpperCase().replaceAll("^\"|\"$", ""));
	    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	    }

	    @DataProvider(parallel=true)
	    public Object[][] features() {
	    	if (testNGCucumberRunner == null) {
	            return new Object[0][0];
	        }
	    	System.out.println(testNGCucumberRunner.provideScenarios().length);
//	    	System.out.println(testNGCucumberRunner.provideScenarios(). 
	    	 return testNGCucumberRunner.provideScenarios();
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {    	
	        testNGCucumberRunner.finish();        
	    }
	    
	  
	    
}