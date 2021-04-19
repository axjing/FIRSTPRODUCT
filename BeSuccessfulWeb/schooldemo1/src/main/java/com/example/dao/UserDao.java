package com.example.dao;



import com.example.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username,String password);

    void add(User user);

    void delete(int parseInt);

    User findById(int id);

    void update(User user);

    int findTotalCount();

    List<User> findByPage(int start, int rows);

    User login(User loginUser);
}
