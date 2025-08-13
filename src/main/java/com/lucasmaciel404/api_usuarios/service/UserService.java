package com.lucasmaciel404.api_usuarios.service;

import com.lucasmaciel404.api_usuarios.domain.User;
import com.lucasmaciel404.api_usuarios.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void login(LoginDto login) {
    }

    public void register(RegisterDto register) {
        User user = new User(null, register.username(), register.role(), register.phone(), register.imageUrl(), register.cep(), register.password(), register.password(), LocalDateTime.now(), register.price());
        userRepository.save(user);
    }
}
