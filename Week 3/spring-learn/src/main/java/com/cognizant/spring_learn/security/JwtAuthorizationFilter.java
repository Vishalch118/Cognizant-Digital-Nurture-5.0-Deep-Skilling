package com.cognizant.spring_learn.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);

        System.out.println("JwtAuthorizationFilter initialized");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {

        String header = req.getHeader("Authorization");

        System.out.println("Authorization Header: " + header);

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                getAuthentication(req);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(
            HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (token != null) {

            try {

                SecretKey key = Keys.hmacShaKeyFor(
                        "mysecretkeymysecretkeymysecretkey12".getBytes()
                );

                Jws<Claims> jws = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token.replace("Bearer ", ""));

                String user = jws.getPayload().getSubject();

                System.out.println("JWT User: " + user);

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            new ArrayList<>()
                    );
                }

            } catch (JwtException ex) {
                return null;
            }
        }

        return null;
    }
}
