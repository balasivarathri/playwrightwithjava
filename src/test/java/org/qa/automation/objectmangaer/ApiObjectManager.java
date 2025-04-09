package org.qa.automation.objectmangaer;

import com.microsoft.playwright.APIRequestContext;
import org.qa.automation.apimethods.GetApiCall;

public class ApiObjectManager {

    public APIRequestContext apiRequestContext;
    public GetApiCall getApiCall;

    public ApiObjectManager(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }

    public GetApiCall getApiCall() {
        getApiCall = new GetApiCall(apiRequestContext);
        return getApiCall;
    }
}
