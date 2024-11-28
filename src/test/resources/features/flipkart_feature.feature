Feature: Add items to Flipkart cart

  Scenario: Add two mobile items to the Flipkart cart
    Given I open the Flipkart website
    When I search for "mobile"
    Then I add the first two items to the cart
    And I validate the cart contains 2 items