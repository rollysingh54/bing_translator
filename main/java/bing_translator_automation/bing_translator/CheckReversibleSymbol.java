package bing_translator_automation.bing_translator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckReversibleSymbol 
{
	 WebDriver driver;
	 public CheckReversibleSymbol(WebDriver wbdriver)//constructor
	 {
	 	  this.driver=wbdriver;
	 }

	 private String getValueFromLeftDropdown()
		{
			Select languagesDropdownLeft = new Select(driver.findElement(By.id("t_sl")));
			String strleft= languagesDropdownLeft.getFirstSelectedOption().getText();
			return strleft;
		}
	 
	private String getValueFromRightDropdown()
	{
		Select languagesDropdownRight = new Select(driver.findElement(By.id("t_tl")));
		String strright= languagesDropdownRight.getFirstSelectedOption().getText();
		return strright;
	}
	
	 

	public void checkReversibleSymbol() 
	{
		Reporter.log("Inside CheckReversibleSymbol ");
		String leftDropdownValueBeforeClick=getValueFromLeftDropdown();
		String rightDropdownValueBeforeClick=getValueFromRightDropdown();
		//System.out.println("Before Click:  "+leftDropdownValueBeforeClick+" "+rightDropdownValueBeforeClick);
	    WebElement reverseSymbol=driver.findElement(By.cssSelector("a[id='t_revIcon']"));
	    reverseSymbol.click();
	    String leftDropdownValueAfterClick=getValueFromLeftDropdown();
		String rightDropdownValueAfterClick=getValueFromRightDropdown();
		//System.out.println("After Click:  "+leftDropdownValueAfterClick+" "+rightDropdownValueAfterClick);
		Assert.assertEquals(leftDropdownValueBeforeClick, rightDropdownValueAfterClick);
		Assert.assertEquals(rightDropdownValueBeforeClick, leftDropdownValueAfterClick);
		Reporter.log(" CheckReversibleSymbol Test passed");
	
	}
}
