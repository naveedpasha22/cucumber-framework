package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.ActionEngine;
import com.cucumberFramework.pageObjects.MyStoreLandingPage;
import com.cucumberFramework.pageObjects.MyStorePage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStorePageStepDefinitions extends TestBase {
	
	MyStorePage myStorePage = new MyStorePage(driver);
	ActionEngine actionEngine = new ActionEngine(driver);
	MyStoreLandingPage myStoreLandingPage = new MyStoreLandingPage(driver);
	
	
	@Given("^Test Application \"([^\"]*)\"$")
	public void testApplication(String url) throws Throwable {
		driver.get(url);
	}
	
	@When("^I Create an Account and complete the registration")
	public void iCreateAnAccountAndCompleteTheRegistration() throws Throwable {
		email = "naveed_"+actionEngine.getRandomAlphaNumericString(10)+"@gmail.com";
		myStorePage.createAnAccount(email);
		myStorePage.enterYourPersonalInformatio();
	}
	
	@And("^I navigated to the landing screen")
	public void iNavigatedToTheLandingScreen() throws Throwable {
		System.out.println("Email address: "+email);
		myStoreLandingPage.verifyLoggedInUser();
	}
	
	@And("^I Sign out from the landing screen")
	public void iSignOutTheLandingScreen() throws Throwable {
		System.out.println("Email address: "+email);
		myStoreLandingPage.iSignOut();
		myStorePage.verifySignLink();
		Thread.sleep(10000);
	}
	
	@And("^I Sign in to the landing screen")
	public void iSignInToTheLandingScreen() throws Throwable {
		myStorePage.iSignInToTheLandingScreen(email);
		myStoreLandingPage.verifyLoggedInUser();
	}
	
	@Then("^I proceed with my order and checkout")
	public void iProceedWithMyOrderAndCheckout() throws Throwable {
		myStoreLandingPage.proceedToCheckOuTheOrder();
	}
	
	@And("^I verify order details")
	public void iVerifyOrderDetails() throws Throwable {
		myStoreLandingPage.iVerifyOrderDetails();
		}
}
