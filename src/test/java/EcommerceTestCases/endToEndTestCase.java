package EcommerceTestCases;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class endToEndTestCase {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String userName = "demo@demo.com";
		String password = "demo";
		String[] productNames = { "White T-Shirt", "Black Sport Shoes" };

		// Intizat Browser first
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to application
		driver.get("https://shop.qaautomationlabs.com/");
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginBtn")).click();

		System.out.println("User Login Successfully...");

		// check if login is Successfully login?
		System.out.println(driver.findElement(By.cssSelector("a[data-testid = 'breadcrumb-home']")).isDisplayed());

		// Select Men Fashion
		driver.findElement(By.cssSelector("a[data-testid='shop-now-mens-wear']")).click();

		for (String productName : productNames) {
			boolean productAdded = false;

			List<WebElement> productList = driver.findElements(By.xpath("//div[contains(@class,'product-item')]"));

			for (WebElement product : productList) {

				String gotProductName = product.findElement(By.xpath(".//a[contains(@class,'h6')]")).getText().trim();
				System.out.println("Product name is : " + gotProductName);

				if (productName.equalsIgnoreCase(gotProductName)) {
					product.findElement(By.xpath(".//button[contains(@class,'btn')]")).click();
					System.out.println("Product " + gotProductName + " is added to the cart...");
					productAdded = true;
					break;
				}
			}

			if (!productAdded) {
				System.out.println(productName + " not found.");
			}
		}
		System.out.println("All requested Product are added to the Cart");

		// Click on cart
		driver.findElement(By.xpath("//a[@id='cartdesk']")).click();

		// Cart Summary
		List<WebElement> selectedProducts = driver.findElements(By.xpath("//td[contains(@class,'align-left')]"));

		for (String expectedProduct : productNames) {

			boolean found = false;

			for (WebElement selectedProduct : selectedProducts) {

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

		// Click on Proceed button
		driver.findElement(By.id("checkoutBtn")).click();

		// Billing Address
//		driver.findElement(By.id("firstname")).sendKeys("Mr");
//		driver.findElement(By.id("lastname")).sendKeys("Bean");
//		driver.findElement(By.id("email")).sendKeys("abcd123@gmail.com");
//		driver.findElement(By.id("phone")).sendKeys("8314330789");
//		driver.findElement(By.id("address")).sendKeys("It's unknow address you handover to anyone...");
//		driver.findElement(By.id("states")).sendKeys("Goa");
//		driver.findElement(By.id("city")).sendKeys("Pink");
//		driver.findElement(By.id("pincode")).sendKeys("300050");

		// Another way is?
		HashMap<String, String> formData = new HashMap<>();
		formData.put("firstname", "Mr");
		formData.put("lastname", "Bean");
		formData.put("email", "abcd123@gmail.com");
		formData.put("phone", "8314330789");
		formData.put("address", "It's unknown address");
		formData.put("states", "Goa");
		formData.put("city", "Pink");
		formData.put("pincode", "300050");

		// Enter data into form fields
//        for (Map.Entry<String, String> entry : formData.entrySet()) {
//            driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
//        }

		//Fill the form
		for (Map.Entry<String, String> entry : formData.entrySet()) {
			WebElement field = driver.findElement(By.id(entry.getKey()));
			if (!entry.getValue().isEmpty()) {
				field.sendKeys(entry.getValue());
			}
		}

		// continue button
		driver.findElement(By.id("continue")).click();

		// Confirm Details and Cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='place-order-btn']")));

		Map<String, String> confirmationLocators = new HashMap<>();

		confirmationLocators.put("firstname", "confirm-firstname");
		confirmationLocators.put("lastname", "confirm-lastname");
		confirmationLocators.put("email", "confirm-email");
		confirmationLocators.put("phone", "confirm-phone");
		confirmationLocators.put("address", "confirm-address");
		confirmationLocators.put("states", "confirm-state"); // Important fix
		confirmationLocators.put("city", "confirm-city");
		confirmationLocators.put("pincode", "confirm-pincode");

		// Validate every field
		for (Map.Entry<String, String> entry : formData.entrySet()) {

			String fieldName = entry.getKey();
			String expectedValue = entry.getValue();

			String testId = confirmationLocators.get(fieldName);

			String actualValue = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.cssSelector("[data-testid='" + testId + "']")))
					.getText().trim();

			Assert.assertEquals(actualValue, expectedValue, "Mismatch in field: " + fieldName);

			System.out.println(fieldName + " validated successfully: " + actualValue);
		}
		System.out.println("All confirmation details validated successfully!");

		// place order button
		driver.findElement(By.cssSelector("a[data-testid='place-order-btn']")).click();

		String finalText = driver.findElement(By.cssSelector("h1[data-testid='order-success-title']")).getText().trim();

		Assert.assertEquals(finalText, "🎉 Thank You for Your Order!");

		System.out.println("Order placed successfully!");

		driver.quit();
	}

}
