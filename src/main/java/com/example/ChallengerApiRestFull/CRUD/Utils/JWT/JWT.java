package com.example.ChallengerApiRestFull.CRUD.Utils.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.security.Key;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

public class JWT {
    @Value("${token.secret}")
    private String SECRET_KEY;
    @Value("${token.time}")
    private int TIME;
    private final Key key;

    public JWT() {
        this.key = Keys.hmacShaKeyFor("Challenger".getBytes());
    }

    public String createJwt(String email) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + TIME);

        return Jwts.builder()
                .setSubject(email)
                .setIssuer(this.SECRET_KEY)
                .setExpiration(expirationDate)
                .signWith(this.key)
                .compact();
    }


    public String verifyJwt(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Métodos getter para acceder a SECRET_KEY y TIME si es necesario.
    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public int getTIME() {
        return TIME;
    }
}
