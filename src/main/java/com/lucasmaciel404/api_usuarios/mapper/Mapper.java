package com.lucasmaciel404.api_usuarios.mapper;

import com.lucasmaciel404.api_usuarios.domain.User;
import com.lucasmaciel404.api_usuarios.response.UserResponse;

public class Mapper {
    public static UserResponse userToUserResponse(User usuario){
        return new UserResponse(usuario.getUsername(), usuario.getPhone(), usuario.getImageUrl(), usuario.getCep(), usuario.getRole(), usuario.getPrice());
    }
}
