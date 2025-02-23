Feature: Login Functionality

	Scenario: Login Successful
	Given I Launch the browser
	When I Enter the valid Credentials
	Then I should navigate to Home Screen 
	And I close the browser
	