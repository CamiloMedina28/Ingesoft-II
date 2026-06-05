package com.ecommerce.technicaltest.dao;

public interface UserDAO {
    public boolean existsByCedula(int cedula);

    public boolean existsByEmail(String email);
}
