@cartPage

Feature: Cart Page Functionality
  Background:
    Given User is on the cart page

  Scenario: Cart page elements validation
    Then cart empty image along with cart empty heading and shop now button should be displayed

  Scenario Outline: Adding a single product to the cart
    When the user clicks on the Shop Now button
    Then the user is redirected to the products page
    And the user searches for a product titled "<title>"
    When the user selects the product with a specified quantity and added to cart
    Then the total number of products in the cart page should match the cart icon count

    Examples:
      | title                     |
      | Chronograph Black Watch   |
#
  Scenario: Removing all products from the cart
    When the user clicks on the RemoveAll button in the cart page
    Then empty cart heading should be displayed