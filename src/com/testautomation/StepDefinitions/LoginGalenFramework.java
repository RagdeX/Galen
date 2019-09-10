package com.testautomation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Flows.LoginFlow;
import com.testautomation.utils.BaseClass;
import com.testautomation.utils.PropertiesFileReader;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginGalenFramework extends BaseClass{
	//nueva version develop 2.1	
	@Before
	public void setUp() throws IOException {
		PropertiesFileReader obj= new PropertiesFileReader();
		Properties properties=obj.getProperty();
		startDriver((properties.getProperty("browser.name")));
		driver().get("http://testapp.galenframework.com");
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() throws Throwable{
		driver().close();
		logger = logger.getLogger(LoginGalenFramework.class);
		logger.info("close navegator");
	}
	
	
	@Given("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) {
				new LoginFlow().login(user, pass);
	}

	@Given("I select the simple note")
	public void i_click_on_the_simple_note() {
		ExtentTest logInfo1=null;
		try {
			test1 = extent.createTest(Feature.class, "Galen Framework Outline 1");
			test1=test1.createNode(Scenario.class, "I select the simple note");
			logInfo1=test1.createNode(new GherkinKeyword("Given"), "i_click_on_the_simple_note");
			new LoginFlow().selectTheSimpleNote();
			logInfo1.pass("I select the simple note");
			logInfo1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo1,e);			
		}
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) {
		ExtentTest logInfo1=null;
		try {
			logInfo1=test1.createNode(new GherkinKeyword("When"), "i_create_a_simple_note");
			new LoginFlow().witeNote(text);
			logInfo1.pass("I create a simple note");
			logInfo1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo1,e);			
		}	
	}
	
	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) {
		ExtentTest logInfo1=null;
		try {
			logInfo1=test1.createNode(new GherkinKeyword("Then"), "i_validate_the_simple_note");
			Assert.assertEquals(new LoginFlow().validateNote(text),true);
			logInfo1.pass("I validate the simple note");
			logInfo1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo1,e);			
		}	
	}
	
	//****************************************************************
	@Given("I select the another note")
	public void i_select_the_another_note() {
		ExtentTest logInfo2=null;
		try {
			test2 = extent.createTest(Feature.class, "Galen Framework Outline 2");
			test2=test2.createNode(Scenario.class, "I select the another note");
			logInfo2=test2.createNode(new GherkinKeyword("Given"), "i_select_the_another_note");
			new LoginFlow().selectTheAnotherNote(); 
			logInfo2.pass("I select the another note");
			logInfo2.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo2,e);			
		}	
	}

	@When("I create an another note {string}")
	public void i_create_an_another_note(String text2) {
		ExtentTest logInfo2=null;
		try {
			logInfo2=test2.createNode(new GherkinKeyword("When"), "i_create_an_another_note");
			new LoginFlow().witeNote(text2);
			logInfo2.pass("I create an another note");
			logInfo2.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo2,e);			
		}	
	}

	@Then("I validate the another note {string}")
	public void i_validate_the_another_note(String text2) {
		ExtentTest logInfo2=null;
		try {
			logInfo2=test2.createNode(new GherkinKeyword("Then"), "i_validate_the_another_note");
			//text2="hola";
			Assert.assertEquals(new LoginFlow().validateNote(text2),true);
			logInfo2.pass("I validate the another note");
			logInfo2.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),logInfo2,e);			
		}	
	}
}
