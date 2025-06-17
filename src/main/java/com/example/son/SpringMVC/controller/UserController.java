package com.example.son.SpringMVC.controller;

import com.example.son.SpringMVC.dto.UserDTO;
import com.example.son.SpringMVC.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("userDto", new UserDTO());
        return "user/userForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("userDto") UserDTO userDto, BindingResult result,
                       Model model) {
        if (result.hasErrors()) {
            return "user/userForm";
        }
        userService.add(userDto);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        UserDTO dto = userService.findById(id);
        if (dto == null) return "redirect:/users"; // hoặc return 404 page
        model.addAttribute("userDto", dto);
        return "user/userForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("userDto") UserDTO userDto, Model model) {
        userService.update(userDto);
        return "redirect:/users";
    }


}
