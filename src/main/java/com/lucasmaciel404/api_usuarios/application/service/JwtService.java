package com.lucasmaciel404.api_usuarios.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

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

    public void validateToken(String token) {
        try{
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                    .withIssuer(ISSUER) // valida o issuer
                    .withAudience(AUDIENCE) // valida o audience
                    .build()
                    .verify(token);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token invalido ou expirado");
        }
    }

    private DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER)
                .withAudience(AUDIENCE)
                .build()
                .verify(token);
    }
    public long getRemainingTime(String token) {
        Date expiration = decodeToken(token).getExpiresAt();
        return expiration.getTime() - System.currentTimeMillis();
    }

    public String getUsername(String token) {
        return decodeToken(token).getSubject();
    }

    // Pega as roles do token
    public List<String> getRoles(String token) {
        return decodeToken(token).getClaim("roles").asList(String.class);
    }
}
