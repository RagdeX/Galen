package com.testautomation.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.TakesScreenshot;


public class BaseClass {
	
	public String StepInfo;
	public String name;
	public Logger logger;
	
	    public static WebDriver driver() {
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
	  
	    public void startDriver2(String browserName) throws IOException{
            WebDriver driver = driver();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
            getChromeOptions());
            DriverSetUp.setDriver(driver);
        }

	    public ChromeOptions getChromeOptions() {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("screenshot");
            //options.addArguments("--incognito");
            //options.addArguments("headless");
            //options.addArguments("privileged")
            //options.addArguments("disable-gpu")
            options.addArguments("no-sandbox");
            options.addArguments("disable-infobars");
            options.setCapability("enableVideo",true);
            return options;
        }
	 
	    public void takeScreenshot(WebDriver driver, String nameTest) {
	    	Allure.addAttachment(nameTest, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
	    }
}
