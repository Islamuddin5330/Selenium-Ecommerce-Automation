package EcommerceTestCases;

import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.commerce.baseclass.BaseClass;
import com.commerce.pages.BillingAddressPage;
import com.commerce.pages.CartPage;
import com.commerce.pages.ConfirmdetailsPage;
import com.commerce.pages.GenderPage;
import com.commerce.pages.HomePage;
import com.commerce.pages.LoginPage;
import com.commerce.pages.SuccessPage;
import com.commerce.utilities.DataProvidar;
import com.commerce.utilities.ExcelData4;
import com.commerce.utilities.LoggerManager;

public class endToEndTestCaseExceldata extends BaseClass {

	@Test(dataProvider = "readdata", dataProviderClass = DataProvidar.class)
	public void commerceTestCase(String userName, String password, String[] productNames, int excelRowIndex)
			throws Throwable {

		String status = "Pass";
		String remark = "";

		try {
			System.out.println("Products received: " + java.util.Arrays.toString(productNames));

			// Login
			LoginPage loginpage = new LoginPage(getDriver());
			GenderPage genderpage = loginpage.login(userName, password);

			genderpage.checkLogin();
			HomePage homepage = genderpage.getMensFashionDetails();

			// Add requested products
			homepage.addProductToCart(productNames);

			// Verify cart
			CartPage cartpage = homepage.clickCartButton();
			cartpage.getAllSelectedProduct(productNames);

			// Continue your existing checkout flow
			BillingAddressPage addresspage = cartpage.clickOnProduceedButton();

			HashMap<String, String> formData = new HashMap<>();
			formData.put("firstname", "Mr");
			formData.put("lastname", "Bean");
			formData.put("email", "abcd123@gmail.com");
			formData.put("phone", "8314330789");
			formData.put("address", "It's unknown address");
			formData.put("states", "Goa");
			formData.put("city", "Pink");
			formData.put("pincode", "300050");

			addresspage.fillAddressForm(formData);

			ConfirmdetailsPage confirmpage = addresspage.clickContinue();
			confirmpage.validateConfirmationDetails(formData);

			SuccessPage orderSubmitted = confirmpage.clickPlaceOrder();
			orderSubmitted.verifySuccessMessage();

			remark = "Test passed. Added and verified products: " + String.join(", ", productNames);

		} catch (Throwable t) {

			status = "Fail";

			remark = "Requested products: " + String.join(", ", productNames) + " | Failure: "
					+ (t.getMessage() == null ? t.getClass().getSimpleName() : t.getMessage());

			 logger.error("Test execution failed: " + remark, t);
			 
			throw t;

		} finally {

			ExcelData4 excel = new ExcelData4();

			excel.getExcelData("Sheet2");

			excel.setStatus(excelRowIndex, 3, status);
			excel.setRemark(excelRowIndex, 4, remark);

			excel.closeWorkbook();
		}
	}

}
