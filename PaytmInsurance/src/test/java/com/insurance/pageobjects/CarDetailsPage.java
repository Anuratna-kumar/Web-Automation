package com.insurance.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class CarDetailsPage 
{
	@FindBy(xpath="//span[text()='MARUTI']")
	private @Getter WebElement chooseMake;
	
	@FindBy(css="input[placeholder='Search for Car Model']")
	private @Getter WebElement modelDrpDwn;
	
	@FindBy(xpath="//span[text()='LXI']")
	private @Getter WebElement chooseVariant;
	
	@FindBy(xpath="//span[text()='Petrol']")
	private @Getter WebElement chooseFuel;
	
	@FindBy(css="input[placeholder='Search for RTO location']")
	private @Getter WebElement chooseRTO;
	
	@FindBy(xpath="//span[text()='2017']")
	private @Getter WebElement chooseYear; 
	
	@FindBy(xpath="//span[text()='Iffco Tokio']")
	private @Getter WebElement chooseInsurer;
	
	@FindBy(xpath="//span[text()='Not Expired']")
	private @Getter WebElement policyStatus;
	
	@FindBy(xpath="//label[text()='No']")
	private @Getter WebElement claimRadio;
	
	@FindBy(xpath="//button[text()='Get Quotes']")
	private @Getter WebElement getQuotes;
	
	public CarDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
