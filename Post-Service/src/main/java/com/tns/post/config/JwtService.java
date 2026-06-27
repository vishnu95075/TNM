package com.tns.post.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey getSigningKey() {
        byte[] key = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String bearerToken) {
        return extractAllClaims(getTokenFromBearer(bearerToken)).getSubject();
    }

    public String extractUserId(String bearerToken) {
        return extractAllClaims(getTokenFromBearer(bearerToken))
                .get("userId", String.class);
    }

    public String extractRole(String bearerToken) {
        return extractAllClaims(getTokenFromBearer(bearerToken))
                .get("role", String.class);
    }

    private String getTokenFromBearer(String authHeader){

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Token missing");
        }

        return authHeader.substring(7);
    }
}
