package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.apis.bookerapis.BookerUserApiCall;
import org.qa.automation.contextsetup.ApiContextSetup;

import java.io.IOException;

@Slf4j
public class BookerUserAPITest extends TestBase {

    ApiContextSetup apiContextSetup;
    BookerUserApiCall bookerUserApiCall;
    int bookingId;

    public BookerUserAPITest(ApiContextSetup apiContextSetup) {
        this.apiContextSetup = apiContextSetup;
    }

    @Given("User should be hit the booker user API to get the token")
    public void user_should_be_hit_the_booker_user_api_to_get_the_token() throws IOException {
        bookerUserApiCall = apiContextSetup.apiObjectManager.bookerUserApiCall();
        bookerUserApiCall.generateBookerToken();
    }

    @Then("User should be hit the POST Booker User API and verify user has been created")
    public void user_should_be_hit_post_booker_user_api_and_verify_user_has_been_created() throws IOException {
        bookerUserApiCall.postBookerUserApi();
    }
    @Then("User should be validate all the fields for booker API and verify user has been created")
    public void user_should_be_validate_all_the_fields_for_booker_api_and_verify_user_has_been_created() throws IOException {
        bookingId = bookerUserApiCall.validateBookerPostApiResponse();
    }
    @Given("^User should be to hit the Booker api to get the user response$")
    public void user_should_be_to_hit_the_booker_api_to_get_the_user_response() throws IOException {
        bookerUserApiCall.getBookerUser(bookingId);
    }
    @Given("^User should be to hit the Booker api to get for all users response$")
    public void user_should_be_to_hit_the_booker_api_to_get_for_all_users_response() throws IOException {
        bookerUserApiCall.getBookerForAllUsers();
    }
    @Given("^User should be able to update the specific Booker user$")
    public void user_should_be_able_to_update_the_specific_booker_user() throws IOException {
        bookerUserApiCall.updateBookerUser(bookingId);
    }
//
//    @Given("^User should be able to delete the updated user$")
//    public void user_should_be_able_to_delete_the_updated_user() {
//        userApiCall.deleteUser(idNumber);
//    }
}