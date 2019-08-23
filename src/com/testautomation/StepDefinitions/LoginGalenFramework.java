package com.testautomation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.testautomation.Flows.LoginFlow;
import com.testautomation.utils.BaseClass;
import com.testautomation.utils.PropertiesFileReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginGalenFramework extends BaseClass{
		
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
		Thread.sleep(5000);
		driver().close();
//		driver().quit();
		logger = logger.getLogger(LoginGalenFramework.class);
		logger.info("close navegator");
	}
	
	
	@Given("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) {
		new LoginFlow().login(user, pass);
	}

	@Given("I select the simple note")
	public void i_click_on_the_simple_note() {
	    new LoginFlow().selectTheSimpleNote();
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) {
	    new LoginFlow().witeNote(text);
	}
	
	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) {
	    new LoginFlow().theWrittenText(text);
	}
	
	//****************************************************************
	@Given("I select the another note")
	public void i_select_the_another_note() {
		new LoginFlow().selectTheAnotherNote();   
	}

	@When("I create an another note {string}")
	public void i_create_an_another_note(String text2) {
		 new LoginFlow().witeNote(text2);
	}

	@Then("I validate the another note {string}")
	public void i_validate_the_another_note(String text2) {
		new LoginFlow().theWrittenText(text2);
	}
	
	
	
	
	
}
