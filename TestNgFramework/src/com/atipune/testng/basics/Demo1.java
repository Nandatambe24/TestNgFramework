package com.atipune.testng.basics;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void TC1()
	{
		Reporter.log("running tc1");
	}

	@Test
	public void TC2()
	{
		Reporter.log("running tc2");
	}
	@Test
	public void TC3()
	{
		Reporter.log("running tc3");
	}
}
