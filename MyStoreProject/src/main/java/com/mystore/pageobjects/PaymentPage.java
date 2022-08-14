package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	Action act= new Action();

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy( xpath = "//a[@class=\"bankwire\"]")
	WebElement bankWireMethod;
	
	@FindBy( xpath = "//a[@title=\"Pay by check.\"]")
	WebElement payByCheckMethod;
	
	public OrderSummaryPage clickOnPaymentMethod() {
		act.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}

}
