package com.cucumberFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionEngine {
	
	private WebDriver driver;
	
	public ActionEngine(WebDriver driver){
		this.driver = driver;
	}
	
	public void selectByValue(WebElement webElement, String value) throws Throwable {
	    try {
	      Select dropDown = new Select(webElement);
	      dropDown.selectByValue(value);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	
	public void click(WebElement webElement) throws Throwable {
	    try {
	      webElement.click();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }

	 public void type(WebElement webElement, String testdata) throws Throwable {
		    try {
		      webElement.clear();
		      webElement.sendKeys(testdata);
		    } catch (Exception e) {
		      e.printStackTrace();
		    } 
		  }
	 
	  public String getRandomAlphaNumericString(int count) throws Throwable {
		    String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		    StringBuilder builder = new StringBuilder();
		    while (count-- != 0) {
		      int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
		      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		    }
		    return builder.toString();
		  }
	
}
