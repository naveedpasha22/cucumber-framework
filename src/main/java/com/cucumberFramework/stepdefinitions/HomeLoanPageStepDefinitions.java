package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.ActionEngine;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.HomeLoanBorrowingPowerCalculatorPage;
import com.cucumberFramework.testBase.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class HomeLoanPageStepDefinitions extends TestBase {

	HomeLoanBorrowingPowerCalculatorPage homeLoanBorrowingPowerCalculatorPage = new HomeLoanBorrowingPowerCalculatorPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ActionEngine actionEngine = new ActionEngine(driver);
	
	@Given("^I am on the home page URL \"([^\"]*)\"$")
	public void i_Am_On_The_Home_Page_URL(String url) throws Throwable {
		driver.get(url);
	}

	@When("^I fill Your details")
	public void i_Fill_Your_Details() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.yourDetails();
	}
	
	@And("^I fill your earnings")
	public void i_Fill_Your_Earnings() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.yourEarnings();
	}
	
	@And("^I fill Your expenses")
	public void i_Fill_Your_Expenses() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.yourExpenses();
	}
	
	@Then("^verify the borrowing estimate")
	public void verify_The_Borrowing_Estimate() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.btnBorrowCalculater.click();
		Thread.sleep(5000);
		String txt = homeLoanBorrowingPowerCalculatorPage.txtWeEstimateYouCouldBorrow.getText();
		org.testng.Assert.assertEquals(txt, "$451,000");
	}
	
	@And("^clear the form on clicking start over button")
	public void clear_The_Form_On_Clicking_Start_Over_Button() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.btnStartOver.click();
		org.testng.Assert.assertEquals(homeLoanBorrowingPowerCalculatorPage.txtYourAnnualIncomeBeforeTax.getText(), "");
		org.testng.Assert.assertEquals(homeLoanBorrowingPowerCalculatorPage.txtYourAnnualOtherIncome.getText(), "");
		org.testng.Assert.assertEquals(homeLoanBorrowingPowerCalculatorPage.txtMonthlyLivingExpenses.getText(), "");
		org.testng.Assert.assertEquals(homeLoanBorrowingPowerCalculatorPage.txtOtherLoanMonthlyRepayments.getText(), "");
		org.testng.Assert.assertEquals(homeLoanBorrowingPowerCalculatorPage.txtTotalCreditCardLimits.getText(), "");
	}
	
	@And("^verify error message up on filling only Living expenses")
	public void verify_Error_Eessage_Up_On_Filling_Only_Living_Expenses() throws Throwable {
		String txt1 = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		homeLoanBorrowingPowerCalculatorPage.onlyMonthlyLivingExpenses();
		String txt2 = homeLoanBorrowingPowerCalculatorPage.txtBorrowErrorText.getText();
		org.testng.Assert.assertEquals(txt1, txt2);
	}
}