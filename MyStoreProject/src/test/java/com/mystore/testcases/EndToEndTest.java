package com.mystore.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {


	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCardPage addtocardpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummarypage;
	OrderConfirmationPage orderconfirmationpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}

	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable  {
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("t-shirt");
		addtocardpage = searchresultpage.clickOnProduct();
		addtocardpage.enterQuantity("2");
		addtocardpage.selectSize("L");
		addtocardpage.clickAddToCard();
		orderpage = addtocardpage.clickOnCheckOut();
		loginpage = orderpage.clickOnCheckOut();
		addresspage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage = addresspage.clickOnCheckOut();
		shippingpage.clickOnTerm();
		paymentpage = shippingpage.clickOnProceedToCheckOut();
		ordersummarypage = paymentpage.clickOnPaymentMethod();
		orderconfirmationpage = ordersummarypage.clickOnConfirmOrderBtn();
		String actualMessage = orderconfirmationpage.ValidateOrderConfirmationMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
