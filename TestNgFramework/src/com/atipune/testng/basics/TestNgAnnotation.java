package com.atipune.testng.basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotation {

	
@BeforeSuite
public void beforeSuite()
{
	System.out.println("@BeforeSuite");
}

@AfterMethod
public void afterMethod()
{
	System.out.println("@AfterMethod");
}
	
@AfterSuite
public void afterSuite()
{
	System.out.println("@AfterSuite");
}

@BeforeMethod
public void beforeMethod()
{
	System.out.println("@BeforeMethod");
}

@AfterTest
public void afterTest()
{
	System.out.println("@AfterTest");
}

@AfterClass
public void afterClass()
{
	System.out.println("@AfterClass");
}

@BeforeTest
public void beforeTest()
{
	System.out.println("@BeforeTest");
}

@Test
public void testMethod()
{
	System.out.println("@Test");
}

@Test(priority=-1)
public void anita()
{
	System.out.println("@Anita");
}
@Test(priority=2)
public void vmn()
{
	System.out.println("@vmn");
}

@BeforeClass
public void beforeClass()
{
	System.out.println("@BeforeClass");
}

}
