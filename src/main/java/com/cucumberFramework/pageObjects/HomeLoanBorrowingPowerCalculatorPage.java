package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumberFramework.helper.WaitHelper;

public class HomeLoanBorrowingPowerCalculatorPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//label[@for='application_type_single']")
	public WebElement btnApplicationType;
	
	@FindBy(xpath="//label[text()='Your annual income (before tax)']/following-sibling::div/input")
	public WebElement txtYourAnnualIncomeBeforeTax;
	
	
	WaitHelper waitHelper;
	
	public HomeLoanBorrowingPowerCalculatorPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void yourDetails() {
		btnApplicationType.click();
		
	}
	
	public void yourEarnings() {
		txtYourAnnualIncomeBeforeTax.clear();
		txtYourAnnualIncomeBeforeTax.sendKeys("80000");
	}
	
}
