package com.telran.tests.api.factory;

import com.telran.tests.api.model.LoginViewDto;

public class LoginViewModelFactory implements BoolStoreFactory {

    @Override
    public LoginViewDto getObject() {
        return LoginViewDto.builder()
                .userName("newproject@gmail.com")
                .password("123456Rt!")
                .build();
    }

    public LoginViewDto getObject(String userName, String password) {
        return LoginViewDto.builder()
                .userName(userName)
                .password(password)
                .build();
    }

}
