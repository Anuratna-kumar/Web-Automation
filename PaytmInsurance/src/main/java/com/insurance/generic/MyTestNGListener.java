package com.insurance.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyTestNGListener implements ITestListener
{
	public static int executionCount,passCount,failCount,skipCount;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public void onTestStart(ITestResult result) 
	{
		
		extent = new ExtentReports ("/home/anuratnakumar/Documents/ExtentRep/STMExtentReport.html", true);
		extent.loadConfig(new File("/home/anuratnakumar/Documents/extent-config.xml"));
		
		Reporter.log(result.getName()+ " Script started executing "+new Date(),true);
		executionCount++;
	}

	public void onTestSuccess(ITestResult result) 
	{
		logger = extent.startTest("passTest");
		 Assert.assertTrue(true);
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		 
		Reporter.log(result.getName()+" Script passed ",true);
		passCount++;
	}

	public void onTestFailure(ITestResult result) 
	{
		logger = extent.startTest("failTest");
		 Assert.assertTrue(false);
		 logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		
		Reporter.log(result.getName()+" Script Failed ",true);
		TakesScreenshot ts=(TakesScreenshot)BaseLib.driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./PaytmInsurance/screenshot/" +result.getName()+".png");
		
		try
		{
			Files.copy(srcFile, destFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Reporter.log("Screenshot has been taken",true);
		failCount++;
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(result.getName()+" Script skipped,true");
		skipCount++;
		
		logger = extent.startTest("skipTest");
		 throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		Reporter.log("Suite execution started"+new Date(),true);
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log("Suite execution ends"+new Date(),true);
		Reporter.log("Total scripts executed : "+executionCount,true);
		Reporter.log("Total scripts passed : "+passCount,true);
		Reporter.log("Total scripts failed : "+failCount,true);
		Reporter.log("Total scripts skipped : "+skipCount,true);
		
		 extent.flush();
		 extent.close();
	}
	
}
