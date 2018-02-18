/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.jwt.util;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author thomas
 */
//@ApplicationScoped
public class TokenUtils {
    

    private List<String> validJWTTokens = new ArrayList();
    
    @Inject
    private Logger logger;

    @Inject
    private KeyGenerator keyGenerator;
    
    
    public Long decryptIdFromToken(String token){
        if (!this.validJWTTokens.contains(token)) {
          throw new RuntimeException("Token is not valid anymore");
        }
        
        Key key = keyGenerator.generateKey();
        String idStr = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        return Long.parseLong(idStr);
    }
    
    
    public String issueToken(String login, Long id, String path) {
        Key key = Objects.requireNonNull(keyGenerator).generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(id.toString())
                .setIssuer(Objects.requireNonNull(path))
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("#### generating token for a key : " + jwtToken + " - " + key);
        
        this.validJWTTokens.add(jwtToken);
        
        return jwtToken;

    }
    
    public void valid(String token) {
        

        JwtParser signed = Jwts.parser().setSigningKey(System.getProperty("JWT-KEY"));

        String username = signed.parseClaimsJws(token).getBody().getSubject();
        
        logger.info("Request is JWT-sigend with user: " + username);
    }

    public void removeToken(String token) {
        this.validJWTTokens.remove(token);
    }
    
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
}
