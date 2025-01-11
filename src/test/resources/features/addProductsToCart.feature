@AddProductsToCart
Feature: Add Products to Cart

  Background:
    Given the user is on the login page
    When the user enters a username as "standard_user"
    And the user enters a password as "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the products page

  @ValidAddProductsToCart
  Scenario: Successfully Add Products to Cart
    When the user adds the first product "<product1>" to the cart
    And the user adds the second product "<product2>" to the cart
    Then the cart should display 2 items

    Examples:
      | product1 |  product2 |
      | Sauce Labs Backpack  | Sauce Labs Bike Light  |
  