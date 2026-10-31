package com.commerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commerce.baseclass.BaseClass;

public class LoginPage {
	/*
	 * Your page class doesn't need to inherit the test setup and teardown methods 
	 * from BaseClass. It already receives the correct WebDriver through its 
	 * constructor. Keeping page objects independent from BaseClass avoids 
	 * unnecessary inheritance and makes the framework easier to maintain.
	 */
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement enterEmail;
	@FindBy(id = "password")
	private WebElement enterPassword;
	@FindBy(id = "loginBtn")
	private WebElement loginButton;
	
	
	public GenderPage login(String userName, String passWord) {
		enterEmail.sendKeys(userName);
		enterPassword.sendKeys(passWord);
		loginButton.click();
		System.out.println("User Login Successfully...");
		return new GenderPage(driver);
	}
	
	
}
