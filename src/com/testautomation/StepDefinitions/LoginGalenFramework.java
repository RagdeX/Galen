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
	
	
	@Given("the user navigates to Galen Framework")
	public void the_user_navigates_to_Galen_Framework() {
	}

	@When("the user clicks on Login buttom on Welcome test page")
	public void the_user_clicks_on_Login_buttom_on_Welcome_test_page() {
		new LoginFlow().loginButton();
	}

	@Then("the user clicks on cancel buttom on login page")
	public void the_user_clicks_on_cancel_buttom_on_login_page() {
		new LoginFlow().cancelLogin();
	}

	@Then("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) {
		new LoginFlow().login(user, pass);
	}

	@Then("the user validates the login")
	public void the_user_validates_the_login(){
		
	}
	
	@Given("I click on the another note")
	public void i_click_on_the_another_note() {
	    
	}

	@Given("I select the simple note")
	public void i_click_on_the_simple_note() {
	    new LoginFlow().selectTheSimpleNote();
	}

	@When("I create a simple note {string}")
	public void i_create_a_simple_note(String text) {
	    new LoginFlow().witeNote(text);
	}

	@When("I click on the save button")
	public void i_click_on_the_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I validate the simple note {string}")
	public void i_validate_the_simple_note(String text) {
	    new LoginFlow().theWrittenText(text);
	}

	@When("I write on the desciprion text box Hola soy carmelo de todos los meseros el primero")
	public void i_write_on_the_desciprion_text_box_Hola_soy_carmelo_de_todos_los_meseros_el_primero() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I validate the text from the simple note")
	public void i_validate_the_text_from_the_simple_note() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
}
