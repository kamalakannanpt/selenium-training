package org.stepdefinition;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import org.base.BaseClass1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestNg extends BaseClass1{
	
	@BeforeClass
	private void launchTheBrowser() {
        launchBrowser();
        windowMaximize();
	}
	
	@BeforeMethod
	private void startDate() {
     Date d = new Date();
     System.out.println(d);
	}
	
	@AfterMethod
	private void endDate() {
		Date d = new Date();
      System.out.println(d);
	}
	
	@Test
	private void tc1() {
      System.out.println("Test case 1");
	}
	
	@Test
	private void tc2() {
     launchUrl("https://www.myntra.com/");
	}
	@AfterClass
	private void closeTheBroeswr() {
       closeEntireBrowser();
	}
	
	@DataProvider(name = "snapdeal data")
	private Object[][] data() {
      return new Object[][] {
    	  {"football"},
    	  {"shirts"},
    	  {"Bags"},
    	  {"Watches"}
    	
     };
	}
	
	@Test(dataProvider = "snapdeal data")
	private void tc3(String product) throws AWTException {
     launchUrl("https://www.snapdeal.com/");
     WebElement srcBox = driver.findElement(By.name("keyword"));
     srcBox.sendKeys(product);
     
     Robot r = new Robot();
     r.keyPress(KeyEvent.VK_ENTER);
     r.keyRelease(KeyEvent.VK_ENTER);
	}

	@Parameters({"username","password"})
	@Test
	private void tc4(String em,String pass) {
      launchUrl("https://www.facebook.com/");
      
      WebElement email = driver.findElement(By.id("email"));
      email.sendKeys(em);
      
      WebElement passWrd = driver.findElement(By.name("pass"));
      passWrd.sendKeys(pass);
      
      
      WebElement logBtn = driver.findElement(By.name("login"));
      logBtn.click();
      
      
	}
}

