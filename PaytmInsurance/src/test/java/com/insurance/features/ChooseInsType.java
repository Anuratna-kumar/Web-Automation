package com.insurance.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.insurance.pageobjects.ChooseInsPage;

public class ChooseInsType 
{
	WebDriver driver;
	ChooseInsPage cip;
	
	public ChooseInsType(WebDriver driver)
	{
		this.driver=driver;
		cip=new ChooseInsPage(driver);
	}
	
	public void chooseIns(String insName)
	{
		WebElement buyInsSel;
		buyInsSel=cip.getBuyInsRadio();
		if(buyInsSel.isSelected())
		{
			System.out.println("Already selected");
	    }
		else
		{
			buyInsSel.click();
		}
		
		cip.getInsDrpDwn().sendKeys(insName);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		cip.getInsDrpDwn().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ThWait(2000);
	}
	
	public void fillCarDataIns()
	{
		cip.getRegNum().click();
		ThWait(1000);
	}
	
	public void fill2WDataIns()
	{
		cip.getRegNum().click();
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
