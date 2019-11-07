@SmokeTest
Feature: Galen Framework Outline

  Background: 
    Given the user login into Galen FrameWork "testuser@example.com" "test123"

  Scenario Outline: Add a simple note 1
    Given I select the simple note 
    When I create a simple note "<text1>"
    Then I validate the simple note "<text1>"
    
    Examples:    
   	 | text1| 
  	 | Primer Mensaje | 
    
  	 Scenario Outline: Add a simple note 2
    Given I select the simple note 
    When I create a simple note "<text1>"
    Then I validate the simple note "<text1>"
    
    Examples:    
   	 | text1| 
  	 | Primer Mensaje |
 	 
  	 Scenario Outline: Add a simple note 3
    Given I select the simple note 
    When I create a simple note "<text1>"
    Then I validate the simple note "<text1>"
    
    Examples:    
   	 | text1| 
  	 | Primer Mensaje |
  	 
  	 	 
  	Scenario Outline: Add another note 1
 		Given I select the another note 
    When I create an another note "<text2>"
    Then I validate the another note "<text2>"
    
    Examples: 
 		 | text2| 
  	 | Segundo Mensaje | 
  	   		 
  Scenario Outline: Add another note 2
 		Given I select the another note 
    When I create an another note "<text2>"
    Then I validate the another note "<text2>"
    
    Examples: 
 		 | text2| 
  	 | Segundo Mensaje | 