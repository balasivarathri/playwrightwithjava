package org.qa.automation.objectmangaer;

import com.microsoft.playwright.APIRequestContext;
import org.qa.automation.apimethods.GetApiCall;
import org.qa.automation.apimethods.PostApiCall;

public class ApiObjectManager {

    public APIRequestContext apiRequestContext;
    public GetApiCall getApiCall;
    public PostApiCall postApiCall;

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
}
