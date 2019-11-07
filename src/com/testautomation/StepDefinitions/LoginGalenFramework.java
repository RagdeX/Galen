package com.testautomation.StepDefinitions;

import java.io.IOException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.testautomation.Flows.LoginFlow;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.utils.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginGalenFramework extends ExtentReportListener{
	
	private BaseClass base;
	
	public LoginGalenFramework(BaseClass base) {
		this.base=base;
	}

	//***********************scenario *****************************************
	@Given("I select the simple note")
	public void i_click_on_the_simple_note() throws IOException {
		base.name=base.name+"1";
		System.out.println("PRUEBA NUMERO: "+base.name);
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword("Given"),"I select the simple note");
			new LoginFlow().selectTheSimpleNote();
			test1.pass("Test Step has Passed");
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) throws IOException {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword("When"),"I create a simple note");
			new LoginFlow().witeNote(text);
			test1.pass("Test Step has Passed");
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}
	
	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
		test1 = startScenario(scenarioL.get());
		test1=test1.createNode(new GherkinKeyword("Then"),"I validate the simple note");
		try {
			new LoginFlow().validateNote(text);
			testStepHandle("PASS",driver(),test1,null);
			}catch(NoSuchElementException ex){
			testStepHandle("FAIL",driver(),test1,ex);
			Assert.fail("pues fallo");
			}
	}
	
	//***********************scenario *****************************************
	@Given("I select the another note")
	public void i_select_the_another_note() throws IOException {
		base.name=base.name+"2";
		System.out.println("PRUEBA NUMERO: "+base.name);
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword("Given"),"I select the another note");
			new LoginFlow().selectTheAnotherNote(); 
			test1.pass("Test Step has Passed");
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}

	@When("I create an another note {string}")
	public void i_create_an_another_note(String text2) throws IOException {
		ExtentTest test1=null;
		try {
			test1 = startScenario(scenarioL.get());
			test1=test1.createNode(new GherkinKeyword("When"),"I create an another note");
			new LoginFlow().witeNote(text2);
			test1.pass("Test Step has Passed");
			test1.addScreenCaptureFromPath(captureScreenShot(driver()));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver(),test1,e);			
		}	
	}

	@Then("I validate the another note {string}")
	public void i_validate_the_another_note(String text2) throws IOException, ClassNotFoundException {
		ExtentTest test1=null;
		test1 = startScenario(scenarioL.get());
		test1=test1.createNode(new GherkinKeyword("Then"),"I validate the another note");
		text2="hola";
		try {
			new LoginFlow().validateNote(text2);
			testStepHandle("PASS",driver(),test1,null);
			}catch(NoSuchElementException ex){
			testStepHandle("FAIL",driver(),test1,ex);
			
			}
		}
}
