Feature: Login Functionality

  Scenario: Logging in with valid credentials
    Given I open the application
    When I enter valid email and password
    And I click on the login button
    Then I should see my account page

  Scenario: Logging in with invalid credentials
    Given I open the application
    When I enter invalid email and password
    And I click on the login button
    Then I should see an error message
