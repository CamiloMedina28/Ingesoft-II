package com.ecommerce.technicaltest.service;

import com.ecommerce.technicaltest.dto.request.LoginRequest;
import com.ecommerce.technicaltest.dto.request.RegisterUserRequest;
import com.ecommerce.technicaltest.dto.response.LoginResponse;
import com.ecommerce.technicaltest.dto.response.RegisterUserResponse;

public interface AuthServiceInterface {
    public RegisterUserResponse RegisterUser(RegisterUserRequest request);

    public LoginResponse AuthenticateUser(LoginRequest request);
}
