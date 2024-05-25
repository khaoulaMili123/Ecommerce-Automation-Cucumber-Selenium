Feature: Automate product search functionality
  
  Scenario: Search for a product and verify its details
    Given I am on the homepage of Automation Practice website 
    When I hover over the Women menu and I click on the T-shirts sub-menu
    And I get the name/text of the first product displayed on the page
    And I enter the product name in the search bar
    Then I validate the product details