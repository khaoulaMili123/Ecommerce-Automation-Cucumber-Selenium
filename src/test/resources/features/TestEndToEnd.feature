Feature: User Registration
 
  Scenario: Registering on the website
    Given I am on the automation practice website
    When I click on sign-in
    And I submit the registration form
    And I fill in my personal information
    And I fill in my address information
    Then I should see my firstname in my account
    
    

