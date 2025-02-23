	Feature: Area Master Management
	
	Background: Login and Navigate to Area Page
	 		Given I Launch the browser
			When I Enter the valid Credentials
			When I navigate to the Area Master page
			
	  Scenario: Successfully navigating to Area Master Page
		  Then I should see the Area Master page loaded successfully
	
	  Scenario Outline: Successfully creating a new Area
	    When I navigate to Add Area Master page
	    When I enter "<areaCodeValue>" in the Area Code field
	    And I enter "<areaNameValue>" in the Area Name field
	    And I enter "<stateName>" in the State field
	    And I click on the Save button
	    Then it should display Toast message
	    Then I should see the newly added "<areaCodeValue>" "<areaNameValue>" "<stateName>" in the Main Screen
	
	  Examples:
	    | areaCodeValue | areaNameValue    | stateName   |
	    | 2312          | Namakkal         | Tamil Nadu  |
	    
	
	  Scenario Outline: Verify prefilled data in Edit Screen
	    Given I search for "<areaCodeValue>" in the Area Master list
	    When I click on the Edit button for the Area Code
	    Then I should see the Edit Area screen
	    And the Area Code field should be prefilled with "<areaCodeValue>"
	    And the Area Name field should be prefilled with "<areaNameValue>"
	    And the State field should be prefilled with "<stateName>"
	    And I close the browser
	    
	
	  Examples:
	    | areaCodeValue 	 | areaNameValue          | stateName   |
	    | 2312             | Namakkal      			 | Tamil Nadu          |
