package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.ActionEngine;
import com.cucumberFramework.helper.WaitHelper;

public class MyStoreLandingPage  extends ActionEngine{
	
	private WebDriver driver;
	WaitHelper waitHelper;
	
	
	public MyStoreLandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	MyStorePage myStorePage = new MyStorePage(driver);
	
	@FindBy(xpath="//a[@title='View my customer account']")
	public WebElement txtUser;
	
	@FindBy(xpath="//a[@title='Log me out']")
	public WebElement txtSignOut;
	
	// Proceed to check ou the order
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	public WebElement lnkTShirts;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	public WebElement imgFadedShort;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button")
	public WebElement btnAddToCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	public WebElement lnkProceedToCheckout;
	
	@FindBy(xpath="(//a[@title='Proceed to checkout'])[2]")
	public WebElement lnkProceedToCheckout2;
	
	@FindBy(xpath="//button[@name='processAddress']")
	public WebElement buttonProcessAddress;
	
	@FindBy(xpath="//label[text()='I agree to the terms of service and will adhere to them unconditionally.']")
	public WebElement chkTermsAndConditions;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	public WebElement btnProcessCarrier;
	
	@FindBy(xpath="//a[text()='Faded Short Sleeve T-shirts']")
	public WebElement lnkOrderDetails;
	
	@FindBy(xpath="//a[@title='Close']")
	public WebElement lnkClose;
	
	
	
	public void verifyLoggedInUser() throws Throwable {
		org.testng.Assert.assertEquals(txtUser.getText(), "Naveed Pasha");
	}
	
	public void iSignOut() throws Throwable {
		click(txtSignOut);
	}
	
	public void proceedToCheckOuTheOrder() throws Throwable {
		click(lnkTShirts);
		waitHelper.WaitForElement(imgFadedShort, 5);
		click(imgFadedShort);
		waitHelper.WaitForElement(btnAddToCart, 5);
		click(btnAddToCart);
		waitHelper.WaitForElement(lnkProceedToCheckout, 5);
		click(lnkProceedToCheckout);
		waitHelper.WaitForElement(lnkProceedToCheckout2, 5);
		click(lnkProceedToCheckout2);
		waitHelper.WaitForElement(buttonProcessAddress, 5);
		click(buttonProcessAddress);
		/*
		 * Thread.sleep(20000000); waitHelper.WaitForElement(lnkClose, 5);
		 * click(lnkClose);
		 */
		
		waitHelper.WaitForElement(chkTermsAndConditions, 5);
		click(chkTermsAndConditions);
		
		waitHelper.WaitForElement(btnProcessCarrier, 5);
		click(btnProcessCarrier);
	}
	
	public void iVerifyOrderDetails() throws Throwable {
		waitHelper.WaitForElement(lnkOrderDetails, 5);
		org.testng.Assert.assertEquals(lnkOrderDetails.getText(), "Faded Short Sleeve T-shirts");
		
	}

}
