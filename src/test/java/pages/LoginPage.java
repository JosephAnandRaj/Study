package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	 private By usernameField = By.xpath("//input[@id='txtUserName']");
	 private By passwordField = By.xpath("//input[@id='txtPassWord']");
	 private By loginButton = By.xpath("//input[@name='btnLogin']");
	 private By title = By.xpath("//span[text()='DashBoard']");
	
	  // Constructor to initialize WebDriver
	 public LoginPage(WebDriver driver) {
	      this.driver = driver;
	    }
	
	 public void enterUsername(String username) {
			driver.findElement(usernameField).sendKeys(username);

	 }
	 
	 public void enterPassword(String password) {
			driver.findElement(passwordField).sendKeys(password);
	 }
	 
	 public void clickLoginButton() {
			driver.findElement(loginButton).click();
	 }
	 
	 public String getDashboardTitle() {
		 return driver.findElement(title).getText().trim();
	 }

	 
}
