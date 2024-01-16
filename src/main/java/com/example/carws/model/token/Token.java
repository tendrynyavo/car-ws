package com.example.carws.model.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.nio.file.AccessDeniedException;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import com.example.carws.model.users.Users;

import java.util.Date;

@Component
public class Token {

    private static Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static long expiryDuration = 200 * 60;

    public String generateJwt(Users user) {

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        return Jwts.builder()
                .claim("id", user.getId())
                .setSubject(user.getMail())
                .setExpiration(expiryAt)
                .signWith(secret)
                .compact();
    }

    public Claims verify(String token) throws Exception {

        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new AccessDeniedException("Acces refuse");
        }

    }
}