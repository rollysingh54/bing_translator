package bing_translator_automation.bing_translator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckDefaultValueOfDropdowns 

{
	 WebDriver driver;

public CheckDefaultValueOfDropdowns(WebDriver wbdriver)//constructor
{
	  this.driver=wbdriver;
}
public void checkByDefaultValueOfDropdownsLeft() 
{
	Select languagesDropdownLeft = new Select(driver.findElement(By.id("t_sl")));
	//languagesDropdownLeft.selectByValue("Auto-Detect");
	String strleft= languagesDropdownLeft.getFirstSelectedOption().getText();
	try
	{
	Assert.assertEquals("Auto-Detect", strleft);
	System.out.println("By default value of left dropdown is correct");
	}
	catch(AssertionError ase)
	{
		System.out.println("By default value of left dropdown is wrong and the following exception is:  "+ase);;
	}
}

public void checkByDefaultValueOfDropdownsRight()
{
	Select languagesDropdownRight = new Select(driver.findElement(By.id("t_tl")));
	String strright= languagesDropdownRight.getFirstSelectedOption().getText();
	try
	{
	Assert.assertEquals("English", strright);
	System.out.println("By default value of right dropdown is correct");
	}
	catch(AssertionError ase)
	{
		System.out.println("By default value of right dropdown is wrong and the following exception is:  "+ase);;
	}
}
}
