package org.pojo;

import org.base.BaseClass1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPojo extends BaseClass1 {
	
	public AmazonPojo() {
     PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//span[text()='Hello, sign in']")
	private WebElement signIn;

	@FindBy(xpath = "(//span[text()='Sign in'])[1]")
	private WebElement signInBtn;
	
	@FindBy(id = "ap_email")
	private WebElement email;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement conBtn;
	
	@FindBy(name = "password")
	private WebElement passWrd;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement passSignInBtn;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getConBtn() {
		return conBtn;
	}

	public WebElement getPassWrd() {
		return passWrd;
	}

	public WebElement getPassSignInBtn() {
		return passSignInBtn;
	}
}