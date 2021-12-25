package com.atipune.testng.basics;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

	@BeforeClass
	public void openBrowser()
	{
		Reporter.log("open browser",true);
	
	}

	@BeforeMethod
	public void loginToApp()
	{
		Reporter.log("loginTo App",true);
	
	}
	@Test
	public void verifyPN()
	{
		Reporter.log("verify PN",true);
	
	}
	@Test
	public void verifyUserId()
	{
		Reporter.log("verify User Id",true);
	
	}
	@AfterMethod
	public void logoutToApp()
	{
		Reporter.log("logout To App",true);
	
	}
	@AfterClass
	public void clossBrowser()
	{
		Reporter.log("closs Browser",true);
	
	}
}

