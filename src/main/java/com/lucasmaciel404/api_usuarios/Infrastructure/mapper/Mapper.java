package com.lucasmaciel404.api_usuarios.Infrastructure.mapper;

import com.lucasmaciel404.api_usuarios.domain.model.User;
import com.lucasmaciel404.api_usuarios.domain.response.UserResponse;

public class Mapper {
    public static UserResponse userToUserResponse(User usuario){
        return new UserResponse(usuario.getUsername(), usuario.getPhone(), usuario.getImageUrl(), usuario.getCep(), usuario.getRole(), usuario.getPrice());
    }
}
