package com.testautomation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testautomation.Flows.LoginFlow;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.utils.PropertiesFileReader;
import cucumber.api.Scenario;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginGalenFramework extends ExtentReportListener{
	

	@Before
	public void setUp(Scenario scenario ) throws IOException {
		PropertiesFileReader obj= new PropertiesFileReader();
		Properties properties=obj.getProperty();
		startRemoteDriver((properties.getProperty("browser.name")));
		driver().get("http://testapp.galenframework.com");
		System.out.println(scenario.getSourceTagNames());
		scenarioL.set(scenario.getName());
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() throws Throwable{
		driver().close();
		Thread.sleep(4000);
		driver().quit();
		logger = logger.getLogger(LoginGalenFramework.class);
		logger.info("close navegator");
	}
	
	
	@Given("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) {
				new LoginFlow().login(user, pass);
//				ExtentTestManager.logInfo("Browser Opened : "+browserName);
	}

	@Given("the user starts reporting")
	public void the_user_starts_reporting() {
//		test1 = extent.createTest(Feature.class, "Galen Framework Outline");
//		test1=test1.createNode(Scenario.class,"scenario");
//		ExtentTestManager. ("Browser Opened : "+browserName);
		
	}

	@Given("I create the report {string}")
	public void I_create_the_report(String scenario) {
//		test1 = extent.createTest(Feature.class, "Galen Framework Outline");
//		test1=test1.createNode(Scenario.class, scenario);
	}

	
	@Given("I select the simple note")
	public void i_click_on_the_simple_note() throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword("Given"),"I select the simple note");
			new LoginFlow().selectTheSimpleNote();
			testPassed(driver(),test1);
//			test1.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.GREEN));
//			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
			test1 =startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword ("When"), "I create a simple note");
			new LoginFlow().witeNote(text);
			testPassed(driver(),test1);
//			test1.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.GREEN));
//			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
	}
	
	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) throws IOException {
		ExtentTest test1=null;
		try {
			test1 =startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword ("Then"), "I validate the simple note");
//			text="hola";
			Assert.assertTrue(new LoginFlow().validateNote(text));
//			test1.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.GREEN));
//			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception ex) {
			testStepHandle("FAIL",driver(), test1,ex);			
		}	
	}
	
	//****************************************************************
	@Given("I select the another note")
	public void i_select_the_another_note() throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword ("Given"), "I select the another note");
			new LoginFlow().selectTheAnotherNote(); 
			test1.pass(MarkupHelper.createLabel("Test Step has Passed : ", ExtentColor.YELLOW));
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));	
	}

	@When("I create an another note {string}")
	public void i_create_an_another_note(String text2) throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
			test1 =startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword ("When"), "I create an another note");
			new LoginFlow().witeNote(text2);
			testPassed(driver(),test1);
	}

	@Then("I validate the another note {string}")
	public void i_validate_the_another_note(String text2) throws IOException, Throwable {
		ExtentTest test1=null;
//		boolean flag = false; 
		try {
			test1=startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword ("Then"), "I validate the another note");
			text2="hola";
//			flag = (new LoginFlow().validateNote(text2));
			Assert.assertTrue(new LoginFlow().validateNote(text2));
			testPassed(driver(),test1);
		}catch (AssertionError | Exception e) {
			testFail(driver(), test1,e);
		}
//			if (flag==true) {
			
//			}
//			else {
//				testFail(driver(), test1,));
//			}
	}
}
