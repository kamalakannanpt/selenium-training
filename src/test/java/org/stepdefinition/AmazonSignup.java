package org.stepdefinition;
import io.cucumber.datatable.*;


import java.util.List;

import org.base.BaseClass1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pojo.AmazonPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSignup extends BaseClass1 {
	
	AmazonPojo a;
	Actions c = new Actions(driver);
	
	@Given("To launch the chrome browser and maximize the window")
	public void to_launch_the_chrome_browser_and_maximize_the_window() {
	    launchBrowser();
	    windowMaximize();
	}

	@When("To launch the url of the amazon application")
	public void to_launch_the_url_of_the_amazon_application() {
	    launchUrl("https://www.amazon.in/");
	}

	@When("To move the cursor keep in signin")
	public void to_move_the_cursor_keep_in_signin() {
		a = new AmazonPojo();
		WebElement s = a.getSignIn();
		c.moveToElement(s).perform();
	    
	}

	@When("To click the signin button")
	public void to_click_the_signin_button() {
		a = new AmazonPojo();
       clickBtn(a.getSignIn());
	}

	@When("To pass username or mobileno in email text box")
	public void to_pass_username_or_mobileno_in_email_text_box(DataTable d) {
	    List<List<String>> l = d.asLists();
		a = new AmazonPojo();
       passText(l.get(1).get(2), a.getEmail());
	}

	@When("To click continue button")
	public void to_click_continue_button() {
		a = new AmazonPojo();
		clickBtn(a.getConBtn());
	}

	@When("To pass password in password text box")
	public void to_pass_password_in_password_text_box(DataTable d) {
		List<String> li = d.asList();
		a = new AmazonPojo();
        passText(li.get(2), a.getPassWrd());
	    
	}

	@When("To click password signin button")
	public void to_click_password_signin_button() {
		a = new AmazonPojo();
	    clickBtn(a.getPassSignInBtn());
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	    closeEntireBrowser();
	}




}
