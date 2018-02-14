/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.jwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import static org.jvnet.hk2.osgiadapter.Logger.logger;

/**
 *
 * @author thomas
 */
public class TokenUtils {
    
    public static String issueToken(KeyGenerator keyGenerator, String login, Long id, String path) {
        Key key = Objects.requireNonNull(keyGenerator).generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(id.toString())
                .setIssuer(Objects.requireNonNull(path))
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;

    }
    
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
}
