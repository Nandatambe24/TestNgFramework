package com.atipune.testng.basics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot extends ExtentReportOfFacebook{
	public ScreenShot() throws IOException{
		super();
	}
	public static String getScreenshot (WebDriver driver,String name) throws IOException
	{
	
		TakesScreenshot tss=( TakesScreenshot)driver;
    File src=tss.getScreenshotAs(OutputType.FILE);
    System.out.println(src);
    String destination ="D:\\java22\\eclipse\\TestNgFramework\\Screenshot\\"+name+".png";
    File dest=new File(destination);
    
    FileHandler.copy(src, dest);
    return destination;
}

}
