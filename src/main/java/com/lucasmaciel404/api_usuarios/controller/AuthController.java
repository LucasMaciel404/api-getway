package com.lucasmaciel404.api_usuarios.controller;

import com.lucasmaciel404.api_usuarios.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public void getAllUsers(){
        userService.getAllUsers();
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto body){ }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto body){
        userService.register(body);
    }
}
