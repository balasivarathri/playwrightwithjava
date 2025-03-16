@Login_Regression @MD-Functional_BooksApi_Feature
Feature: Validating User API creation

  @UserCreation_Feature_Valid
  Scenario Outline: Validating the User Creation API reponse
    Given User should be able to login with given parameters payload <payload>
#    When User should be on Login Page
    Then User should validate all the responses
    Examples:
      | payload                                                  |
    ##@externaldata@src/test/resources/data/Datasheet.xlsx@BOOKAPI
|{$$  "userName": "Venki48",$$  "password": "Venki@472"$$}|


  @GetData_Feature_Valid
  Scenario: Validating the User Creation API reponse
    When User should be to validate the response
    Then User should validate all the responses
