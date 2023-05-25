package com.telran.tests.api;

import com.github.javafaker.Faker;
import com.telran.tests.api.factory.LoginViewModelFactory;
import com.telran.tests.api.model.LoginViewDto;
import com.telran.tests.api.model.TokenViewDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiBase {

    protected Faker faker = new Faker();
    private final String BASE_URL = "https://demoqa.com";
    private final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFkbWluMjIiLCJwYXNzd29yZCI6IlF3ZXJ0eUAxMjM0NSIsImlhdCI6MTY4NDE0NTA3MH0.KVrfbbc_4ESM84pTNYTa5Fl7adKPWe1mRU55GX_-zJI";

    protected final String  AUTHORIZED_END_POINT = "/Account/v1/Authorized";

    protected final String GENERATE_TOKEN_END_POINT = "/Account/v1/GenerateToken";

    //private String api_key = getToken();


    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();


    public Response doPostRequest (Object body, String endPoint, Integer statusCode) {
        Response resp = given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().statusCode(statusCode);
        return resp;
    }
//    public String getToken() {
//        LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
//        LoginViewDto loginViewDto = loginViewModelFactory.getObject();
//        TokenViewDto tokenViewModel = given()
//                .body(loginViewDto)
//                .post(GENERATE_TOKEN_END_POINT)
//                .then()
//                .extract()
//                .response()
//                .as(TokenViewDto.class);
//        return tokenViewModel.getToken();
//
//    }

}
