package com.commerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'product-item')]")
	private List<WebElement> getAllProductList;
//	@FindBy(xpath = ".//a[contains(@class,'h6')]")
//	private WebElement getProductName;
//	@FindBy(xpath = ".//button[contains(@class,'btn')]")
//	private WebElement addProductTOCart;
	
	@FindBy(xpath = "//a[@id='cartdesk']")
	private WebElement cartButton;


public void addProductToCart(String[] productNames) {

    for (String productName : productNames) {

        if (productName == null || productName.trim().isEmpty()) {
            continue;
        }

        productName = productName.trim();
        boolean productAdded = false;

        // Re-fetch product elements for each requested product
        List<WebElement> productList = driver.findElements(
                By.xpath("//div[contains(@class,'product-item')]")
        );

        for (WebElement product : productList) {

            String gotProductName = product.findElement(
                    By.xpath(".//a[contains(@class,'h6')]")
            ).getText().trim();

            if (productName.equalsIgnoreCase(gotProductName)) {

                product.findElement(
                        By.xpath(".//button[contains(@class,'btn')]")
                ).click();

                System.out.println(
                        "Product " + gotProductName + " is added to the cart..."
                );

                productAdded = true;
                break;
            }
        }

        if (!productAdded) {
            throw new AssertionError(
                    "Product not found in product listing: " + productName
            );
        }
    }

    System.out.println("All requested products were added to the cart.");
}

	
	public CartPage clickCartButton() {
		cartButton.click();
		return new CartPage(driver);
	}

}
