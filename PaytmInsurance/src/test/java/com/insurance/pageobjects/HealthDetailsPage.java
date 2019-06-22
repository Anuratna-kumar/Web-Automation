package com.insurance.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class HealthDetailsPage 
{
	@FindBy(xpath="//label[text()='Relationship']")
	private @Getter WebElement chooseRelation;
	
	public HealthDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
