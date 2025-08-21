package com.lucasmaciel404.api_usuarios.controller;

import com.lucasmaciel404.api_usuarios.domain.User;
import com.lucasmaciel404.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
