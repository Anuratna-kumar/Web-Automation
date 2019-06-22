package com.insurance.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.insurance.pageobjects.CarDetailsPage;

public class ChooseCarDetails 
{
	WebDriver driver;
	CarDetailsPage cdp;
	
	public ChooseCarDetails(WebDriver driver)
	{
		this.driver=driver;
		cdp=new CarDetailsPage(driver);
	}
	
	public void Model()
	{
		cdp.getChooseMake().click();
		WebElement chooseCar=cdp.getModelDrpDwn();
		Actions builder0 = new Actions(driver);
		Action mouseOverHome0 = builder0.moveToElement(chooseCar).clickAndHold(chooseCar).sendKeys("SWIFT").moveByOffset(0, 70).click().build();
		mouseOverHome0.perform();
		ThWait1(1000);
	}
	
	public void variant()
	{
		cdp.getChooseVariant().click();
		cdp.getChooseFuel().click();
		ThWait1(1000);
	}
	
	public void RTO()
	{
		WebElement chooseDrp1=cdp.getChooseRTO();
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(chooseDrp1).clickAndHold(chooseDrp1).sendKeys("Solapur (MH-13)").moveByOffset(0, 40).click().build();
		mouseOverHome.perform();
		cdp.getChooseYear().click();
		ThWait1(1000);
	}
	
	public void policyExpiry()
	{
		cdp.getChooseInsurer().click();
		cdp.getPolicyStatus().click();
		cdp.getClaimRadio().click();
		cdp.getGetQuotes().click();
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
