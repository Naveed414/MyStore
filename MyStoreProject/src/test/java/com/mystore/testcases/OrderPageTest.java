package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	

	IndexPage indexpage ;
	SearchResultPage searchresultpage ;
	AddToCardPage addtocardpage;
	OrderPage orderpage ;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}
	
	@Test(groups = "Regression")
	public void verifyProductPrice() throws Exception {
		indexpage = new IndexPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		addtocardpage = searchresultpage.clickOnProduct();
		addtocardpage.enterQuantity("2");
		addtocardpage.selectSize("M");
		addtocardpage.clickAddToCard();
		orderpage=addtocardpage.clickOnCheckOut();
		Double unitPrice=orderpage.getUnitPrice();
		Double totalPrice=orderpage.getTotalPrice();
		Double  totalExpectedPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
			
		
	}
	
	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	
	

}
