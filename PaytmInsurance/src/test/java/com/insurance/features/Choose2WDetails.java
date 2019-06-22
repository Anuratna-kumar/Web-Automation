package com.insurance.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.insurance.pageobjects.TwoWheelerPage;

public class Choose2WDetails 
{
	WebDriver driver;
	TwoWheelerPage twp;
	
	public Choose2WDetails(WebDriver driver)
	{
		this.driver=driver;
		twp=new TwoWheelerPage(driver);
	}
	
	public void Make()
	{
		twp.getChooseMake().click();
		ThWait1(1000);
	}
	
	public void Model()
	{
		twp.getChooseModel().click();
		ThWait1(1000);
	}
	
	public void variant()
	{
		twp.getChooseVariant().click();
		ThWait1(1000);
	}
	
	public void RTO()
	{
		WebElement chooseDrp1=twp.getChooseRTO();
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(chooseDrp1).clickAndHold(chooseDrp1).sendKeys("Solapur (MH-13)").moveByOffset(0, 40).click().build();
		mouseOverHome.perform();
		twp.getChooseYear().click();
		ThWait1(1000);
	}
	
	public void policyExpiry()
	{
		twp.getPolicyStatus().click();
		twp.getChooseInsurer().click();
		twp.getChooseTenure().click();
		twp.getClaimRadio().click();
		twp.getGetQuotes().click();
		ThWait1(4000);
	}
	
	public void ThWait1(int wait_time)
	{
		try 
		{
			Thread.sleep(wait_time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
