@Regression_Pack1 @Quilter_Application
Feature: Validating the Quilter Home Page fileds

  @Quilter_Application_Test
  Scenario Outline: Verify that the user can be able to validate all the Fields on Quilter Home Page
    Given User should be able to navigate to the Quilter page with url <url>
    When User should be validate all the links present on the quilter homepage
#    And User should be on Sauce Login page
#    And User should be able to see the all items from dropdown
#    And User can be able add the items to the cart
#    And User should be on the cart page to checkout process
#    Then User should successfully logged out the application

Examples:
##@externaldata@src/test/resources/data/Datasheet.xlsx@Quiter
| url     | firstName | surName |
| quilter | Test      | Tester  |
