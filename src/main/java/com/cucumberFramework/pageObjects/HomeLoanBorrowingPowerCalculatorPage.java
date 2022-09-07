package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.ActionEngine;
import com.cucumberFramework.helper.WaitHelper;

public class HomeLoanBorrowingPowerCalculatorPage extends ActionEngine{
	
	private WebDriver driver;
	
	@FindBy(xpath="//label[@for='application_type_single']")
	public WebElement btnApplicationType;
	
	@FindBy(xpath="//div/select[@title='Number of dependants']")
	public WebElement selNumberOfDependants;
	
	@FindBy(xpath="//label[@for='borrow_type_home']")
	public WebElement btnPropertyYouWouldLikeToBuy;
	
	@FindBy(xpath="//label[text()='Your annual income (before tax)']/following-sibling::div/input")
	public WebElement txtYourAnnualIncomeBeforeTax;
	
	@FindBy(xpath="//label[text()='Your annual other income (optional)']/following-sibling::div/input")
	public WebElement txtYourAnnualOtherIncome;
	
	@FindBy(xpath="//label[contains(text(), 'Monthly living expenses')]/following-sibling::div/input")
	public WebElement txtMonthlyLivingExpenses;
	
	@FindBy(xpath="//label[contains(text(), 'Current home loan monthly')]/following-sibling::div/input")
	public WebElement txtCurrentHomeLoanMonthly;
	
	@FindBy(xpath="//label[contains(text(), 'Other loan monthly repayments')]/following-sibling::div/input")
	public WebElement txtOtherLoanMonthlyRepayments;
	
	@FindBy(xpath="//label[contains(text(), 'Other monthly commitments')]/following-sibling::div/input")
	public WebElement txtOtherMonthlyCommitments;
	
	@FindBy(xpath="//label[contains(text(), 'Total credit card limits')]/following-sibling::div/input")
	public WebElement txtTotalCreditCardLimits;
	
	@FindBy(xpath="//button[@id='btnBorrowCalculater']")
	public WebElement btnBorrowCalculater;
	
	@FindBy(xpath="//h3[text()='We estimate you could borrow:']/following-sibling::span")
	public WebElement txtWeEstimateYouCouldBorrow;
	
	@FindBy(xpath="(//button[@class='start-over'])[1]")
	public WebElement btnStartOver;
	
	@FindBy(xpath="//div[@class='borrow__error__text']")
	public WebElement txtBorrowErrorText;
	
	WaitHelper waitHelper;
	
	public HomeLoanBorrowingPowerCalculatorPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void yourDetails() {
		try {
			click(btnApplicationType);
			//selectByValue(selNumberOfDependants, 0);
			click(btnPropertyYouWouldLikeToBuy);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void yourEarnings() {
		try {
			type(txtYourAnnualIncomeBeforeTax, "80000");
			type(txtYourAnnualOtherIncome, "10000");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void yourExpenses() {
		try {
			type(txtMonthlyLivingExpenses, "500");
			type(txtCurrentHomeLoanMonthly, "0");
			type(txtOtherLoanMonthlyRepayments, "100");
			type(txtOtherMonthlyCommitments, "0");
			type(txtTotalCreditCardLimits, "10000");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void onlyMonthlyLivingExpenses() {
		try {
			type(txtMonthlyLivingExpenses, "1");
			click(btnBorrowCalculater);
			Thread.sleep(5000);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
