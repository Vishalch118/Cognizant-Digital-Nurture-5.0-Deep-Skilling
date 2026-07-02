package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        System.out.println("Authorization Header: " + authHeader);
        String user = getUser(authHeader);
        Map<String, String> map = new HashMap<>();
        String token = generateJwt(user);

        System.out.println("Generated Token: " + token);

        map.put("token", token);

        return map;
    }

    private String getUser(String authHeader) {

        String encodedCredentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes);

        System.out.println("Decoded credentials: " + credentials);

        String user = credentials.substring(0, credentials.indexOf(":"));

        System.out.println("User: " + user);

        return user;
    }

    private String generateJwt(String user) {

        JwtBuilder builder = Jwts.builder();

        builder.setSubject(user);

        // Current time
        builder.setIssuedAt(new Date());

        // Expiry time: 20 minutes from now
        builder.setExpiration(new Date(new Date().getTime() + 1200000));

        SecretKey key = Keys.hmacShaKeyFor(
                "mysecretkeymysecretkeymysecretkey12".getBytes()
        );

        builder.signWith(key, SignatureAlgorithm.HS256);

        return builder.compact();
    }
}