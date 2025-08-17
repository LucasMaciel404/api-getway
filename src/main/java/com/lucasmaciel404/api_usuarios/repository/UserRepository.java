package com.lucasmaciel404.api_usuarios.repository;

import com.lucasmaciel404.api_usuarios.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByPhone(String phone);

    User findByUsername(String username);
}
