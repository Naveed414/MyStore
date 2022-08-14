package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action act= new Action();


	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy( xpath = "//span[text()=\"My wishlists\"]")
	WebElement myWishList ;
	
	@FindBy( xpath = "//span[text()=\"Order history and details\"]")
	WebElement orderHistory;
	
	public boolean validateMyWishList() {
		return act.isDisplayed(getDriver(), myWishList);
		
	}
	
	public boolean validateOrderHistory() {
		return act.isDisplayed(getDriver(), orderHistory);
	}
	public String getCurrentURL() {
		String homePageURl = getDriver().getCurrentUrl();
		return homePageURl;
	}
}
