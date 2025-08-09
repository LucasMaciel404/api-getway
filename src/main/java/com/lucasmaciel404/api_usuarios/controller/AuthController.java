package com.lucasmaciel404.api_usuarios.controller;

import com.lucasmaciel404.api_usuarios.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
public class AuthController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public void login(@RequestBody LoginDto login){ }

    @RequestMapping("/register")
    public void register(@RequestBody RegisterDto register){ }
}
