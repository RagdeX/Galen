package com.testautomation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;
import com.testautomation.Flows.LoginFlow;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.utils.BaseClass;
import com.testautomation.utils.PropertiesFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class HooksAndBackGround extends ExtentReportListener{
	
	private BaseClass base;
	
	public HooksAndBackGround(BaseClass base) {
		this.base=base;
	}
	
	@Before
	public void setUp(Scenario scenario) throws IOException {
		base.name="0";
		PropertiesFileReader obj= new PropertiesFileReader();
		Properties properties=obj.getProperty();
		startDriver((properties.getProperty("browser.name")));
		driver().get("http://testapp.galenframework.com");
		System.out.println("BEFORE "+scenario.getName());
		scenarioL.set(scenario.getName());
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown(Scenario scenario) throws Throwable{
		System.out.println("AFTER "+scenario.getName());
		driver().close();
		//logger = logger.getLogger(LoginGalenFramework.class);
		//logger.info("AFTER SCENARIO COMPLETED: Close Navegator");
		System.out.println("AFTER SCENARIO COMPLETED: Close Navegator");
	}
	
	@Given("the user login into Galen FrameWork {string} {string}")
	public void the_user_login_into_Galen_FrameWork(String user, String pass) throws ClassNotFoundException {
		new LoginFlow().login(user, pass);
	}
}
