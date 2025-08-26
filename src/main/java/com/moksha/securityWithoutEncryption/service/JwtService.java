package com.moksha.securityWithoutEncryption.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class JwtService {
    public String getToken(String name) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(name)
                .issuedAt(new Date(currentTimeMillis()))
                .expiration(new Date(currentTimeMillis()*60*60*30))
                .and()
                .signWith(getKey())
                .compact();
    }

}
