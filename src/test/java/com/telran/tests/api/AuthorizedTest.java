package com.telran.tests.api;

import com.telran.tests.api.factory.LoginViewModelFactory;
import com.telran.tests.api.model.LoginViewDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizedTest extends ApiBase{
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    Response response;

    @Test
    public void authizedTest(){
        response = doPostRequest(loginViewDto, AUTHORIZED_END_POINT, 200);
       Assert.assertTrue(response.asString().contains("true"));
    }
}
