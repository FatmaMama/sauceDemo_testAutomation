@Logout
Feature: User Logout

  Background:
    Given the user is on the login page
    When the user enters a username as "standard_user"
    And the user enters a password as "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the products page

  @ValidLogout
  Scenario: Successful Logout
    Given the user opens the sidebar menu by clicking the menu button
    When the user clicks on the logout button
    Then the user should be redirected to the login page