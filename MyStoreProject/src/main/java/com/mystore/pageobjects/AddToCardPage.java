package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCardPage extends BaseClass {
	
	Action act= new Action();

	public AddToCardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCardBtn;
	
	@FindBy( xpath = "//i[@class=\"icon-ok\"]//parent::h2")
	WebElement addToCartMessage;
	
	@FindBy( xpath = "//span[contains(text(),\"Proceed to checkout\")]")
	WebElement proceedToCheckOut;
	
	public void enterQuantity(String qty) {
		act.type(quantity, qty);
	}
	
	public void selectSize(String size1) {
		act.selectByVisibleText(size1, size);
	}
	
	public void clickAddToCard() throws Exception {
		act.click(getDriver(), addToCardBtn);
		Thread.sleep(7000);
	}
	
	public boolean validateAddToCard() {
		act.fluentWait(getDriver(), addToCartMessage, 10);
		return act.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() {
		act.JSClick(getDriver(), proceedToCheckOut);
		act.fluentWait(getDriver(), proceedToCheckOut, 10);
		return new OrderPage();
	}
	

}
