package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.XLUtility;

public class DataProviders {
	
	XLUtility xlutils ;
	
	
	@DataProvider(name = "LoginCredentials")
	String [][] getLoginCredentials() throws Exception 
	{
		String path = "D:\\Data Driven FrameWork using POM Pattern\\MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx";//System.getProperty("user.dir")+"src/test/resources/testData/LoginData.xlsx";
		    xlutils = new XLUtility(path);
		int rownum = xlutils.getRowCount("LoginCredentials");
		int colcount = xlutils.getCellCount("LoginCredentials", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1 ; i<=rownum;i++) 
		{
			for(int j=0 ; j<colcount;j++) {
				logindata[i-1][j] = xlutils.getCellData("LoginCredentials", i, j);
			}
		}
		return logindata;
		
	}

}
