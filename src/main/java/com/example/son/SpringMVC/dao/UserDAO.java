package com.example.son.SpringMVC.dao;

import com.example.son.SpringMVC.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();

    User findById(int id);

}
