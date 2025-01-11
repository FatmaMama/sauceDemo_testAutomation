@LoginSuccess
Feature: User Login

  @ValidCredentials
  Scenario Outline: Successful login
    Given the user is on the login page
    When the user enters a username as "<username>"
    And the user enters a password as "<password>"
    And clicks on the login button
    Then the user should be redirected to the products page

    Examples:
      | username  | password               |
      | standard_user  | secret_sauce   |

  @InvalidCredentials
  Scenario Outline: Failed login
    Given the user is on the login page
    When the user enters a username as "<username>"
    And the user enters a password as "<password>"
    And clicks on the login button
    Then the user should see a login failure message

    Examples:
      | username  | password              |
      | standard_user | random_password |
      
