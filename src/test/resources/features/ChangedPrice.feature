
Feature: Checking Total Price Update

Scenario: Checking Total Price Update on Modifying Quantity
Given I open the Automation Practice website
When I log-in
And I select the Women section
And I choose the second displayed product and I click on the More button
And I select size and color
And I ensure there is only one product 
And I click on the Add to Cart
And I click on the Proceed to checkout
And I modify the quantity
Then I verify that the total price changes and reflects the correct price.