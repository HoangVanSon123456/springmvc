package com.example.son.SpringMVC.service;

import com.example.son.SpringMVC.dto.UserDTO;

import java.util.List;

public interface UserService {

    void add(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(Integer id);

    List<UserDTO> findAll();

    UserDTO findById(Integer id);


}
