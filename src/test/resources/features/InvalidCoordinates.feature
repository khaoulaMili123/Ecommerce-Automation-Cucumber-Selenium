Feature: Verify error for invalid coordinates

  Scenario Outline: Verify error for invalid email and password
    Given I open the URL
    When I click on the sign-in link
    And I enter "<email>" into the email input field and "<password>" into the password input field and press Enter
    Then I validate that the error message displays.
    Examples:
      | email            | password          | 
      | mili1@yopmail.com | 12345   | 
      | mili1691&=19@yopmail.com| 123456  | 
      | mili1| 123456| 
      