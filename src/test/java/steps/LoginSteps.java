package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage; // Create an instance of the LoginPage class

	@Given("I Launch the browser")
	public void launchBrowser() {
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.get("url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver); // Initialize LoginPage with WebDriver

	}


	@When("I Enter the valid Credentials")
	public void login() {
		loginPage.enterUsername(ConfigReader.get("username"));
		loginPage.enterPassword(ConfigReader.get("password"));
		loginPage.clickLoginButton();
	}
	
	@Then("I should navigate to Home Screen")
	public void verifyTitle() throws InterruptedException {
		String expectedTitle = "DashBoard";
		String actualTitle = loginPage.getDashboardTitle();

		Assert.assertEquals("Dashboard not found", expectedTitle, actualTitle);
		System.out.println("Expected Title = " + expectedTitle + " Actual Title = " + actualTitle);
		Thread.sleep(5000);
	}
	
	@And("I close the browser")
	public void quitBrowser() {
		driver.quit();
	}

/*	public static void main(String[] args) throws InterruptedException {

		LoginSteps f = new LoginSteps();
		f.launchBrowser();
		f.login();
		f.verifyTitle();
		f.quitBrowser();
	} */

}
