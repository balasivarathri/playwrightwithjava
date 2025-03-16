package org.qa.automation.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RESTful {

    private static final Logger log = LoggerFactory.getLogger(RESTful.class);

    private RESTful() {
        throw new IllegalStateException("Class methods are static");
    }

    public static String getResponseString(Response response) {
        return response.asString();
    }

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static int getArraySize(Response response, String path) {
        return response.jsonPath().getInt(path);
    }

    public static String getStringValue(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    public static <T> List<T> getArrayValue(Response response, String jsonPath) {
        return response.jsonPath().getList(jsonPath);
    }

    public static Response doGet(RequestSpecBuilder specBuilder) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().get().thenReturn();
        logoutResponseCode(response);
        return response;
    }

    public static Object doGet(RequestSpecBuilder specBuilder, Class<?> pojo) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().get().thenReturn();
        logoutResponseCode(response);
        return response.as(pojo);
    }

    public static Response doPost(RequestSpecBuilder specBuilder) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().post().thenReturn();
        logoutResponseCode(response);
        return response;
    }

    public static Response doDelete(RequestSpecBuilder specBuilder) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().delete().thenReturn();
        logoutResponseCode(response);
        return response;
    }

    public static Response doPut(RequestSpecBuilder specBuilder) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().put().thenReturn();
        logoutResponseCode(response);
        return response;
    }

    public static Response doPatch(RequestSpecBuilder specBuilder) {
        Response response = RestAssured.given().spec(specBuilder.build()).log().uri().log().method().log().body().patch().thenReturn();
        logoutResponseCode(response);
        return response;
    }

    private static void logoutStartOfCall() {
        log.info("Initializing Web Service Call.");
    }


    private static void logoutResponseCode(Response response) {
        int responseCode = response.getStatusCode();
        if (responseCode == 200) {
            log.info("Service call response code : " + responseCode);
        } else {
            log.warn("Service call response code : " + responseCode);

        }
    }
}