package com.example.dao.impl;


import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    //private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> users=template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    public User findUserByUsernameAndPassword(String username,String password){
        try {
            String sql = "select * from user where username=? and password=?";
            User user = (User) template.query(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void add(User user){
        String sql="insert into user values(null,?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getGender());
    }

    @Override
    public void delete(int parseInt) {
        String sql="delete from user where id = ?";
        template.update(sql,parseInt);
    }

    @Override
    public User findById(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }

    @Override
    public int findTotalCount() {
        String sql="select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql="select * from user limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }

    @Override
    public User login(User loginUser) {
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
