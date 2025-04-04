@Regression_Pack @MD-Functional_Login_Feature
Feature: Validating Login page fields for Sauce Labs

  @Login_Feature_Valid
  Scenario Outline: Validating the login screen fields for Sauce Labs with valid credentials
    Given User should be able to login with given parameters username <userName> and password <password>
    When User should be on Login Page
    Then User should validate all the fields
    Examples:
      | userName        | password     |
    ##@externaldata@src/test/resources/data/Datasheet.xlsx@TESTDATA
|locked_out_user|secret_sauce|
