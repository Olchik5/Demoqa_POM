package com.telran.tests.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginViewDto {

    private String userName;
    private String password;
}
