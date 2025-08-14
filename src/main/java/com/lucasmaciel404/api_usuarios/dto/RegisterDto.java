package com.lucasmaciel404.api_usuarios.dto;

public record RegisterDto(
        String username,
        String role,
        String phone,
        String imageUrl,
        String cep,
        String password,
        Float price
) { }
