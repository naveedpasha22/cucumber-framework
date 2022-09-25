package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.ActionEngine;
import com.cucumberFramework.helper.WaitHelper;

public class MyStorePage extends ActionEngine{
	WaitHelper waitHelper;
	private WebDriver driver;
	
	public MyStorePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	@FindBy(xpath="//a[@title='Log in to your customer account']")
	public WebElement lnkSignIn;

	@FindBy(xpath="//input[@id='email_create']")
	public WebElement txtEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	public WebElement btnCreateAnAccount;
	
	
	@FindBy(id="id_gender1")
	public WebElement rdoTitle;
	
	@FindBy(id="customer_firstname")
	public WebElement txtFirstName;
	
	@FindBy(id="customer_lastname")
	public WebElement txtLastName;
	
	@FindBy(id="email")
	public WebElement txtEmail2;
	
	@FindBy(id="passwd")
	public WebElement txtPassword;
	
	@FindBy(id="days")
	public WebElement selDays;
	
	@FindBy(id="months")
	public WebElement selMonths;
	
	@FindBy(id="years")
	public WebElement selYears;
	
	@FindBy(id="address1")
	public WebElement txtAddress1;
	
	@FindBy(id="city")
	public WebElement txtCity;
	
	@FindBy(id="id_state")
	public WebElement selIdState;
	
	@FindBy(id="postcode")
	public WebElement txtPostCode;
	
	//@FindBy(id="id_country")
	//public WebElement selIdCountry;
	
	@FindBy(id="phone_mobile")
	public WebElement txtPhoneMobile;
	
	@FindBy(id="submitAccount")
	public WebElement btnSubmitAccount;
	
	@FindBy(id="SubmitLogin")
	public WebElement btnSubmitLogin;
	
	public void verifySignLink() throws Throwable {
		org.testng.Assert.assertEquals(lnkSignIn.getText(), "Sign in");
	}
	
	public void createAnAccount(String email) throws Throwable {
		verifySignLink();
		click(lnkSignIn);
		type(txtEmail, email);
		click(btnCreateAnAccount);
	}
	
	public void enterYourPersonalInformatio() throws Throwable {
		waitHelper.WaitForElement(rdoTitle, 10);
		// Personal Details
		click(rdoTitle);
		type(txtFirstName, "Naveed");
		type(txtLastName, "Pasha");
		type(txtPassword, "Pass@2022");
		selectByValue(selDays, "10");
		selectByValue(selMonths, "4");
		selectByValue(selYears, "1985");
		
		//Address
		type(txtAddress1, "2000 East Rio Salado Parkway");
		type(txtCity, "Tempe");
		//Select Arizona state
		selectByValue(selIdState, "3");
		type(txtPostCode, "85281");
		type(txtPhoneMobile, "5555551234");
		click(btnSubmitAccount);
		
	}
	
	public void iSignInToTheLandingScreen(String email) throws Throwable {
		type(txtEmail2, email);
		type(txtPassword, "Pass@2022");
		click(btnSubmitLogin);
	}
	
}
