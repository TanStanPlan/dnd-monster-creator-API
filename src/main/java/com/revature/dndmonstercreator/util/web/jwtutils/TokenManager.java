package com.revature.dndmonstercreator.util.web.jwtutils;

import com.revature.dndmonstercreator.util.web.DTO.response.Principal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class TokenManager implements Serializable {

    private static final long serialVersionUID = 5018905124389347049L;

    public static final long TOKEN_VALIDITY = 10 * 60 * 60; //@Value("${secret}")

    @Value("${jwt.secret}")
    private String jwtSecret;



    public String generateJwtToken(Principal user){
        return Jwts.builder().setSubject(user.getEmail()).setId(String.valueOf(user.getId()))
                .claim("userId", user.getId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    public Boolean validateJwtToken(String token){
        String user = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Boolean isTokenExpired = claims.getExpiration().before(new Date());
        return isTokenExpired;
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Integer getUserId(String token){
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.get("userId", Integer.class);
    }



}
