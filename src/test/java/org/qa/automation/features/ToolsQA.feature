@Regression_Pack1 @Facebook_Registration
Feature: Validating the Facebook Registration fileds

  @Facebook_Registration_Test
  Scenario Outline: Verify that the user can be able to fill the Facebook Registration fileds
    Given User should be able to navigate to the Toolsqa Registration page with url <url>
    When User should be validate all the mandatory fields if user click on Sign Up button without entering the mandatory details firstName <firstName>, surName <surName>
#    And User should be on Sauce Login page
#    And User should be able to see the all items from dropdown
#    And User can be able add the items to the cart
#    And User should be on the cart page to checkout process
#    Then User should successfully logged out the application

Examples:
##@externaldata@src/test/resources/data/Datasheet.xlsx@ToolsQA
| url     | firstName | surName |
| toolsqa | Test      | Tester  |
