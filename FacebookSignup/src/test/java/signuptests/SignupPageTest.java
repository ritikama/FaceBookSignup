package signuptests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class SignupPageTest extends base {

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test
	public void Signup_Phone() throws Exception {
		try {
			InputParameters inputParameter = new InputParameters("Riti", "Mahajan", "0449858200", "abc123", "",
					"Female");
			SignupForm utility = new SignupForm(driver, inputParameter, prop);
			boolean result = utility.testExecution("", "");
			System.out.println("the result from Signup_Phone is " + result);
		} catch (Exception e) {
			System.out.println("Exception in the test case " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void Signup_Email() throws Exception {
		try {
			InputParameters inputParameter = new InputParameters("Riti", "Mahajan", "ritika@gmail.com", "abc123",
					"email", "Female");
			SignupForm utility = new SignupForm(driver, inputParameter, prop);
			boolean result = utility.testExecution("", "");
			System.out.println("the result from Signup_Email is " + result);
		} catch (Exception e) {
			System.out.println("Exception in the test case " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void Signup_invalid_phone() throws Exception {
		try {
			InputParameters inputParameter = new InputParameters("Riti", "Mahajan", "12345", "abc123", "", "Female");
			SignupForm utility = new SignupForm(driver, inputParameter, prop);
			String xPath = "//div[@class='uiContextualLayer uiContextualLayerLeft']//div[contains(text(),'Please')]";
			String warningMessage = "Please enter a valid mobile number or email address.";
			boolean result = utility.testExecution(warningMessage, xPath);
			System.out.println("The result from Signup_invalid_phone is " + result);
			AssertJUnit.assertEquals(true, result);

		} catch (Exception e) {
			System.out.println("Exception in the test case " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void Signup_ivalidpassword() throws Exception {
		try {
			InputParameters inputParameter = new InputParameters("Plan", "IT", "0449858200", "abc123", "", "Male");
			SignupForm utility = new SignupForm(driver, inputParameter, prop);
			String warningMessage = "Please choose a more secure password. It should be longer than 6 characters, unique to you and difficult for others to guess.";
			String xPath = "//div[@id='reg_error']";

			boolean result = utility.testExecution(warningMessage, xPath);
			AssertJUnit.assertEquals(true, result);

			System.out.println("the result from Signup_ivalidpass is " + result);
		} catch (Exception e) {
			System.out.println("Exception in the test case " + e.getMessage());
			e.printStackTrace();
		}

	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.close();
			driver = null;
		}

	}
}
