package com.insurance.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class ChooseInsPage 
{
	@FindBy(id="radio1")
	private @Getter WebElement buyInsRadio;
	
	@FindBy(xpath="//input[@type='text']")
	private @Getter WebElement insDrpDwn;
	
	@FindBy(css="div[class='_3wcd']")
	private @Getter WebElement regNum;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private @Getter WebElement proceed;
	
	public ChooseInsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
