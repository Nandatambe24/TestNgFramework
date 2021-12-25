package com.atipune.testng.basics;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public 	static WebDriver driver;
	public  static ExtentHtmlReporter htmlreporter;
	public  static ExtentReports extent;
	public  static ExtentTest test;
	
	@BeforeTest
	public void setupExtentEnv()
	{
		htmlreporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extent-report.html");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("functional report");
		htmlreporter.config().setTheme(Theme.DARK);
			extent=new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("HOST NAME", "LOCALHOST");
			extent.setSystemInfo("OS", "WINDOWS 10");
			extent.setSystemInfo("Tester NAME", "MAHADEV");
			extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterTest
	public void cleanup()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void register(Method method) {
		String testname=method.getName();
			test=extent.createTest(testname);
	}

	@BeforeClass	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Sep_Mrng_2021_JavaAutomation\\TestNGFramework\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyHomePageTitle() {
	  String expectedTitle="Automation Practice Site";
	  String actualTitle=driver.getTitle();
	 Assert.assertEquals(actualTitle, expectedTitle);
 	}  //SUCCESS  //FAILURE  //SKIP
	
	@Test
	public void verifyNewArrivalsDisplayed() {
		boolean arrivalsActual=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-1-1-0\"]/h2")).isDisplayed();	
		Assert.assertTrue(arrivalsActual);
 	}
	
	@Test
	public void verifyFirstBookTitle() {
		String expectedTitleBook="Selenium Ruby";
		String actualTitleBook=driver.findElement(By.xpath("//h3[text()='Selenium Ruby']")).getText();	
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
 	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, "TEST CASE FAILED is"+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED is"+result.getThrowable());
		
		String screenshotpath=ScreenShot.getScreenshot(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
	}else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "TEST CASE SkIPPED:"+result.getName());
		test.log(Status.SKIP, "TEST CASE FAILED is"+result.getThrowable());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, "TEST CASE PASSED:"+result.getName());
	}
	}

	@AfterSuite
	public void browserTeardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
