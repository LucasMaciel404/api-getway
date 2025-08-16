package com.lucasmaciel404.api_usuarios.service;

import com.lucasmaciel404.api_usuarios.domain.User;
import com.lucasmaciel404.api_usuarios.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String login(LoginDto loginDto) {
        User usuario = userRepository.findByPhone(loginDto.phone());

        if (usuario != null && usuario.getHash().equals(loginDto.password())) {
            return "Token";
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais invalidas");
        }
    }

    public void register(RegisterDto registerDto) {
        User user = new User(null,
                registerDto.username(),
                registerDto.role(),
                registerDto.phone(),
                registerDto.imageUrl(),
                registerDto.cep(),
                passwordEncoder.encode(registerDto.password()), // esse hash possui o salt imbutido.
                LocalDateTime.now(),
                registerDto.price());

        userRepository.save(user);
    }
}
