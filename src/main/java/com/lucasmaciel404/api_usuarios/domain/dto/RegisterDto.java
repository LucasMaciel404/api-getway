package com.lucasmaciel404.api_usuarios.domain.dto;

public record RegisterDto(
        String username,
        String role,
        String phone,
        String imageUrl,
        String cep,
        String password,
        Float price
) { }
