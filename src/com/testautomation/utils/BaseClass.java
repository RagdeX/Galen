package com.testautomation.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public Logger logger;
	    public WebDriver driver() {
	        return  DriverSetUp.getDriver();
	    }
	    
	    public void startDriver(String browserName) {
	        WebDriver driver = driver();
			if(browserName.equals("Chrome")) {
	        System.setProperty("webdriver.chrome.driver", ".\\utilities\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        driver = new ChromeDriver(chromeOptions);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        DriverSetUp.setDriver(driver);
			}
			else if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\utilities\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().setSize(new Dimension(1280, 800));
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        DriverSetUp.setDriver(driver);
			}
	    }
	  	   

}
