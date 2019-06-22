package com.insurance.features;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.insurance.pageobjects.HealthDetailsPage;

public class ChooseHealthDetails 
{
	WebDriver driver;
	HealthDetailsPage hdp;
	
	public ChooseHealthDetails(WebDriver driver)
	{
		this.driver=driver;
		hdp=new HealthDetailsPage(driver);
	}
	
	public void relations()
	{
		WebElement chooseRel=hdp.getChooseRelation();
		Actions builder0 = new Actions(driver);
		Action mouseOverHome0 = builder0.moveToElement(chooseRel).clickAndHold(chooseRel).sendKeys("Self").moveByOffset(0, 30).click().build();
		mouseOverHome0.perform();
		ThWait(1000);
	}
	
	public void ThWait(int wait_time)
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
