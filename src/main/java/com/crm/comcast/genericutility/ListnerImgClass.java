package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImgClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
     System.out.println("==============================Failure");
		
		JavaUtility jLib = new JavaUtility();
		
		String testName = result.getMethod().getMethodName();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseAnnoationClass.sdriver);
	   File srcFile = 	eDriver.getScreenshotAs(OutputType.FILE);
	
	   File dsFile = new File("./screenShot/"+testName+"_"+jLib.getSystemDateAndTime()+".png");
	
	    try {
			FileUtils.copyFile(srcFile, dsFile);
		} catch (IOException e) {
			
		}
	}


}
