Feature: User Registration

  Scenario: Register by providing valid credentials
    Given the user is on the registration page
    When the user enters valid details and submits the form
    Then the registration should be successful

  Scenario: Registration by providing an existing email
    Given the user is on the registration page
    When the user enters details with an existing email and submits the form
    Then an error message should be displayed for using an existing email

  Scenario: Registration without selecting the privacy checkbox
    Given the user is on the registration page
    When the user enters valid details but does not select the privacy checkbox
    Then an error message for privacy checkbox must be displayed

  Scenario: Registration by providing different passwords
    Given the user is on the registration page
    When the user enters mismatched passwords and submits the form
    Then an error message for mismatched passwords must be displayed

  Scenario: Registration without providing confirm password
    Given the user is on the registration page
    When the user skips the confirm password and submits the form
    Then an error message for missing confirm password must be displayed
