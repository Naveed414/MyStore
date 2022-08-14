package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
Action act = new Action();
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement userName;
	
	@FindBy(xpath="//input[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(xpath="//button[@name=\"SubmitCreate\"]")
	WebElement createNewAccountBtn;
	
	public HomePage login(String uname , String pswd) {
		act.type(userName, uname);
		act.type(password, pswd);
		act.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname , String pswd){
		act.type(userName, uname);
		act.type(password, pswd);
		act.click(getDriver(), signInBtn);
		act.fluentWait(getDriver(), signInBtn, 10);
	    
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		act.type(emailForNewAccount, newEmail);
		act.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}
