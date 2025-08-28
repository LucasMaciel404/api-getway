package com.lucasmaciel404.api_usuarios.presentation.controller;

import com.lucasmaciel404.api_usuarios.domain.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.domain.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.domain.response.TokenResponse;
import com.lucasmaciel404.api_usuarios.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PostMapping("/register")
    public TokenResponse register(@RequestBody RegisterDto registerDto){

        boolean userExist = userService.existUserWhithPhone(registerDto.phone());
        if (userExist) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja existente");

        userService.register(registerDto);

        return this.login(new LoginDto(registerDto.phone(), registerDto.password()));
    }
}
/*
 * Bom lembrar que tem o JWT para as rotas que nao estejam em "/Auth/*"
 * lembrete pessoal para minha aminezia :)
 */