package com.lucasmaciel404.api_usuarios.controller;

import com.lucasmaciel404.api_usuarios.domain.User;
import com.lucasmaciel404.api_usuarios.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto body){
        userService.login(body);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto body){
        userService.register(body);
    }
}
/*
 * Bom lembrar que tem o JWT para as rotas que nao estejam em "/Auth/*"
 * lembrete pessoal para minha aminezia :)
 */