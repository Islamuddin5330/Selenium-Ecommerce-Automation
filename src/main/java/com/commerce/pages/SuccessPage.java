
package com.commerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SuccessPage {

    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1[data-testid='order-success-title']")
    private WebElement successText;

    public void verifySuccessMessage() {

        String finalText = successText.getText().trim();

        Assert.assertEquals(
                finalText,
                "🎉 Thank You for Your Order!",
                "Order confirmation message does not match."
        );

        System.out.println("Order placed successfully!");
    }
}
