package com.testautomation.utils;

import org.openqa.selenium.WebDriver;


public class DriverSetUp extends InheritableThreadLocal<WebDriver>{
	
	private static DriverSetUp instance = new DriverSetUp();
    public static WebDriver getDriver() {
        return instance.get();
    }

    public static void setDriver(WebDriver driver) {
        instance.set(driver);
    } 
 
}
