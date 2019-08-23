package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import com.testautomation.utils.BaseActions;

public class LoginPage extends BaseActions{
	/*
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
*/
	public By theCancelButton () {
		return By.xpath("//button[@class='btn btn-lg btn-default button-cancel']");
	}
	
	public By theLoginButton () {
		return By.xpath("//button[@class='btn btn-lg btn-primary button-login']");
	}
	
	public By theUserNameTxt () {
		return By.name("login.username");
	}
	
	public By theUserPassTxt () {
		return By.name("login.password");
	}
	
	public By theMyNotesLabel () { 
		return By.xpath("//h2");
	}
	
	public By theSimpleNoteLink() {
		return By.xpath("//div[@class='list-group']/a/h4[contains(text(),'Simple note')]");
	}
	
	public By theAnotherNoteLink() {
		return By.xpath("//div[@class='list-group']/a/h4[contains(text(),'Another note')]");
	}
	
	public By theAddNoteButton() {
		return By.xpath("//button");
	}
	
	public By theTitleTxt() {
		return By.xpath("//input[@type='text']");
	}
	
	public By theDescriptionTxt() {
		return By.name("note.description");
	}
	
	public By theSaveButton() {
		return By.xpath("//button[1]");
	}
	
	public By theNoteCancelButton() {
		return By.name("//button[2]");
	}
	
	public By theWrittenText (String text) {
	return By.xpath("//*[contains(text(),'"+text+"')]");
	}
		
}
