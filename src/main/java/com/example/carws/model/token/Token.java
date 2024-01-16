package com.example.carws.model.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
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

    private static String secret = "conexionKely";
    private static long expiryDuration = 20 * 60;

    // public String generateJwt(Users user) {

    //     long milliTime = System.currentTimeMillis();
    //     long expiryTime = milliTime + expiryDuration * 1000;

    //     Date issuedAt = new Date(milliTime);
    //     Date expiryAt = new Date(expiryTime);

        // claims
        DefaultClaims claims = new DefaultClaims();
        claims.setIssuer(user.getId());
        claims.setIssuedAt(issuedAt);
        claims.setExpiration(expiryAt);

        // Ajouter des claims optionnels
        claims.put("id", user.getId());
        // optional claims
        claims.put("id", user.getId());

        // generate jwt using claims
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch (Exception e) {
            throw new AccessDeniedException("Acces refuse");
        }

    // }
}