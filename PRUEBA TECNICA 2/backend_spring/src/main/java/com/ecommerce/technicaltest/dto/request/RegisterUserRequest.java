package com.ecommerce.technicaltest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {
    @NotBlank(message = "El número de cédula debe ser ingresado")
    private int cedula;

    @NotBlank(message = "El nombre debe ser ingresado")
    private String nombre;

    @NotBlank(message = "El correo electrónico debe ser ingresado")
    @Email(message = "El formato de correo electrónico no es correcto")
    private String email;

    @NotBlank(message = "Se debe ingresar una contraseña")
    @Size(min = 8, message = "La contraseña debe tener al menos ocho caracteres")
    private String password;

    @NotBlank(message = "La dirección de residencia debe ser ingresada")
    private String direccion;

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(int cedula, String nombre, String email, String password, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
