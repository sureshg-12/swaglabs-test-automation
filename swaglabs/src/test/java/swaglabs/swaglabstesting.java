package swaglabs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseclass.intializemethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class swaglabstesting extends intializemethods {

	WebElement userName;
	WebElement passWord;
	WebElement loginbutton;

	@Test(priority = 1)
	public void smoketest() throws InterruptedException, IOException {
		
			// Login using valid credentials
			login_valid();
			takescreenshot();
			System.out.println("HomePage ss Captured");

			// select product, add to cart, navigate back to products homePage
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement productselect = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
			productselect.click();

			// add to cart

			WebElement addtocart = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class='btn_primary btn_inventory']")));
			addtocart.click();

			// navigate back to products page
			driver.navigate().back();

			// Opening CartPage

			driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
			takescreenshot();
			System.out.println("Cart Page ss Captured");

			try {
				// Navigate Back from CartPage to HomePage
				driver.findElement(By.xpath("//a[@class='btn_secondary']")).click();
			} catch (TimeoutException e) {

			}

			// Back to CartPage Again
			driver.navigate().back();
			System.out.println("Back to cart");

			// CheckoutPage
			driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();

			// Enter Checkout Details/Address
			checkout_details();
			takescreenshot();
			System.out.println("Checkout AddressPage ss Captured");

			// Finish the checkout
			driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();

			// order success message and order status
			order_success();

			takescreenshot();
			System.out.println("Order SuccessPage ss Captured");

			// Back to Home Page
			homepage();

			// Logout
			logout();
	}

	// Finding WebElements of userName and password
	public void logincredentials() {

		userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		passWord = driver.findElement(By.xpath("//input[@id='password']"));
		loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
	}

	// login with valid UserName and password
	public void login_valid() throws IOException {

		logincredentials();
		userName.sendKeys("standard_user");
		passWord.sendKeys("secret_sauce");
		loginbutton.click();
		System.out.println("Successfully Login ");

	}

	// Enter CheckoutDetails
	public void checkout_details() throws InterruptedException {

		driver.findElement(By.id("first-name")).sendKeys("JohnWick");
		driver.findElement(By.id("last-name")).sendKeys("Harry");
		driver.findElement(By.id("postal-code")).sendKeys("537202");

		try {
			// Continue Checkout Details
			driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
			System.out.println("Submited the checkout details");
		} catch (TimeoutException e) {
			// Cancel Checkout Details
			driver.findElement(By.xpath("//a[@class='cart_cancel_link btn_secondary']")).click();
			System.out.println("Cancel Checkout details");
		}
	}

	// Order Success Confirmation Page
	public void order_success() throws IOException {

		WebElement ordersuccess = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		System.out.println(" " + ordersuccess.getText());

		// Order Status
		WebElement orderstatus = driver.findElement(By.xpath("//div[@class='complete-text']"));
		System.out.println("OrderStatus = " + orderstatus.getText());
	}

	// Navigate to HomePage
	public void homepage() {
		driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

	}

	// Logout From WebSite
	public void logout() throws InterruptedException {

		WebElement menu = driver.findElement(By.xpath("//button[text()='Open Menu']"));
		menu.click();

		WebDriverWait menubar = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> logout = menubar
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='logout_sidebar_link']")));
		logout.get(0).click();

		System.out.println("Successfully LogOut");
	}

	// Login With Invalid LoginDetails
	@Test(dataProvider = "logintestdata", priority = 2)

	public void invalid_details(String username, String password) throws IOException {

		logincredentials();
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginbutton.click();
		takescreenshot();
		System.out.println("invalid login credentials screenshot captured");

	}

	// Providing Data to Test for Login
	@DataProvider(name = "logintestdata")
	public Object[][] logindata() {
		return new Object[][] { { "problem_user", "password" }, { "username1", "secret_sauce" }, { "   ", "    " } };
	}
}
