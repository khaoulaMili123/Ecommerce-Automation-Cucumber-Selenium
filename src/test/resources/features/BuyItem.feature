Feature: Buying a Product

Scenario: Purchasing a Product
Given I am on the Automation Practice website
When I log in
And I navigate to the Women section
And I hover over the second displayed product and I click on the More button
And I select the quantity, size and color
And I click on the Add to Cart button
And I click on the Proceed to checkout button
And I complete the ordering process up to payment
Then I ensure that the product is successfully ordered.