package com.ecommerce.technicaltest.service;

import com.ecommerce.technicaltest.dto.request.LoginRequest;
import com.ecommerce.technicaltest.dto.request.RegisterUserRequest;
import com.ecommerce.technicaltest.dto.response.LoginResponse;
import com.ecommerce.technicaltest.dto.response.RegisterUserResponse;

public class AuthService implements AuthServiceInterface{
    public RegisterUserResponse RegisterUser(RegisterUserRequest request){
        RegisterUserResponse response = new RegisterUserResponse();
        return response;
    }

    public LoginResponse AuthenticateUser(LoginRequest request){
        LoginResponse response = new LoginResponse();
        return response;
    }
}
