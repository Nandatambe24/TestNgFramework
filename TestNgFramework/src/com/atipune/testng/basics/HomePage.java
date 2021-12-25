package com.atipune.testng.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {

	WebDriver driver;
	@BeforeMethod	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\Automation\\\\driver\\\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
	}
	@AfterMethod	
	public void closeBrowser()
	{
		driver.quit();
	}
	 @Test(priority=12,description="This test case is used to verify home page title is equal to expected or not")
	public void verifyHomePageTitle() {
	  String expectedTitle="Automation Practice Site";
	  String actualTitle=driver.getTitle();
	 Assert.assertEquals(actualTitle, expectedTitle);
 	}
	

    	 @Test(enabled=false,description="TestCase01 = checking count of new arrival items equal to the expected count")
		public void isPageWithThreeArivals() {
	    int toalSizeofArrivalItems =driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]]")).size();
		int expectedArivalSize=3;
		Assert.assertEquals(toalSizeofArrivalItems,expectedArivalSize);
		 }
		@Test(priority=1,description="TestCase1 = checking Wether homepage image1 is navigable or not , Verifying it by navigated Page title Name")
		public void homePageImage1_Navigable() {
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]/img")).click();
		String actualtitleNameAfterImage1Navigated=driver.getTitle();
		String ExpectedtitleNameAfterImage1Navigated= "Selenium Ruby – Automation Practice Site";
		Assert.assertEquals(actualtitleNameAfterImage1Navigated, ExpectedtitleNameAfterImage1Navigated);
		}
		@Test(priority=2,description="TestCase2 = checking Wether homepage image2 is navigable or not , Verifying it by navigated Page title Name")
		public void homePageImage2_Navigable() {
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")).click();
		String actualtitleNameAfterImage2Navigated=driver.getTitle();
		String ExpectedtitleNameAfterImage2Navigated= "Thinking in HTML – Automation Practice Site";
		Assert.assertEquals(actualtitleNameAfterImage2Navigated,  ExpectedtitleNameAfterImage2Navigated);
		}
		
		
		@Test(priority=3,description="TestCase3 = checking Wether homepage image3 is navigable or not , Verifying it by navigated Page title Name")
		public void homePageImage3_Navigable() {
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
		String actualtitleNameAfterImage3Navigated=driver.getTitle();
		String ExpectedtitleNameAfterImage3Navigated= "Mastering JavaScript – Automation Practice Site";
		Assert.assertEquals(actualtitleNameAfterImage3Navigated,  ExpectedtitleNameAfterImage3Navigated);
		
		}
      
		
		@Test(priority=5,description="TestCase5 = checking Wether Description after clicking image1 is as expected or not , Verifying it by Description given in image 1")
		public void homePageImage1_Description() {
			
		driver.get("http://practice.automationtesting.in/product/selenium-ruby/");
		String actualtitleNameAfterImage1Description=driver.findElement(By.xpath("//*[@id=\"tab-description\"]/p")).getText();
		String ExpectedtitleNameAfterImage1Description= "The Selenium WebDriver Recipes book is a quick problem-solving guide to automated testing web applications with Selenium WebDriver. It contains hundreds of solutions to real-world problems, with clear explanations and ready-to-run test scripts you can use in your own projects.";
		Assert.assertEquals(actualtitleNameAfterImage1Description, ExpectedtitleNameAfterImage1Description);
		}
		
		@Test(priority=6,description="TestCase6 = checking Wether Description after clicking image1 is as expected or not , Verifying it by Description given in image 1")
		public void homePageImage2_Description() {
			
		driver.get("http://practice.automationtesting.in/product/thinking-in-html/");
		String actualtitleNameAfterImage2Description=driver.findElement(By.xpath("//*[@id=\"tab-description\"]/div/div/div/p")).getText();
		String ExpectedtitleNameAfterImage2Description= "This book provides you with an intermediate knowledge of HTML. Instead of wandering through loads of theory, we will understand HTML practically so that we can understand the markup of a web page. We have used Notepad for the examples in this book. Alternatively, you can also use Notepad++ or any advanced editor. All you need to do is copy the code and paste it into Notepad. Upon execution, you will get the output as depicted in the screenshots. Screenshots are provided for each piece of sample code.";
		Assert.assertEquals(actualtitleNameAfterImage2Description, ExpectedtitleNameAfterImage2Description);
		}
		
		
		@Test(priority=7,description="TestCase7 = checking Wether Description after clicking image1 is as expected or not , Verifying it by Description given in image 1")
		public void homePageImage3_Description() {
			
		driver.get("http://practice.automationtesting.in/product/mastering-javascript/");
		String actualtitleNameAfterImage3Description=driver.findElement(By.xpath("//*[@id=\"tab-description\"]/div/div/div/p")).getText();
		String ExpectedtitleNameAfterImage3Description= "It would seem that everything that needs to be written about JavaScript has been written. Frankly, it is difficult to find a topic related to JavaScript that has not been discussed ad nauseam. However, JavaScript is changing at a rapid pace. ECMAScript 6 has the potential to transform the language and how we code in it. Node.js has already changed the way in which we write servers in JavaScript. Newer ideas such as React and Flux will drive the next iteration of the language.";
		Assert.assertEquals(actualtitleNameAfterImage3Description, ExpectedtitleNameAfterImage3Description);
		}
		
	
	@Test(priority=8,description="TestCase8 = Adding Image1 Review and checking Wether Review of image1 is Submitted or not , Verifying it by Revivers Name")
	public void homePageImage1_Review() {	
	driver.get("http://practice.automationtesting.in/product/selenium-ruby/");
	driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[2]/a")).click();  // Review Button Clicking
	driver.findElement(By.xpath("//*[@id=\"commentform\"]/p[2]/p/span/a[5]")).click();   // Review Star Selecting
	driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("Welcome To ATI Pune- Manual and Automation Batch- SEPTEBER Batch 2021");  // Adding Review
	driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys(" ABCD EFGH ");        // Name of Reviewer
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(" abcdef123@gmail.com"); // Email of Reviewer
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
	
	String actualNameOfReviever=driver.findElement(By.xpath("//*[@id=\"comment-13254\"]/div/div[2]/p")).getText();   
	String expectedNameOfReviever= "AAAAAAA";
	Assert.assertEquals(actualNameOfReviever, expectedNameOfReviever);
	}
	
	
	  @Test(priority=9,description="TestCase9 = Adding Image2 Review and checking Wether Review of image2 is Submitted or not , Verifying it by Revivers comment ")
	public void homePageImage2_Review() {	
	driver.get("http://practice.automationtesting.in/product/thinking-in-html/");
	driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[2]/a")).click();  // Review Button Clicking
	driver.findElement(By.xpath("//*[@id=\"commentform\"]/p[2]/p/span/a[5]")).click();   // Review Star Selecting
	driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("Welcome To ATI Pune- Manual and Automation Batch- SEPTEBER Batch 2021");  // Adding Review
	driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys(" KLMN OPRW ");        // Name of Reviewer
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("klmnof123@gmail.com"); // Email of Reviewer
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
	
	String actualNameOfReviever=driver.findElement(By.xpath("//*[@id=\"comment-13257\"]/div/div[2]/p")).getText();   
	String expectedNameOfReviever= "Welcome To ATI Pune- Manual and Automation Batch- SEPTEBER Batch 2021";
	Assert.assertEquals(actualNameOfReviever, expectedNameOfReviever);
	}
	
	@Test(priority=10,description="TestCase10 = Adding Image2 Review and checking Wether Review of image3 is Submitted or not , Verifying it by Revivers comment")
	public void homePageImage3_Review() {	
	driver.get("http://practice.automationtesting.in/product/mastering-javascript/");
	driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[2]/a")).click();  // Review Button Clicking
	driver.findElement(By.xpath("//*[@id=\"commentform\"]/p[2]/p/span/a[5]")).click();   // Review Star Selecting
	driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("Welcome To ATI Pune- Manual and Automation Batch- SEPTEBER Batch 2021");  // Adding Review
	driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys(" XYZ HJKO ");        // Name of Reviewer
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("xyzkhrd123@gmail.com"); // Email of Reviewer
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
	
	String actualNameOfReviever=driver.findElement(By.xpath("//*[@id=\"comment-13259\"]/div/div[2]/p")).getText();   
	String expectedNameOfReviever= "Welcome To ATI Pune- Manual and Automation Batch- SEPTEBER Batch 2021";
	Assert.assertEquals(actualNameOfReviever, expectedNameOfReviever);
	
	
 	}
	@Test(priority=13,description="This test case is used to verify First Book title is equal to expected or not")
	public void verifyFirstBookTitle() {
		String expectedTitleBook="Selenium Ruby";
		String actualTitleBook=driver.findElement(By.xpath("//h3[text()='Selenium Ruby']")).getText();	
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
	}
		
	
 	}
