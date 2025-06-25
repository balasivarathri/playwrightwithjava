package org.qa.automation.objectmangaer;

import com.microsoft.playwright.APIRequestContext;
import org.qa.automation.apis.apimethods.GetApiCall;
import org.qa.automation.apis.apimethods.PostApiCall;
import org.qa.automation.apis.apimethods.UserApiCall;
import org.qa.automation.apis.bookerapis.BookerUserApiCall;
import org.qa.automation.apis.swiftapis.SwiftPaymentPostApiCall;
import org.qa.automation.stepdefinitions.SwiftPaymentsApis;

public class ApiObjectManager {

    public APIRequestContext apiRequestContext;
    public GetApiCall getApiCall;
    public PostApiCall postApiCall;
    public UserApiCall userApiCall;
    public BookerUserApiCall bookerUserApiCall;
    public SwiftPaymentPostApiCall swiftPaymentPostApiCall;

    public ApiObjectManager(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }

    public GetApiCall getApiCall() {
        getApiCall = new GetApiCall(apiRequestContext);
        return getApiCall;
    }
    public PostApiCall postApiCall() {
        postApiCall = new PostApiCall(apiRequestContext);
        return postApiCall;
    }
    public UserApiCall userApiCall() {
        userApiCall = new UserApiCall(apiRequestContext);
        return userApiCall;
    }
    public BookerUserApiCall bookerUserApiCall() {
        bookerUserApiCall = new BookerUserApiCall(apiRequestContext);
        return bookerUserApiCall;
    }
    public SwiftPaymentPostApiCall swiftPaymentPostApiCall() {
        swiftPaymentPostApiCall = new SwiftPaymentPostApiCall(apiRequestContext);
        return swiftPaymentPostApiCall;
    }
}