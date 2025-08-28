package com.lucasmaciel404.api_usuarios.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String role;
    private String phone;
    private String imageUrl;
    private String cep;
    private String hash;
    private LocalDateTime createdAt;
    private Float price;
}
