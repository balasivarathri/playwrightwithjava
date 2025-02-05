@Login_Regression @MD-Functional_Login_Feature
Feature: Validating Login page fields for Sauce Labs

  @Login_Feature_Valid
  Scenario Outline: Validating the login screen fields for Sauce Labs with valid credentials
    Given User should be able to login with given parameters username <userName> and password <password>
    When User should be on Login Page
    Then User should validate all the fields
    Examples:
      | userName        | password     |
    ##@externaldata@src/test/resources/data/Datasheet.xlsx@TESTDATA
|standard_user|secret_sauce|
|locked_out_user|secret_sauce|

#  @Login_Feature_Invalid
#  Scenario Outline: Validating the login screen fields for Sauce Labs with valid credentials
#    Given User should be able to login with given parameters username <username> and password <password>
#    When User should be on Login Page
#    Then User should validate all the fields
#    Examples:
#      | username        | password     |
#      | locked_out_user | secret_sauce |
