package com.ecommerce.technicaltest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "El correo electrónico es obligatorio para el inicio de sesión")
    @Email(message = "El formato de correo electrónico no es correcto")
    private String email;

    @NotBlank(message = "Se requiere el ingresio de una contraseña")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
