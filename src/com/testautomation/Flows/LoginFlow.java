package com.testautomation
.Flows;

import com.testautomation.PageObjects.LoginPage;

public class LoginFlow extends LoginPage {

	public void login(String user, String pass) { 
		click(theLoginButton());
		input(user, theUserNameTxt());
		input(pass, theUserPassTxt());
		click(theLoginButton());
	}
	
	public void cancelLogin () {
		click(theLoginButton());
		click(theCancelButton());
	}

	public void loginButton() {
		click(theLoginButton());
	}
	
	public void validatesLogin() {
		isElementPresent(theMyNotesLabel());
	}
	
	public void selectTheSimpleNote() {
		click(theSimpleNoteLink());
	}
	
	public void witeNote(String text) {
		input(text,theDescriptionTxt());
		click(theSaveButton());
	}
	
	public boolean validateNote(String text) {
	 return isElementPresent(theWrittenText(text));
	}
	
	public void selectTheAnotherNote() {
		click(theAnotherNoteLink());
	}
}
