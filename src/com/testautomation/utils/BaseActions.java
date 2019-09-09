package com.testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions extends BaseClass {

	int time = 240; 
	
	public void click(By by) {
        waitElementToBeClickable(by);
        driver().findElement(by).click();
    }
	
	public void input (String text , By by) { 
		waitElementToBeClickable(by);
		driver().findElement(by).clear();
        driver().findElement(by).sendKeys(text);
	}
	
	  public boolean isElementPresent(By by) {
	        try {
	            return driver().findElement(by).isDisplayed();
	        } catch (Exception e) {
	            System.out.println("NO LO ENCUENTRO");
	        	return false;
	        }
	    }
	
	// Our Waiters 
	
	 public void waitElementToBeClickable(By by) {
	        new WebDriverWait(driver(), time).until(ExpectedConditions.elementToBeClickable(by));
	    }
	 
}
