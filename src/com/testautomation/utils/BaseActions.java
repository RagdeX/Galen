package com.testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions extends BaseClass {

	int time = 20; 
	
	public void click(By by) {
        waitElementToBeClickable(by);
        driver().findElement(by).click();
    }
	
	public void input (String text , By by) { 
		waitElementToBeClickable(by);
		driver().findElement(by).clear();
        driver().findElement(by).sendKeys(text);
	}
	
	public void isElementPresent(By by) throws NoSuchElementException {
		  driver().findElement(by);      
	    }
	
	 public void waitElementToBeClickable(By by) {
	        new WebDriverWait(driver(), time).until(ExpectedConditions.elementToBeClickable(by));
	    }
	 
}
