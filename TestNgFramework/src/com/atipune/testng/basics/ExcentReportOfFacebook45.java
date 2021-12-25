package com.atipune.testng.basics;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExcentReportOfFacebook45 {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void setupExtentEnv()
	{
		htmlreporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extent-report.html");
		htmlreporter.config().setDocumentTitle("Facebook Log In Report");
		htmlreporter.config().setReportName("Facebook Log In Testing");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HOSTNAME", "lOCALHOST");
		extent.setSystemInfo("Operating System", "Windows10");
		extent.setSystemInfo("Tester Name", "Nanda");
		extent.setSystemInfo("Broswer", "Chrome");
		
	}
	
	
	@BeforeClass
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void register(Method fb) {
	
		test=extent.createTest(fb.getName());
		
	}
  @Test(priority=3)
  public void verifyHomePageTitle() {
	  WebElement arrivalsActual = driver.findElement(By.xpath("//img[@alt='Facebook']"));
	  
	  
	  
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
