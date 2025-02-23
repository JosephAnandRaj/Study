package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AreaPage {
	WebDriver driver;
	
	public AreaPage(WebDriver driver) {
	this.driver = driver;	
	}

	
	private By masterField = By.xpath("//span[text()='Master']");
	private By geography = By.xpath("//a[text()=' Geography ']");
	private By area      = By.xpath("//span[text()='Area']");
	private By addArea   = By.xpath("//a[text()='Add Area']");
	private By areaTitle = By.xpath("//span[text()='Area']");
	private By areaCode  = By.id("ctl00_ContentPlaceHolder1_txtSubDivision_Sname");
	private By areaName  = By.id("ctl00_ContentPlaceHolder1_txtSubDivision_Name");
	private By state     = By.id("ctl00_ContentPlaceHolder1_ddlState");
	private By saveBtn   = By.id("ctl00_ContentPlaceHolder1_btnSubmit");
	private By searchBar = By.id("tSearchOrd");
	private By table = By.id("OrderList");
	private By editBtn = By.xpath("//a[text()='Edit']");
	private By editAreaTitle = By.xpath("//a[text()='Area List']");
	

	 

	    public void clickMasterField() {
		driver.findElement(masterField).click();	   
		}
	
	public void clickGeography() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement geographyLink = wait.until(ExpectedConditions.elementToBeClickable(geography));
	    geographyLink.click();
	}
	
	public void clickArea() {
		driver.findElement(area).click();
	}
	
	public void clickAddArea() {
		driver.findElement(addArea).click();
	}
	
	public void verifyAreaTitle() {
		String actualTitle   = driver.findElement(areaTitle).getText().trim(); 
		String expectedTitle = "Area";
		Assert.assertEquals("Title does not match", expectedTitle, actualTitle);
	}
	
	public void enterAreaCode(String areaCodeValue) {
		driver.findElement(areaCode).sendKeys(areaCodeValue);
	}
	
	public void enterAreaName(String areaNameValue) {
		driver.findElement(areaName).sendKeys(areaNameValue);
	}
	
	public void selectStateByText(String stateName) {
		Select select = new Select(driver.findElement(state));
		select.selectByVisibleText(stateName);
	}
	
	public void saveBtn() {
		driver.findElement(saveBtn).click();
	}
	
	public void searchAreaByCode(String areaCodeValue) throws InterruptedException {
	    WebElement search = driver.findElement(searchBar);
	    search.clear();
	    search.sendKeys(areaCodeValue);
	    Thread.sleep(2000);
	    System.out.println("Searching for Area Code: " + areaCodeValue); // Debugging: Print the area code being searched
	    //search.submit();
	}

	
	public boolean isAreaPresentInMainScreen(String areaCodeValue, String areaNameValue, String stateName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrderList")));

	    // Concatenate the expected text and trim any extra spaces
	    String expectedText = String.join(" ", areaCodeValue.trim(), areaNameValue.trim(), stateName.trim()).replaceAll("\\s+", " ").trim();
	    System.out.println("Expected Text: '" + expectedText + "'"); // Debugging: Print the expected text

	    for (WebElement row : tableElement.findElements(By.tagName("tr"))) {
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        
	        if (cells.size() >= 4) {  // Ensuring there are at least 4 cells in the row
	            String actualText = String.join(" ", 
	                    cells.get(1).getText().trim(), 
	                    cells.get(2).getText().trim(), 
	                    cells.get(3).getText().trim()).replaceAll("\\s+", " ").trim();
	            System.out.println("Actual Text: '" + actualText + "'"); // Debugging: Printing actual text
	            
	            // Compare the trimmed expected and actual text
	            if (expectedText.equals(actualText)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public void clickEditBtn() {
		driver.findElement(editBtn).click();
	}
	
	public void verifyEditAreaTitle() {
		String actualTitle   = driver.findElement(editAreaTitle).getText().trim();
		String expectedTitle = "Area List";
		Assert.assertEquals("Title does not match", expectedTitle, actualTitle);
	}

	public String getAreaCode() {
		return driver.findElement(areaCode).getAttribute("value");
	}
	
	public String getAreaName() {
		return driver.findElement(areaName).getAttribute("value");
	}
	
	public String getStateName() {
		WebElement stateDropdown = driver.findElement(state);
		Select select = new Select(stateDropdown);
		return select.getFirstSelectedOption().getText().trim();
	}
	
	
	
	


private WebElement waitForElementToBeVisible(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

// Helper method to wait for an element to be clickable
private WebElement waitForElementToBeClickable(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

// Changes 3
// Changes 4
}


	
	


