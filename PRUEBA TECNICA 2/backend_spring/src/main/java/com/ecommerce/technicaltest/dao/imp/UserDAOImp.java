package com.ecommerce.technicaltest.dao.imp;

import com.ecommerce.technicaltest.dao.UserDAO;
import com.ecommerce.technicaltest.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UserDAOImp implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean existsByCedula(int cedula){
        String sql = "SELECT COUNT(*) FROM user WHERE cedula = ?";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                cedula
        );

        return count != null && count > 0;
    }

    @Override
    public boolean existsByEmail(String email){
        String sql = "SELECT COUNT(*) FROM user WHERE email = ?";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                email
        );
        return count != null && count > 0;
    }

    @Override
    public void createUser(User user){
        int cedula = user.getcedula();
        String nombre = user.getNombre();
        String email = user.getEmail();
        String password = user.getPassword();
        LocalDateTime date = LocalDateTime.now();
        String rol = "CLIENTE";
        String direccion = user.getDireccion();


        String sql = "INSERT INTO user(cedula, nombre, email, password, creado, actualizado, rol, direccion) VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                sql,
                cedula,
                nombre,
                email,
                password,
                date,
                date,
                rol,
                direccion
        );
    }
}
