package com.testautomation.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.DataProvider;

@CucumberOptions (features = "./features/",
				glue = {"com.testautomation.StepDefinitions"},
				tags = {"@SmokeTest"}) 

public class TestRunner extends AbstractTestNGCucumberTests {
		
	@Override
	@DataProvider (parallel =true)
	public Object [][] scenarios() { 
		return super.scenarios();
	}

}
