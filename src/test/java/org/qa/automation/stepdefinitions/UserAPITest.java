package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.apis.apimethods.UserApiCall;
import org.qa.automation.base.TestBase;
import org.qa.automation.contextsetup.ApiContextSetup;

import java.io.IOException;

@Slf4j
public class UserAPITest extends TestBase {

    ApiContextSetup apiContextSetup;
    UserApiCall userApiCall;
    int idNumber;

    public UserAPITest(ApiContextSetup apiContextSetup) {
        this.apiContextSetup = apiContextSetup;
    }

    @Given("User should be hit the generate JWT API to get the token")
    public void user_should_be_hit_the_generate_jwt_api_to_get_the_token() throws IOException {
        userApiCall = apiContextSetup.apiObjectManager.userApiCall();
        userApiCall.generateToken();
    }

    @Then("User should be hit the POST user API and verify user has been created")
    public void user_should_be_hit_post_user_api_and_verify_user_has_been_created() throws IOException {
        userApiCall.postUserApi();
    }
    @Then("User should be validate all the fields and verify user has been created")
    public void user_should_be_validate_all_the_fields_and_verify_user_has_been_created() throws IOException {
        idNumber = userApiCall.validatePostApiResponse();
    }
    @Given("^User should be to hit the user api to get the user response$")
    public void user_should_be_to_hit_the_user_api_to_get_the_user_response() throws IOException {
        userApiCall.getUser(idNumber);
    }
    @Given("^User should be able to update the specific user$")
    public void user_should_be_able_to_update_the_specific_user() throws IOException {
        userApiCall.updateUser(idNumber);
    }

    @Given("^User should be able to delete the updated user$")
    public void user_should_be_able_to_delete_the_updated_user() {
        userApiCall.deleteUser(idNumber);
    }
}