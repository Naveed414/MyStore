package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage ;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		super.launchBrowser(browser);
	}

	@Test(groups= { "Smoke" , "Sanity"})
	public void loginTestUsingPropertiesFile() {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("User is Going to click on SignIn");
		loginpage = indexpage.clickOnSignIn();
		Log.info("Enter Username and Password");
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homepage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Success");
		Log.endTestCase("LoginTest");
	}
	
	
	@Test(dataProvider = "LoginCredentials" , dataProviderClass = DataProviders.class , groups= { "Smoke" , "Sanity"})
	public void loginTestUsingDP(String uname , String pswd) {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("User is Going to click on SignIn");
		loginpage = indexpage.clickOnSignIn();
		Log.info("Enter Username and Password");
		homepage=loginpage.login(uname , pswd);
		String actualURL=homepage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Success");
		Log.endTestCase("LoginTest");
	}
	
	@AfterMethod(groups = { "Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	

}
