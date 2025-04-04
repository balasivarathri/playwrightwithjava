@Login_Page_Test
Feature: Validating the login page functionality

  Scenario Outline: Verify that the user login page with valid credentials
    Given User should be able to saucelogin with given parameters username <username> and password <password>
    When User should be navigated to Login Page
    And User should be on Login page
    And User can be able add the items to the cart
    And User should be on the cart page to checkout process
    Then User should successfully logged out the application

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
