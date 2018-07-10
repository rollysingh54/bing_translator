package bing_translator_automation.bing_translator;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class BingTest {
	public static WebDriver webdriver;
	TranslatorHomePage thp;
	CheckDefaultValueOfDropdowns cdvod;
	CheckTranslation ct;
	CheckCharacterLimitation ccl;
	CheckReversibleSymbol crs;
	CheckAlignmentForRightToLeftLangs cafrtl;
	CopyTranslatedText ctt;
	
  @BeforeTest
  public void launchDriver()
  {
	  webdriver= new ChromeDriver();  
	  thp=new TranslatorHomePage(webdriver);
	  cdvod=new CheckDefaultValueOfDropdowns(webdriver);
	  ct=new CheckTranslation(webdriver);
	  ccl=new CheckCharacterLimitation(webdriver);
	  crs=new CheckReversibleSymbol(webdriver);
	  cafrtl=new CheckAlignmentForRightToLeftLangs(webdriver);
	  ctt=new CopyTranslatedText(webdriver);
  }
  @Test(priority=0)
  public void Test_00_launchUrl()
  {
	 
	  thp.checkUrl();
  }
  @Test(priority=1)
  public void Test_01_checkByDefaultValueOfDropdownsOnBothSides()
  {
	  
	  cdvod.checkByDefaultValueOfDropdownsLeft();
	  cdvod.checkByDefaultValueOfDropdownsRight();
  }
  @Test(priority=2)
  public void Test_02_checkTranslation()
  {
	 ct.checkTranslationFunction();
  }
  @Test(priority=3)
  public void Test_03_checkCopyingOfTranslatedText() throws InterruptedException, IOException 
  {
	  ctt.checkCopyOfTranslatedText();
  }
  
//  @Test(priority=4)
//  public void Test_04_checkForAlignment() throws InterruptedException 
//  {
//	  cafrtl.checkForRightToLeftAlignment();
//  }
// 
//  @Test(priority=5)
//  public void Test_05_checkEffectOfReversibleSymbol() 
//  {
//	 crs.checkReversibleSymbol();
//  }
//  @Test(priority=6)
//  public void Test_06_checkCharacterLimitation()
//  {
//	 ccl.checkCharLimit();
//  }
  
  
//  @AfterTest
//  public void afterTest()
//  {
//	  driver.quit();
//  }
//
}
