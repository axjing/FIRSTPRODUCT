package com.example.service;



import com.example.domain.PageBean;
import com.example.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User login(User user);

    void addUser(User user);
    void deleteUser(String id);
    User findUserById(String id);
    void updateUser(User user);
    void deleteSelectedUser(String[] ids);
    PageBean<User> findUserByPage(String currentPage, String rows);
}
