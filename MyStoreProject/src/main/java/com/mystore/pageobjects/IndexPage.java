package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action act= new Action();

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath = "//a[@class=\"login\"]")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class=\"logo img-responsive\"]")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	public LoginPage clickOnSignIn() {
		act.fluentWait(getDriver(), signInBtn, 10);
		act.click(getDriver(), signInBtn);
		return new LoginPage() ;
	}
	
	public boolean validateLogo() {
		return act.isDisplayed(getDriver(), myStoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		act.type(searchProductBox, productName);
		act.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}
	
	
	

}
