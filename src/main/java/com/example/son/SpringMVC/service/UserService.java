package com.example.son.SpringMVC.service;

import com.example.son.SpringMVC.dto.UserDTO;
import com.example.son.SpringMVC.entity.User;

import java.util.List;

public interface UserService {

    void add(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(int id);

    List<UserDTO> findAll();

    UserDTO findById(int id);


}
