package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.HomeLoanBorrowingPowerCalculatorPage;
import com.cucumberFramework.testBase.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class HomeLoanPageStepDefinitions extends TestBase {

	HomeLoanBorrowingPowerCalculatorPage homeLoanBorrowingPowerCalculatorPage = new HomeLoanBorrowingPowerCalculatorPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^I am on the home page URL \"([^\"]*)\"$")
	public void i_Am_On_The_Home_Page_URL(String url) throws Throwable {
		driver.get(url);
	}

	@And("^I fill your earnings")
	public void i_Fill_Your_Earnings() throws Throwable {
		homeLoanBorrowingPowerCalculatorPage.yourEarnings();
	}
	
	
}