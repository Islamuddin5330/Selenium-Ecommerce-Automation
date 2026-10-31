package com.commerce.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAddressPage {

	public WebDriver driver;
	
	public BillingAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "states")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "pincode")
    private WebElement pinCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void fillAddressForm(Map<String, String> formData) {

        for (Map.Entry<String, String> entry : formData.entrySet()) {

            String fieldName = entry.getKey();
            String value = entry.getValue();

            if (value == null || value.isEmpty()) {
                continue;
            }

            switch (fieldName.toLowerCase()) {

            case "firstname":
                firstName.sendKeys(value);
                break;

            case "lastname":
                lastName.sendKeys(value);
                break;

            case "email":
                email.sendKeys(value);
                break;

            case "phone":
                phone.sendKeys(value);
                break;

            case "address":
                address.sendKeys(value);
                break;

            case "states":
                state.sendKeys(value);
                break;

            case "city":
                city.sendKeys(value);
                break;

            case "pincode":
                pinCode.sendKeys(value);
                break;

            default:
                throw new IllegalArgumentException(
                    "Unknown form field: " + fieldName
                );
            }
        }
    }

    public ConfirmdetailsPage clickContinue() {
        continueButton.click();
        return new ConfirmdetailsPage(driver);
    }
	
	
	
}
