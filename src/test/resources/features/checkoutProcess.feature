@Checkout
Feature: Complete Checkout Process

  Background:
    Given the user is on the login page
    When the user enters a username as "standard_user"
    And the user enters a password as "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the products page
    And the user adds the first product "Sauce Labs Backpack" to the cart
    And the user adds the second product "Sauce Labs Bike Light" to the cart
    Then the cart should display 2 items

  @ValidCheckout
  Scenario: Successfully Complete Checkout Process
    Given the user is on the cart page
    When the user clicks on the checkout button
    And the user enters the first name as "<firstName>"
    And the user enters the last name as "<lastName>"
    And the user enters the zip code as "<zipCode>"
    And the user clicks on the continue button
    Then the user should be redirected to the checkout overview page
    When the user clicks on the finish button
    Then the user should see the order confirmation message

    Examples:
      | firstName | lastName | zipCode |
      | Fatma      | Mama      | 5070   |

  @InvalidCheckout
  Scenario Outline: Checkout Process with Invalid Data
    Given the user is on the cart page
    When the user clicks on the checkout button
    And the user enters the first name as "<firstName>"
    And the user enters the last name as "<lastName>"
    And the user enters the zip code as "<zipCode>"
    And the user clicks on the continue button
    Then the user should see an error message "<errorMessage>"

    Examples:
      | firstName | lastName | zipCode | errorMessage                        |
      |           | Mama     | 5070    | Error: First Name is required       |
      | Fatma     |          | 5070    | Error: Last Name is required        |
      | Fatma     | Mama     |         | Error: Postal Code is required      |
      |           |          |         | Error: First Name is required       |