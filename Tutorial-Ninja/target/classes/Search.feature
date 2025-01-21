Feature: Product Search Functionality
  As a user
  I want to use the search functionality
  So that I can find products effectively

  Scenario: Search with an existing product name
    Given I am on the main page
    When I search for a valid product name
    Then the product should be displayed

  Scenario: Search with a non-existing product name
    Given I am on the main page
    When I search for a non-existing product name
    Then a "Product not found" message should be displayed

  Scenario: Search without providing any product name
    Given I am on the main page
    When I search without entering a product name
    Then a "Product not found" message should be displayed

  Scenario: Verify search placeholder
    Given I am on the main page
    Then the search box should have the placeholder text

  Scenario: Verify product comparison link
    Given I am on the main page
    When I search for a product and click the compare link
    Then the product comparison page should be displayed
