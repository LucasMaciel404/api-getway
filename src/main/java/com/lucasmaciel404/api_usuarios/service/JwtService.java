package com.lucasmaciel404.api_usuarios.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private static final String SECRET = "minha_chave_secreta_super_segura";
    private static final String ISSUER = "minha-api";

    public String generateToken(String username, List<String> roles) {
        return JWT.create()
                .withSubject(username) // usuario do token
                .withIssuer(ISSUER) // quem criou
                .withAudience("meu-front") // para quem é válido
                .withClaim("roles", roles)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // expira em 1 hora
                .sign(Algorithm.HMAC256(SECRET));
    }

    // Valida e retorna os dados do token
    public String validateToken(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER) // valida o issuer
                .withAudience("meu-front") // valida o audience
                .build()
                .verify(token);

        return jwt.getSubject(); // retorna o username
    }
}
