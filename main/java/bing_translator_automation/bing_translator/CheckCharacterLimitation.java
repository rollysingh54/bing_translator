package bing_translator_automation.bing_translator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckCharacterLimitation {
	
	 WebDriver driver;

		
	 public CheckCharacterLimitation(WebDriver wbdriver)//constructor
	 {
	 	  this.driver=wbdriver;
	 }

	public void checkCharLimit()
	{
      WebElement charLimit=driver.findElement(By.cssSelector("div[id='t_charcount']"));
      String limitString=charLimit.getText();
      int slashIndex=limitString.indexOf("/");
      int maxLimit= Integer.parseInt(limitString.substring(slashIndex+1));
      String alphanum="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      int alphanumLength=alphanum.length();
    
      WebElement left_textarea=driver.findElement(By.cssSelector("textarea[id='t_sv']"));
      left_textarea.clear();
      left_textarea.click();
      try
      {
        StringBuilder textToBeSend=createRandomString(maxLimit,alphanumLength,alphanum); 
		left_textarea.sendKeys(textToBeSend);
      }
      catch(Exception e)
      {
    	 System.out.println(" exception in CheckCharacterLimitation Test:   "+e.toString()); 
      }
	}

	private StringBuilder createRandomString(int maxLimit,int alphanumLength,String alphanum) 
	{
		int randomNo,i;
		StringBuilder s = new StringBuilder();
  	  for ( i=0;i<10;i++)
  	  {
  		   randomNo=(int)(Math.random()*(((alphanumLength-1)-0)+1))+0;
  		   char randomChar=alphanum.charAt(randomNo);
  		   s.append(randomChar).toString();
  		    
  	  }
		return s;
	}

}
