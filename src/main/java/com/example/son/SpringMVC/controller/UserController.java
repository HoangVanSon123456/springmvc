package com.example.son.SpringMVC.controller;

import com.example.son.SpringMVC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/listUser";
    }

}
