@SmokeTest
Feature: Galen Framework Outline

  Background: 
    Given the user login into Galen FrameWork "testuser@example.com" "test123"

  Scenario Outline: Add a simple note
    Given I select the simple note 
    When I create a simple note "<text1>"
    Then I validate the simple note "<text1>"
    
  Examples:
  	 | text1| 
  	 | Hola soy carmelo de todos los meseros el primero | 
    

#  Scenario Outline: Add another note
 #   Given I click on the another note 
 #   When I write on the desciprion text box <text2>
  #  And I click on the save button  
  #  Then I validate the text from the description text box 
    
 # Examples:
 # 	 | text2                | 
 # 	 | Ven y pierdeme el respeto | 
  	 
