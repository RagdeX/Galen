package com.testautomation.TestRunner;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleEventWrapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions (features = "./features/",
				glue = {"com.testautomation.StepDefinitions"},
				tags = {"@SmokeTest"}) 

public class TestRunner{
	 private TestNGCucumberRunner testNGCucumberRunner;
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {    	
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    @Test(dataProvider = "features") 
	    @Severity(SeverityLevel.NORMAL)
	    @Description("Test case Descripcion: Validation of Simple note and Another note")
	    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
	    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	    }

	    @DataProvider(parallel=true)
	    public Object[][] features() {
	    	 return testNGCucumberRunner.provideScenarios();
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {    	
	        testNGCucumberRunner.finish();        
	    }
}