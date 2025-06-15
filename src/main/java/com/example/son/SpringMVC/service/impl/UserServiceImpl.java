package com.example.son.SpringMVC.service.impl;

import com.example.son.SpringMVC.dao.UserDAO;
import com.example.son.SpringMVC.dto.UserDTO;
import com.example.son.SpringMVC.entity.User;
import com.example.son.SpringMVC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor // ✅ Lombok tự sinh constructor với field final
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public void add(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setAddress(userDTO.getAddress());
        user.setBirthdate(userDTO.getBirthdate());
        userDAO.add(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = userDAO.findById(userDTO.getId());
        if(user != null) {
            user.setName(userDTO.getName());
            user.setGender(userDTO.getGender());
            user.setAddress(userDTO.getAddress());
            user.setBirthdate(userDTO.getBirthdate());
            userDAO.update(user);
        }
    }

    @Override
    public void delete(int id) {
        User user = userDAO.findById(id);
        if (user != null) {
            userDAO.delete(user);
        }
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userDTOS.add(convertToDTO(user));
        }
        return userDTOS;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setGender(user.getGender());
        userDTO.setAddress(user.getAddress());
        userDTO.setBirthdate(user.getBirthdate());
        return userDTO;
    }

    @Override
    public UserDTO findById(int id) {
        User user = userDAO.findById(id);
        if (user != null) {
            return convertToDTO(user);
        }
        return null;
    }
}
