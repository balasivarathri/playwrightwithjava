@MD-Functional_Login_Feature
Feature: Validating Login page fields for salesforce Labs

  @SalesForceLogin_Feature_Valid
  Scenario Outline: Validating the login screen fields for salesforce Labs with valid credentials
    Given User should be able to salesforcelogin with given parameters username <userName> and password <password>
#    When User should be on Login Page
#    Then User should validate all the fields

    Examples:
      ##@externaldata@src/test/resources/data/Datasheet.xlsx@TESTDATA
| userName                      | password  |
| balasivarathri-wuev@force.com | 9959@Bala |

