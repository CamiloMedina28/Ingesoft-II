package com.ecommerce.technicaltest.dao.imp;

import com.ecommerce.technicaltest.dao.UserDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
