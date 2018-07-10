package bing_translator_automation.bing_translator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CheckTranslation 
{
	 WebDriver driver;

	
	 public CheckTranslation(WebDriver wbdriver)//constructor
	 {
	 	  this.driver=wbdriver;
	 }

	public void checkTranslationFunction()
	{
		Reporter.log("Inside CheckTranslation ");
		Select languagesDropdownLeft = new Select(driver.findElement(By.id("t_sl")));
	    languagesDropdownLeft.selectByVisibleText("English");
	    Select languagesDropdownRight = new Select(driver.findElement(By.id("t_tl")));
	    languagesDropdownRight.selectByVisibleText("French");
	    WebElement left_textarea=driver.findElement(By.cssSelector("textarea[id='t_sv']"));
	    String text[]= {"hello","how are you","thank you"};
	    for(int i=0;i<text.length;i++)
	    {
	    left_textarea.clear();	
	    left_textarea.click();
	    left_textarea.sendKeys(text[i]);
	    }
	    Reporter.log(" CheckTranslation Test Passed");
	}
	 
}
