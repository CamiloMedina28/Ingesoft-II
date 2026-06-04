package com.ecommerce.technicaltest.entity;

import java.time.LocalDateTime;

public class User {

    private int cedula;
    private String nombre;
    private String email;
    private String password;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
    private Rol rol;
    private String direccion;

    public User(int cedula, String nombre, String email, String password, LocalDateTime creado, LocalDateTime actualizado, Rol rol, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.creado = creado;
        this.actualizado = actualizado;
        this.rol = rol;
        this.direccion = direccion;
    }

    public User() {
    }

    public int getcedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setcedula(int cedula) {
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public LocalDateTime getActualizado() {
        return actualizado;
    }

    public void setActualizado(LocalDateTime actualizado) {
        this.actualizado = actualizado;
    }
}
