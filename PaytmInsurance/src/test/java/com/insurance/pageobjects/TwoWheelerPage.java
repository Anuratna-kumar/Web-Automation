package com.insurance.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TwoWheelerPage 
{
	@FindBy(xpath="//span[text()='HONDA']")
	private @Getter WebElement chooseMake;
	
	@FindBy(xpath="//span[text()='ACTIVA']")
	private @Getter WebElement chooseModel;
	
	@FindBy(xpath="//span[text()='3G']")
	private @Getter WebElement chooseVariant;
	
	@FindBy(css="input[placeholder='Search for RTO location']")
	private @Getter WebElement chooseRTO;
	
	@FindBy(xpath="//span[text()='2017']")
	private @Getter WebElement chooseYear; 
	
	@FindBy(xpath="//span[text()='Not Expired']")
	private @Getter WebElement policyStatus;
	
	@FindBy(xpath="//span[text()='Iffco Tokio']")
	private @Getter WebElement chooseInsurer;
	
	@FindBy(xpath="//span[text()='1 Year']")
	private @Getter WebElement chooseTenure;
	
	@FindBy(xpath="//label[text()='No']")
	private @Getter WebElement claimRadio;
	
	@FindBy(xpath="//button[text()='Get Quotes']")
	private @Getter WebElement getQuotes;

	public TwoWheelerPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
}
