package br.edu.ifpb.dac.parking_space.business.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.dac.parking_space.business.service.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.parking_space.model.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

    //os dados guardados no token
    public static final String CLAIM_USER_ID = "userid";
    public static final String CLAIM_USER_NAME = "username";
    public static final String CLAIM_EXPIRATION = "expirationtime";

    //config. go aplivation properties
    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generate(User user) {
        long expiration = Long.valueOf(this.expiration);

        // calcula a expiração para ser setado como dado
        LocalDateTime expirationLocalDateTime = LocalDateTime.now().plusMinutes(expiration);
        Instant expirationInstant = expirationLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date expirationDate = Date.from(expirationInstant);

        String tokenExpiration = expirationLocalDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));

        // cria token com expiração, subject (dado principal), e as claims (dados extra)
        String token = Jwts.builder()
                .setExpiration(expirationDate)
                .setSubject(user.getId().toString())
                .claim(CLAIM_USER_ID, user.getId())
                .claim(CLAIM_USER_NAME, user.getName())
                .claim(CLAIM_EXPIRATION, tokenExpiration)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }
    //retorna as informações exttras guardadas no token
    @Override
    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
//checa se o token é válido
    @Override
    public boolean isValid(String token) {
        if(token == null) {
            return false;
        }

        try {
            Claims claims = getClaims(token);
            LocalDateTime expirationTime = claims.getExpiration().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();

            return LocalDateTime.now().isBefore(expirationTime);
        } catch (Exception e) {
            return false;
        }
    }
//pega o ID do usuário
    @Override
    public Integer getUserId(String token) {
        Claims claims = getClaims(token);

        return Integer.parseInt(claims.getSubject());
    }
//pega o nome das informações extras
    @Override
    public String getUserName(String token) {
        Claims claims = getClaims(token);

        return (String) claims.get(CLAIM_USER_NAME);
    }

    // extrai  o token de uma request
    @Override
    public String get(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith("Bearer")) {
            return null;
        }

        return authorization.split(" ")[1];
    }
}