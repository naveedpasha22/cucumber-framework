package com.cucumberFramework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionEngine {
	
	private WebDriver driver;
	
	public ActionEngine(WebDriver driver){
		this.driver = driver;
	}
	
	public void selectByValue(WebElement webElement, int value) throws Throwable {
	    try {
	      Select dropDown = new Select(webElement);
	      dropDown.deselectByIndex(value);
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
	
}
