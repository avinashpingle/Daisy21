package com.testingshastra.stepdefinitions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.testingshastra.config.Application;
import com.testingshastra.keywords.UIKeywords;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	UIKeywords keyword = UIKeywords.getInstance();
	public RemoteWebDriver driver = null;

	//@Before
	public void setup() {
		Application app = new Application();
		String browserName = app.getBrowser();
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());
	}
	
	//@After
	public void tearDown() {
		driver.quit();
	}
	@Given("The chrome browser is launched")
	public void the_chrome_browser_is_launched() {
		Application app = new Application();
		String browserName = app.getBrowser();
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		
	}

	@And("The url of application is also launched")
	public void the_url_of_application_is_also_launched() {
		Application app = new Application();
		
	}

	@Then("verify the title of homepage is {string}")
	public void verify_the_title_of_homepage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
}
