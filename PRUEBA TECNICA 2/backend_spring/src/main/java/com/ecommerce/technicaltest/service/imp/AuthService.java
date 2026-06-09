package com.ecommerce.technicaltest.service.imp;

import com.ecommerce.technicaltest.dao.imp.UserDAOImp;
import com.ecommerce.technicaltest.dto.request.LoginRequest;
import com.ecommerce.technicaltest.dto.request.RegisterUserRequest;
import com.ecommerce.technicaltest.dto.response.LoginResponse;
import com.ecommerce.technicaltest.dto.response.RegisterUserResponse;
import com.ecommerce.technicaltest.service.AuthServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceInterface {

    private final UserDAOImp userdao;

    public AuthService(UserDAOImp userDAO) {
        this.userdao = userDAO;

    }

    @Override
    public RegisterUserResponse RegisterUser(RegisterUserRequest request){

        RegisterUserResponse response = new RegisterUserResponse();





        return response;
    }

    @Override
    public LoginResponse AuthenticateUser(LoginRequest request){
        LoginResponse response = new LoginResponse();
        return response;
    }
}
