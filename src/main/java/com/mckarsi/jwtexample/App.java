package com.mckarsi.jwtexample;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        Instant instant = ldt.toInstant(ZoneOffset.ofHours(3));

        byte[] secret = Base64.getDecoder().decode("HrPoTEVODeSRT5JlPBpSRfTTzPbOlQGrJXeG1bbhwDI");

        String jwt = Jwts.builder()
                .setSubject("Mert Can Karsi")
                .claim("email", "karsi.mertcan@gmail.com")
                .claim("role", "admin")
                .setIssuedAt(Date.from(instant))
                .setExpiration(Date.from(instant.plus(1, ChronoUnit.HOURS)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        System.out.println(jwt);
    }
}
