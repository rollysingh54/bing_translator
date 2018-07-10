package bing_translator_automation.bing_translator;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class TranslatorHomePage

{
	 WebDriver driver;
	 
	 public TranslatorHomePage(WebDriver wbdriver)//constructor
	  {
		  this.driver=wbdriver;
	  }

	public void checkUrl() 
	{
		 Reporter.log("Inside TranslatorHomePage");
		 Reporter.log("Chrome Browser Opened\n");
		driver.manage().window().maximize();
		 Reporter.log("Browser maximised\n");
		driver.get("https://www.bing.com/translator");
		Reporter.log("URL entered");
		String expectedUrl="https://www.bing.com/translator";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Wrong or Incorrect URL !!");
		Reporter.log("Bing Translator started ");
		Reporter.log("TranslatorHomePage test passed");
    }
	  
	
}
