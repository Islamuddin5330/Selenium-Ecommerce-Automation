package com.commerce.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmdetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public ConfirmdetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(css = "a[data-testid='place-order-btn']")
	    private WebElement placeOrderButton;

	    public void validateConfirmationDetails(
	            Map<String, String> formData) {

	        // Wait until the Place Order button is visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("a[data-testid='place-order-btn']")));

	        // Map form field names to confirmation test IDs
	        Map<String, String> confirmationLocators = Map.of(
	                "firstname", "confirm-firstname",
	                "lastname", "confirm-lastname",
	                "email", "confirm-email",
	                "phone", "confirm-phone",
	                "address", "confirm-address",
	                "states", "confirm-state",
	                "city", "confirm-city",
	                "pincode", "confirm-pincode"
	        );

	        // Validate each confirmation field
	        for (Map.Entry<String, String> entry : formData.entrySet()) {

	            String fieldName = entry.getKey();
	            String expectedValue = entry.getValue();

	            String testId = confirmationLocators.get(fieldName);

	            if (testId == null) {
	                throw new IllegalArgumentException(
	                        "No confirmation locator configured for: "
	                                + fieldName);
	            }

	            String actualValue = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.cssSelector(
	                                    "[data-testid='" + testId + "']")))
	                    .getText().trim();

	            Assert.assertEquals(
	                    actualValue,
	                    expectedValue,
	                    "Mismatch in confirmation field: " + fieldName);

	            System.out.println(
	                    fieldName + " validated successfully: " + actualValue);
	        }

	        System.out.println(
	                "All confirmation details validated successfully!");
	    }

	    public SuccessPage clickPlaceOrder() {
//	        wait.until(ExpectedConditions.elementToBeClickable(
//	                By.cssSelector("a[data-testid='place-order-btn']")));
	        placeOrderButton.click();
	        System.out.println("Order Submitted...");
	        return new SuccessPage(driver);
	    }
}
