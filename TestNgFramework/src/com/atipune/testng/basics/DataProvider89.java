package com.atipune.testng.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider89 {
	
	
	public static WebDriver d;
	 public static WebElement  WebUsername ,Webpass,WebConPass,WebPreLang,WebQyes,WebLangEng,WebSelAns,WebSec;
		
		@BeforeClass
		public void opernBrowser() 
		{
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\driver\\chromedriver.exe\\" );
			d=new ChromeDriver();
			d.get("https://www.irctc.co.in/nget/profile/user-registration");
		    WebElement wb=d.findElement(By.xpath("//button[@type=\"submit\"]"));
		    if(wb.isDisplayed()) {
		    wb.click();
		}
		    
		}
		//@Test(dataProvider="login-data")
		
		@Test(dataProvider="login-data")
		public void loginform(String tcid,String tcdesc, String username, String pass, String conpass,String fun) throws InterruptedException
		{
			
			System.out.println("Test Case id:"+tcid);
			System.out.println("Test Case desc:"+tcdesc);
			
			WebUsername=d.findElement(By.xpath("//input[@type=\"text\"]"));
			WebUsername.clear();
			WebUsername.sendKeys(username);
			Thread.sleep(3000);
			Webpass=d.findElement(By.xpath("//input[@formcontrolname=\"usrPwd\"]"));
			Webpass.clear();
			Webpass.sendKeys(pass);
			Thread.sleep(3000);
			
			WebConPass=d.findElement(By.xpath("//input[@id=\"cnfUsrPwd\"]"));
			WebConPass.clear();
			WebConPass.sendKeys(conpass);
			
			WebPreLang=d.findElement(By.xpath("//div[@style=\"width: 100%;\"]"));
			WebPreLang.click();
			
			WebLangEng =d.findElement(By.xpath("//li[@role=\"option\"]"));
			WebLangEng.click();
			
	         WebQyes=d.findElement(By.xpath("(//div[@style=\"width: 100%;\"])[2]"));
			WebQyes.click();
			
			WebSelAns=d.findElement(By.xpath("//span[text()='What is your pet name?']"));
			WebSelAns.click();
			
			WebSec=d.findElement(By.xpath("(//input[@type=\"text\"])[4]"));
			WebSec.clear();
			WebSec.sendKeys(fun);
			System.out.println("from validation passwed wit:"+tcdesc);
			
			if("TC01".equalsIgnoreCase(tcid)) 
			{
				String actual=d.findElement(By.xpath("//span[text()='User Name is required.']")).getText();
				String Expected="User Name is required.";
				Assert.assertEquals(Expected, actual);
				
			}else if("TC02".equalsIgnoreCase(tcid))
			{
				String actual=d.findElement(By.xpath("//span[text()='User Name is required.']")).getText();
				String Expected="Password is required.";
				Assert.assertEquals(Expected, actual);
				
			}else if("TC03".equalsIgnoreCase(tcid))
			{
				
				String actual=d.findElement(By.xpath("//span[text()='Confirm password is required.']")).getText();
				String Expected="Confirm password is required.";
				Assert.assertEquals(Expected, actual);
			}
			else if("TC04".equalsIgnoreCase(tcid))
			{
				String actual=d.findElement(By.xpath("//span[text()='Security Answer is Required.']")).getText();
				String Expected="Security Answer is Required.";
				Assert.assertEquals(Expected, actual);
				
			}
			
			
		
		}
		
		@DataProvider(name="login-data")
	public Object[][] loginData()
		{
			
			return new Object[][] 
	{
				
				new Object[] {"TC01","userblank", "","Atipune@123","Atipune@123","Ati"},
				new Object[] {"TC02","blankpassword","Atipune66012","","Atipune@123","Ati"},
				new Object[] {"TC03","blankconfpass","Atipune66012","Atipune@123","","Ati"},
				new Object[] {"TC04","blanksecans","Atipune66012","Atipune@123","Atipune@123",""},
				new Object[] {"TC05","blankpassandconfpass","Atipune66012","","","ati"},
				new Object[] {"TC06","allfilled","Atipune66012","Atipune@123","Atipune@123","Ati"},
			          };

			}
		
		
		
		@AfterClass
		public void closeBrowser()
		{
			
			d.close();
			
		}
	
	
	
	
	
	
	
	
	
	

}
