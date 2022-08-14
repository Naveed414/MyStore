package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	
	Action act= new Action();


	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="cgv")
	WebElement terms ;
	
	@FindBy( xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public void clickOnTerm() {
		act.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		act.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
