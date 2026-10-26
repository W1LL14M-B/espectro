package com.william.conectivida.espectro.conectividad_espectro.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {  
    
    @Value("${app.jwt.secret}")
    private String secret;
    
    @Value("${app.jwt.expiration-ms}")
    private long expiration;
    
    private Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
    
    public String generarToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    
    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build()
            .parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) { return false; }
    }
}