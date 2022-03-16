package com.fedpet.utils;

import com.fedpet.entities.User;
import com.fedpet.security.authentication.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtHelper {
    @Value("${jwt.secret}")
    private String secret;

    public String getToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("firstname", user.getFirstname());
        claims.put("lastName", user.getLastname());

        Date date = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date currentDatePlusOne = c.getTime();

        String token = Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuer("petfedapp")
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(currentDatePlusOne)
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
        return token;
    }

    public UserInfo validate(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return  getUserInfo(claims);
    }
    UserInfo getUserInfo(Claims claims){
        UserInfo user= new UserInfo();
        user.setId(Integer.parseInt(claims.getSubject()));
        user.setUserName(String.valueOf(claims.get("username")));
        user.setFirstName(String.valueOf(claims.get("firstname")));
        user.setLastName(String.valueOf(claims.get("lastName")));
        return  user;
    }
}
