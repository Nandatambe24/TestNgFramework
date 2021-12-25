package com.atipune.testng.basics;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Grouping2 {


@Test(groups="profile")
public void TC1() {
	Reporter.log("running tc1   :",true);
}
	
@Test(groups="orders")
public void TC2() {
	Reporter.log("running tc2   :",true);
}
@Test(groups="fund")
public void TC3() {
	Reporter.log("running tc3   :",true);
}
@Test(groups="profile")
public void TC4() {
	Reporter.log("running tc4   :",true);
}
@Test(groups="profile")
public void TC5() {
	Reporter.log("running tc5   :",true);
}
@Test(groups="fund")
public void TC6() {
	Reporter.log("running tc6   :",true);
}
	
	
	
	
	
	
	
	
	
	
	
	
}
