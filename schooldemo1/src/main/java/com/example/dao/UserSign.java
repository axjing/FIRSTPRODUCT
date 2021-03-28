package com.example.dao;

import com.example.user.User;
import com.example.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//@WebServlet("")
public class UserSign {
    //private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public int sign(User signinUser){
        //return null;
        try {
            //String sql = "select * from users where username = ? and password = ?";
            //String sql="insert into users(username,password) values(?,?)";
            String sql="insert into users values(default,?,?)";
            int user = template.update(sql,
                    signinUser.getUsername(), signinUser.getPassword());
            System.out.println("user get");
            return user;
        }catch(DataAccessException e){
            e.printStackTrace();
            System.out.println("none");
            return 0;
        }
    }
}