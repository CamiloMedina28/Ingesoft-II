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
    @Override
    public RegisterUserResponse RegisterUser(RegisterUserRequest request){

        RegisterUserResponse response = new RegisterUserResponse();

        try{
            int cedula = request.getCedula();
            String email = request.getEmail();
            String nombre = request.getNombre();
            String password = request.getPassword();
            String direccion = request.getDireccion();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{

        } catch (Exception e) {
            e.printStackTrace();
        }



        return response;
    }

    @Override
    public LoginResponse AuthenticateUser(LoginRequest request){
        LoginResponse response = new LoginResponse();
        return response;
    }
}
