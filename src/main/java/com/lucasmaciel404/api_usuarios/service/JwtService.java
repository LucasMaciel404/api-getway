package com.lucasmaciel404.api_usuarios.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.auth0.jwt.RegisteredClaims.AUDIENCE;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.issuer}")
    private String ISSUER;

    @Value("${jwt.audience}")
    private String AUDIENCE;

    @Value("${jwt.expiration}")
    private long EXPIRATION;


    public String generateToken(String username, List<String> roles) {
        return JWT.create()
                .withSubject(username)
                .withIssuer(ISSUER)
                .withAudience(AUDIENCE)
                .withClaim("roles", roles)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String validateToken(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER) // valida o issuer
                .withAudience(AUDIENCE) // valida o audience
                .build()
                .verify(token);

        return jwt.getSubject();
    }

    private DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER)
                .withAudience(AUDIENCE)
                .build()
                .verify(token);
    }
    public String getUsername(String token) {
        return decodeToken(token).getSubject();
    }

    // Pega as roles do token
    public List<String> getRoles(String token) {
        return decodeToken(token).getClaim("roles").asList(String.class);
    }
}
