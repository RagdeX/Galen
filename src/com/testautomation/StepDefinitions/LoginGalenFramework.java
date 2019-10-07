package com.testautomation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.testautomation.Flows.LoginFlow;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.utils.PropertiesFileReader;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;


public class LoginGalenFramework extends ExtentReportListener{
	
	
	
	@Before
	public void setUp(Scenario scenario) throws IOException {
		PropertiesFileReader obj= new PropertiesFileReader();
		Properties properties=obj.getProperty();
		startDriver((properties.getProperty("browser.name")));
		driver().get("http://testapp.galenframework.com");
		System.out.println("BEFORE "+scenario.getName());
		scenarioL.set(scenario.getName());
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() throws Throwable{
		driver().close();
		logger = logger.getLogger(LoginGalenFramework.class);
		logger.info("SCENARIO COMPLETED: Close Navegator");
	}
	
	
	@Given("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) {
				new LoginFlow().login(user, pass);
	}

	//***********************scenario *****************************************
	@Given("I select the simple note")
	public void i_click_on_the_simple_note() {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1= test1.createNode(("Given"),"I select the simple note");
			new LoginFlow().selectTheSimpleNote();
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1 = test1.createNode(("When"),"I create a simple note");
			new LoginFlow().witeNote(text);
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}
	
	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(("Then"),"I validate the simple note");
			Assert.assertTrue(new LoginFlow().validateNote(text));
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}
	
	//***********************scenario *****************************************
	@Given("I select the another note")
	public void i_select_the_another_note() {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1= test1.createNode(("Given"),"I select the another note");
			new LoginFlow().selectTheAnotherNote(); 
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}

	@When("I create an another note {string}")
	public void i_create_an_another_note(String text2) {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(("When"),"I create an another note");
			new LoginFlow().witeNote(text2);
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}

	@Then("I validate the another note {string}")
	public void i_validate_the_another_note(String text2) {
		ExtentTest test1=null;
		try {
		test1 = startScenario(scenarioL.get());
			test1=test1.createNode(("Then"),"I validate the another note");
			text2="hola";
			Assert.assertTrue(new LoginFlow().validateNote(text2));
			//test1.pass("Test Step Has Passed");
			testStepHandle("PASS",driver(),test1,null);
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}
	
	
}
