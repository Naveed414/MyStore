package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {

	IndexPage indexpage ;
	LoginPage loginpage;
	HomePage homepage ;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}
	
	@Test(groups="Smoke")
	public void wishListTest() {
		Log.startTestCase("wishListTest");
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result =homepage.validateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");

	}
	
	@Test(groups="Smoke")
	public void orderHistoryandDetailsTest() {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result =homepage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");

	}
	
	
	
	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getDriver().quit();
	}

}
