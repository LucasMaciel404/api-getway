package com.lucasmaciel404.api_usuarios.application.service;

import com.lucasmaciel404.api_usuarios.domain.model.User;
import com.lucasmaciel404.api_usuarios.domain.dto.LoginDto;
import com.lucasmaciel404.api_usuarios.domain.dto.RegisterDto;
import com.lucasmaciel404.api_usuarios.persistence.repository.UserRepository;
import com.lucasmaciel404.api_usuarios.domain.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public TokenResponse login(LoginDto loginDto) {
        User usuario = userRepository.findByPhone(loginDto.phone());
        boolean matchLogin = passwordEncoder.matches(loginDto.password(), usuario.getHash());
        if (matchLogin) {
            List<String> roles = List.of(usuario.getRole().split(" ")); // "ROLE_ADMIN", "ROLE_USER", "ROLE_MANICURE"
            String token = jwtService.generateToken(usuario.getUsername(), roles);
            long expirationTime = jwtService.getRemainingTime(token);
            return new TokenResponse(token, expirationTime);
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

    public boolean existUserWhithPhone(String phone){
        return userRepository.findByPhone(phone) != null ? true : false;
    }
}
