package com.lucasmaciel404.api_usuarios.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    private UUID id;
    private String username;
    private String role;
    private Integer phone;
    private String imageUrl;
    private String cep;
    private String hash;
    private String salt;
    private LocalDateTime createdAt;
    private Float price;
}
