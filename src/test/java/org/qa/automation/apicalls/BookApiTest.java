package org.qa.automation.apicalls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.qa.automation.restassured.RESTful;

public class BookApiTest {

//    private static final String apiUrl = "https://demoqa.com";
    private static final String apiUrl = "https://reqres.in";
    private static final String dogApiUrl = "https://dog.ceo/api/breeds";

    public static Response postBookRequest(String payload){
        String apiOperation = "/Account/v1/User";
        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(apiUrl);
        req.setBasePath(apiOperation);
        req.setRelaxedHTTPSValidation();
        req.setContentType(ContentType.TEXT);
        req.setAccept(ContentType.JSON);
        req.setBody(payload);
        return RESTful.doPost(req);
    }
    public static Response getDogRequest(){
        String apiOperation = "/api/unknown/2";
        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(apiUrl);
        req.setBasePath(apiOperation);
        req.setRelaxedHTTPSValidation();
        req.setContentType(ContentType.TEXT);
        req.setAccept(ContentType.JSON);
        return RESTful.doGet(req);
    }
}
