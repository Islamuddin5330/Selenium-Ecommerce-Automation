package com.commerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderPage {
	
	private WebDriver driver;
	
	public GenderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[data-testid = 'breadcrumb-home']")
	private WebElement HomePageIcon;
	
	@FindBy(css = "a[data-testid='shop-now-mens-wear']")
	private WebElement selectMensFashion;
	
	public void checkLogin() {
		System.out.println(HomePageIcon.isDisplayed());
	}
	
	public HomePage getMensFashionDetails() {
		selectMensFashion.click();
		return new HomePage(driver);
	}

}
