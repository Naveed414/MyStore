package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	Action act= new Action();


	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy( xpath = "//h1[text()=\"Create an account\"]")
	WebElement formTitle ;
	
	
	
	public boolean validateAccountCreatePage() {
		return act.isDisplayed(getDriver(), formTitle);
	}

}
