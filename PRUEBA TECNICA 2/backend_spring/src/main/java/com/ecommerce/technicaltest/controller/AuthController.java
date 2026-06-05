package com.ecommerce.technicaltest.controller;

import com.ecommerce.technicaltest.dto.request.LoginRequest;
import com.ecommerce.technicaltest.dto.request.RegisterUserRequest;
import com.ecommerce.technicaltest.dto.response.ApiResponse;
import com.ecommerce.technicaltest.dto.response.LoginResponse;
import com.ecommerce.technicaltest.dto.response.RegisterUserResponse;
import com.ecommerce.technicaltest.service.imp.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService register = new AuthService();

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterUserResponse>> register(@RequestBody RegisterUserRequest request){
        RegisterUserResponse response = register.RegisterUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        201,
                        "Usuario registrado exitosamente",
                        response
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> LogIn(@RequestBody LoginRequest request){
        LoginResponse response = register.AuthenticateUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        201,
                        "Usuario creado de manera exitosa",
                        response
                )
        );
    }
}
