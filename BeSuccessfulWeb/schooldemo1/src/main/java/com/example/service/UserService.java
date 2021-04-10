package com.example.service;

import com.example.dao.UserDao;
import com.example.user.User;

import java.util.List;

public class UserService {
    private UserDao dao = new UserDao();

    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
}
