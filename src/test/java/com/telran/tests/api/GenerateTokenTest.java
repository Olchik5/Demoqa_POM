package com.telran.tests.api;

import com.telran.tests.api.factory.LoginViewModelFactory;
import com.telran.tests.api.model.ExampleTokenDto;
import com.telran.tests.api.model.LoginViewDto;
import com.telran.tests.api.model.TokenViewDto;
import io.restassured.response.Response;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTokenTest extends ApiBase {

    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    TokenViewDto tokenViewModel;
    Response response;

    Date date = DateUtils.addDays(new Date(), 7);
    Date dateTime = DateUtils.addHours(date, -2);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    String expectedDate = formatter.format(dateTime);

    Date dateExample = DateUtils.addDays(new Date(), 7);
    String expectedExampleDate = formatter.format(dateExample);

    @Test
    public void generateTokenTest(){
        System.out.println(expectedDate);
        response = doPostRequest(loginViewDto, GENERATE_TOKEN_END_POINT, 200);
        tokenViewModel = response.as(TokenViewDto.class);
        Assert.assertNotNull(tokenViewModel.getToken());
        Assert.assertTrue(tokenViewModel.getExpires().contains(expectedDate));
        Assert.assertEquals(tokenViewModel.getStatus(),"Success");
        Assert.assertEquals(tokenViewModel.getResult(),"User authorized successfully.");

    }
    @Test
    public void dateTest(){
        response = doPostRequest(loginViewDto, GENERATE_TOKEN_END_POINT, 200);
        ExampleTokenDto exampleTokenDto = response.as(ExampleTokenDto.class);
        //Assert.assertEquals(exampleTokenDto.getExpires(),date);
        Assert.assertEquals(formatter.format(exampleTokenDto.getExpires()), expectedExampleDate);

    }
}
