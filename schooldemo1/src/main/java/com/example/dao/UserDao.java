package com.example.dao;

import com.example.user.User;
import com.example.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser){
        //return null;
        try {
            String sql = "select * from users where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            System.out.println("user get");
            return user;
        }catch(DataAccessException e){
            e.printStackTrace();
            System.out.println("none");
            return null;
        }
    }
}
