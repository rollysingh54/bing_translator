package bing_translator_automation.bing_translator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckAlignmentForRightToLeftLangs 
{
	 WebDriver driver;
	public CheckAlignmentForRightToLeftLangs(WebDriver webdriver)
	{
		this.driver=webdriver;
	}
	public void checkForRightToLeftAlignment() throws InterruptedException 
	{
		String langs[]= {"Arabic","Hebrew","Persian","Urdu"};
		Select languagesDropdownLeft = new Select(driver.findElement(By.id("t_sl")));
	    languagesDropdownLeft.selectByVisibleText("English");
	    
	    Thread.sleep(2000);
	    
	    Select languagesDropdownRight = new Select(driver.findElement(By.id("t_tl")));
	    int randomLangIndex=(int)(Math.random()*(((langs.length-1)-0)+1))+0;
	    languagesDropdownRight.selectByVisibleText(langs[randomLangIndex]);
	    
	    WebElement left_textarea=driver.findElement(By.cssSelector("textarea[id='t_sv']"));
	    left_textarea.clear();	
	    left_textarea.click();
	    left_textarea.sendKeys("hello");
	    WebElement right_textarea=driver.findElement(By.cssSelector("textarea[id='t_tv']"));
	    String alignment = right_textarea.getAttribute("dir");
	    System.out.println(alignment);
	     Assert.assertEquals(alignment, "rtl");
	     Reporter.log(" CheckAlignmentForRightToLeftLangs Test passed");
	}
	
}
