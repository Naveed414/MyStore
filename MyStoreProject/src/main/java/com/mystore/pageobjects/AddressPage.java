package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	Action act= new Action();

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy( xpath="//span[text()=\"Proceed to checkout\"]")
	WebElement proceedToCheckOut;
	
	public ShippingPage clickOnCheckOut() {
		act.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}

}
