package com.example.dao;

import com.example.domain.User;
import com.example.util.JDBCUtils;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

//@WebServlet("")
public class UserSign {
    //private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public int sign(User signinUser){
        //return null;
        try {
            //String sql = "select * from users where username = ? and password = ?";
            //String sql="insert into users(username,password) values(?,?)";
            //System.out.println(signinUser);
            String sql="insert into user values(default,?,?,?,?,?,?,?,?)";
            int user = template.update(sql,
                    signinUser.getName(),signinUser.getAge(),signinUser.getAddress(),signinUser.getQq(),signinUser.getEmail(),signinUser.getGender(),signinUser.getUsername(), signinUser.getPassword());
            System.out.println("user get");
            return user;
        }catch(DataAccessException e){
            e.printStackTrace();
            System.out.println("none");
            return 0;
        }
    }
}