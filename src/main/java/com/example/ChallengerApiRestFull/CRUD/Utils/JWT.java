package com.example.ChallengerApiRestFull.CRUD.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;


import java.util.Date;

public class JWT {

    @Value("${token.secret}")
    private static String SECRET_KEY;

    @Value("${token.time}")
    private static int TIME;

    public static String createJwt(String email) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + TIME);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }

    public static String verifyJwt(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        return claims.getBody().getSubject();
    }
}
