@RemoveProductsFromCart
Feature: Remove Products from Cart

  Background:
    Given the user is on the login page
    When the user enters a username as "standard_user"
    And the user enters a password as "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the products page
    And the user adds the first product "Sauce Labs Backpack" to the cart
    And the user adds the second product "Sauce Labs Bike Light" to the cart
    Then the cart should display 2 items

  @ValidRemoveProductsFromCart
  Scenario: Successfully Remove Products from Cart
    Given the user is on the cart page
    When the user removes the first product "Sauce Labs Backpack" from the cart
    Then the cart should display 1 item