package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {

	Action act= new Action();

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

		@FindBy(xpath = "//span[text()=\"I confirm my order\"]")
		WebElement confirmOrderBtn;
		
		public OrderConfirmationPage clickOnConfirmOrderBtn() {
			act.click(getDriver(), confirmOrderBtn);
			return new OrderConfirmationPage();
		}

		

}
