package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;


public class AccountCreationPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}
	
	@Test(groups = "Sanity")
	public void verifyCreateAccountPage() {
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountcreationpage=loginpage.createNewAccount("poresw@gmail.com");
		boolean result =accountcreationpage.validateAccountCreatePage();
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getDriver().quit();
	}

}
