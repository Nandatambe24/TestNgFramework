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

public class DataProvider12 {
	
	public static WebDriver driver;
	public static WebElement weUserName,weUserPass,weUserConPass,wePreLang,weEngLang,weSecAns,	weSecAnsSel,weSecAnsin;
	@BeforeClass
	public void OpenBrowser()

	 {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		WebElement okButton=driver.findElement(By.xpath("//button[@type=\"submit\"][1]"));
		if(okButton.isDisplayed()) {
			okButton.click();
		}
		
		
	}
	@Test(dataProvider="login-data")
	public void loginform(String tcid,String tcdesc,String uname,String pass,String conpass,String secansin) throws InterruptedException
	
	{
		System.out.println("test case id :"+tcid);
		System.out.println("test case desc :"+tcdesc);
		
		weUserName=driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		weUserName.clear();
		weUserName.sendKeys(uname);
		//Thread.sleep(5000);
		
		weUserPass=driver.findElement(By.xpath("//*[@id=\"usrPwd\"]"));
		weUserPass.clear();
		weUserPass.sendKeys(pass);
		Thread.sleep(3000);

		
		weUserConPass=driver.findElement(By.xpath("//*[@id=\"cnfUsrPwd\"]"));
		weUserConPass.clear();
		weUserConPass.sendKeys( conpass); 
		Thread.sleep(3000);

		
		wePreLang=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div"));
		wePreLang.click();

		
		weEngLang=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[2]/li"));
		weEngLang.click();

		
		weSecAns=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div"));
		weSecAns.click();

		
		
		weSecAnsSel=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span"));
		weSecAnsSel.click();

		
		weSecAnsin=driver.findElement(By.xpath("//input[@type=\"text\" and @size=\"20\"]"));
		weSecAnsin.clear();
		weSecAnsin.sendKeys(secansin);
		
		System.out.println("for validation :"+tcdesc);
		
		     if("TC01".equalsIgnoreCase(tcid))
		    {
			String actual=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[2]/div/div")).getText();
			String Expected="User Name is required.";
			Assert.assertEquals( Expected, actual);
			
		   }else if("TC02".equalsIgnoreCase(tcid))
		
		   {
			String actual=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[3]/div/div/span[1]")).getText();
			String Expected="Password is required.";
			Assert.assertEquals( Expected, actual);	
		   }else if("TC03".equalsIgnoreCase(tcid))
			
			{
				String actual=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[4]/div/div/span[1]")).getText();
				String Expected="Confirm password is required.";
				Assert.assertEquals( Expected, actual);	
		     }else if("TC04".equalsIgnoreCase(tcid))
				
			 {
				String actual=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/div/div")).getText();
				String Expected="Security Answer is Required.";
				Assert.assertEquals( Expected, actual);	
			 }
		
		
		}
        
	
	@DataProvider(name="login-data")
	public Object[][] loginData()
	{
		return new Object[][]  {
			
			new Object[] {"TC01","userblank","","tambe1234","tambe1234","pune"},
			new Object[] {"TC02","blankpass","Nanda1278@24","","tambe1234","pune"},
			new Object[] {"TC03","blankconfpass","Nanda1278@24","tambe1234","","pune"},
			new Object[] {"TC04","blanksecans","Nanda1278@24","tambe1234","tambe1234",""},
			new Object[] {"TC05","blankpassandconfpass","Nanda1278@24","","","pune"},
			new Object[] {"TC06","allfilled","Nanda1278@24","tambe1234","tambe1234","pune"},
               
		};
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
