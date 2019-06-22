package com.insurance.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory 
{
	public static WebDriver launch(String browserName)
	{
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/anuratnakumar/Downloads/chromedriver");
			driver=new ChromeDriver();
			Reporter.log("chrome launched", true);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/home/anuratnakumar/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
			driver=new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		}
		
		return driver;
	}
}
