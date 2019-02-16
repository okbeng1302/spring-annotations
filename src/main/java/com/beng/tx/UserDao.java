package com.beng.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "insert into `user` (username,sex) values (?,?)";
        jdbcTemplate.update(sql, "xiaobai", "男");
    }
}
