package steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AreaPage;
import utilities.DriverManager;


public class AreaSteps {
	
	WebDriver driver;
	AreaPage areaPage;
	

	@When("I navigate to the Area Master page")
	public void I_navigate_to_the_Area_Master_page() {
		driver = DriverManager.getDriver();
        areaPage = new AreaPage(driver);
		areaPage.clickMasterField();
		areaPage.clickGeography();
		areaPage.clickArea();
	}
	
    @When("I navigate to Add Area Master page")
	public void I_navigate_to_Add_Area_Master_page() {
		areaPage.clickAddArea();

	}
	  
	@Then("I should see the Area Master page loaded successfully")
	public void I_should_see_the_Area_Master_page_loaded_successfully() {
		areaPage.verifyAreaTitle();
	}

	@When("I enter {string} in the Area Code field")
	public void I_enter_areaCode_in_the_Area_Code_field(String areaCodeValue) {
		areaPage.enterAreaCode(areaCodeValue);

	}
	 
	@And ("I enter {string} in the Area Name field")
	public void I_enter_areaName_in_the_Area_Name_field(String areaNameValue) {
		areaPage.enterAreaName(areaNameValue);
	}
	
	@And ("I enter {string} in the State field")
	 public void I_enter_stateName_in_the_State_field(String state)  {
		areaPage.selectStateByText(state);
		}
		
	@And ("I click on the Save button")
	public void I_click_on_the_Save_button() throws InterruptedException {
		areaPage.saveBtn();
		Thread.sleep(2000);
	}
	
	@Then ("it should display Toast message")
	public void it_should_display_Toast_message() throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(3000);


	}
	
	@Then("I should see the newly added {string} {string} {string} in the Main Screen")
	public void iShouldSeeTheNewlyAddedInTheMainScreen(String areaCodeValue, String areaNameValue, String state) throws InterruptedException {
	    areaPage.searchAreaByCode(areaCodeValue);
	    boolean isAreaPresent = areaPage.isAreaPresentInMainScreen(areaCodeValue, areaNameValue, state);
	    Assert.assertTrue("Newly added area is not present in the Main Screen", isAreaPresent);
	}

    @Given("I search for {string} in the Area Master list")
    public void I_search_for_areaCode_in_the_area_master_list(String areaCodeValue) throws InterruptedException {
    	areaPage.searchAreaByCode(areaCodeValue);
    }
    
    @When ("I click on the Edit button for the Area Code")
    public void I_click_on_the_Edit_button_for_the_area_Code() {
    	areaPage.clickEditBtn();    	
    }
    		
    @Then ("I should see the Edit Area screen")
    public void I_should_see_the_EditArea_screen() {
    	areaPage.verifyEditAreaTitle();
    }
    
    @And ("the Area Code field should be prefilled with {string}")
    public void the_area_code_field_should_be_prefilled_with_area_code(String expectedAreaCode) {
    	String actualValue = areaPage.getAreaCode();
    	Assert.assertEquals("AreaCode field is not prefilled correctly", expectedAreaCode, actualValue );
    }
    
    @And ("the Area Name field should be prefilled with {string}")
    public void the_area_name_field_should_be_prefilled_with_area_name(String expectedAreaName) {
    	String actualValue = areaPage.getAreaName();
    	Assert.assertEquals("AreaName field is not prefilled correctly", expectedAreaName, actualValue);
    }
    
    @And ("the State field should be prefilled with {string}")
    public void the_state_field_should_be_prefilled_with_state(String expectedStateName) {
    	String actualValue = areaPage.getStateName();
    	Assert.assertEquals("StateName field is not prefilled correctly", expectedStateName, actualValue);
    }
    


/*public static void main (String args[]) throws InterruptedException {
	
	AreaSteps a = new AreaSteps();
	a.iLaunchTheBrowser();
	a.iEnterTheUrlFromConfig();
	a.iEnterAValidUsernameAndAValidPassword("adminsjqa", "sjqa");
	a.iClickOnTheLoginButton();
	
	a.I_navigate_to_the_Area_Master_page();
	a.I_enter_areaCode_in_the_Area_Code_field("2312");
	a.I_enter_areaName_in_the_Area_Name_field("Namakkal");
	a.I_enter_stateName_in_the_State_field("Tamil Nadu");
	a.I_click_on_the_Save_button();
	a.it_should_display_Toast_message();
	a.iShouldSeeTheNewlyAddedInTheMainScreen("2312", "Namakkal", "Tamil Nadu");
	
//	a.I_search_for_areaCode_in_the_area_master_list("2312");
	a.I_click_on_the_Edit_button_for_the_area_Code();
	a.the_area_code_field_should_be_prefilled_with_area_code("2312");
	a.the_area_name_field_should_be_prefilled_with_area_name("Namakkal");
	a.the_state_field_should_be_prefilled_with_state("Tamil Nadu");
	System.out.println("Test Case Pass");
	
	
	
} */

	}


	



