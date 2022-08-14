package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	Action act= new Action();


	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy( xpath = "//img[@title=\"Faded Short Sleeve T-shirts\"]")
	WebElement productResult;
	
	public boolean isProductAvailable() {
		return act.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCardPage clickOnProduct() {
		act.click(getDriver(), productResult);
		return new AddToCardPage();
	}

}
