package com.atipune.testng.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel3 {

	@Test
	public void TC1() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","D:\\Automation\\driver\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver d =new ChromeDriver();
	d.get("http://www.flipkart.in");
   // d.manage().window().maximize();
    Thread.sleep(5000);
    d.close();


}
	
	
	
	
	
	
}
