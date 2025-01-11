@SortProducts
Feature: Sort Products

  Background:
    Given the user is on the login page
    When the user enters a username as "standard_user"
    And the user enters a password as "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the products page

  @SortByPriceLowToHigh
  Scenario: Sort Products by Price (Low to High)
    When the user sorts products by "Price (low to high)"
    Then the products should be sorted by price in ascending order

  @SortByNameZToA
  Scenario: Sort Products by Name (Z to A)
    When the user sorts products by "Name (Z to A)"
    Then the products should be sorted by name in descending order