package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	

	IndexPage indexpage;
	SearchResultPage searchresultpage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest() {
		indexpage = new IndexPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		boolean result = searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
		
		
	}
	
	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
}
