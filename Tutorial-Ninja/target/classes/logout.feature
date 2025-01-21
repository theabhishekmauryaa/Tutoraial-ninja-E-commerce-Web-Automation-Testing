Feature: Logout Functionality
  As a user
  I want to log out from my account
  So that I can securely exit my session

  Scenario: Logout using My Account dropdown
    Given I am logged in to my account
    When I click on the My Account dropdown and select Logout
    Then I should be logged out successfully

  Scenario: Logout using the right-bottom corner option
    Given I am logged in to my account
    When I click on the Logout option from the right-bottom corner
    Then I should be logged out successfully

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
