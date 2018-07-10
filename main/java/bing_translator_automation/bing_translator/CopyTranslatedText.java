package bing_translator_automation.bing_translator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class CopyTranslatedText {

	WebDriver driver;
	public CopyTranslatedText(WebDriver webdriver) 
	{
		this.driver=webdriver;
    }
	public void checkCopyOfTranslatedText() throws IOException 
	{
		  Reporter.log("Inside CopyTranslatedText ");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  WebElement right_textarea=driver.findElement(By.cssSelector("textarea[id='t_tv']"));
		  //String text=right_textarea.getAttribute("value");
		
		  
		  //String text= (String) jse.executeScript("return arguments[0].value",right_textarea );
		  //System.out.println(text);
		  
		  WebElement copyIcon=driver.findElement(By.cssSelector("a[id='t_copyIcon']"));
		  Actions builder = new Actions(driver);
		  Actions copyAction=builder.moveToElement(copyIcon);
		  copyAction.click().build().perform();
		  boolean clickStatus=copyIcon.isEnabled();
		  System.out.println(clickStatus);
//		  String filename="C:\\Users\\rollysingh\\eclipse-workspace\\bing_translator\\CopiedText.txt";
//		  FileWriter fw = new FileWriter(filename);
//		  BufferedWriter bw = new BufferedWriter(fw);
//		  String r="";
//		  
//		  builder.sendKeys(r, Keys.chord(Keys.CONTROL,"v")).perform();
//		  System.out.println(r);
//		  bw.close();
		  Assert.assertTrue(clickStatus, "Copy Icon is clicked.");
	}

}
