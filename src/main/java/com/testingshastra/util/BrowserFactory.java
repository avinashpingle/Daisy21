package com.testingshastra.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static final BrowserFactory factory;
	static{
		factory = new BrowserFactory();
	}
	private BrowserFactory() {
		
	}
	
	public static BrowserFactory getInstance() {
		return factory;
	}
	public void setDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			System.out.println("Creating chrome instance");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			System.out.println("Creating firefox instance");
			break;
		default:
			System.err.println("Invalid browser name: " + browserName);
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}
