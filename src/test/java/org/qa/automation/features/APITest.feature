@Regression_Pack @MD-Functional_BooksApi_Feature
Feature: Validating User API creation

#  @GetData_Feature_Valid
#  Scenario: Validating the User Creation API reponse
#    When User should be to validate the response
#    Then User should validate all the responses

  @GetUser_Api_Gorest
  Scenario: Validating GET GOREST API reponse for Users
    Given User should be to hit the gorest api to get the user response
    Then User should validate the response with specific Id
