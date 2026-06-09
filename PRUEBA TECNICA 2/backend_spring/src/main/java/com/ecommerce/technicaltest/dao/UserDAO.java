package com.ecommerce.technicaltest.dao;

import com.ecommerce.technicaltest.entity.User;

public interface UserDAO {
    public boolean existsByCedula(int cedula);

    public boolean existsByEmail(String email);

    public void createUser(User user);
}
