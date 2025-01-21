Feature: Add to Cart Functionality

  Scenario: Add a product to the cart from the product page
    Given I am on the product page
    When I add the product to the cart
    Then the product should be added to the cart successfully

  Scenario: Add a product to the cart from the wishlist
    Given I am logged into my account
    And I have added a product to the wishlist
    When I add the product from the wishlist to the cart
    Then the product should be added to the cart successfully

  Scenario: Add a product to the cart from the search result page
    Given I search for a product
    When I add the product to the cart from the search result page
    Then the product should be added to the cart successfully

  Scenario: Add a product to the cart from the product display page
    Given I search for a product
    And I am on the product display page
    When I add the product to the cart
    Then the product should be added to the cart successfully

  Scenario: Add a product to the cart from the features section
    Given I am on the homepage
    When I add a product from the features section to the cart
    Then the product should be added to the cart successfully

  Scenario: Add a product to the cart from the product comparison page
    Given I search for a product
    And I add the product to the comparison list
    When I add the product to the cart from the comparison page
    Then the product should be added to the cart successfully
