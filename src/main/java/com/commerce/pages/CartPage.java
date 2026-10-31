package com.commerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(@class,'align-left')]")
	//div[contains(text(),'Get plan matches')]
	private List<WebElement> verifySelectedProduct;
	@FindBy(id = "checkoutBtn")
	private WebElement proceedButton;

	public void getAllSelectedProduct(String[] productNames) {

		for (String expectedProduct : productNames) {

			// Skip null or blank Excel values
			if (expectedProduct == null || expectedProduct.trim().isEmpty()) {
				continue;
			}

			expectedProduct = expectedProduct.trim();

			boolean found = false;

			for (WebElement selectedProduct : verifySelectedProduct) {

				String actualProduct = selectedProduct.getText().trim();

				if (expectedProduct.equalsIgnoreCase(actualProduct)) {

					System.out.println("Selected Product name is: " + actualProduct);

					found = true;
					break;
				}
			}

			Assert.assertTrue(found, "Product not found in cart: " + expectedProduct);
		}

		System.out.println("All requested products are present in the cart.");
	}

	public BillingAddressPage clickOnProduceedButton() {
		proceedButton.click();
		return new BillingAddressPage(driver);
	}
}
