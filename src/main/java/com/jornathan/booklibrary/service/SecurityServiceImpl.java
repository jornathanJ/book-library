package com.jornathan.booklibrary.service;


//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
        import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
        import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityServiceImpl implements SecurityService {

    public static final String secretKey ="4C8kum4LxyKWYLM78sKdXrzbBjDCFyfX";

    @Override
    public String createToken(String subject, long ttlMillis) {
        if (ttlMillis <= 0){
            throw new RuntimeException("Expiry tim must be greater then zero : [" + ttlMillis +"]");
        }

        //The JWT signature algoritm we will be using to sign the token.
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte [] apiKeySecreateBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecreateBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);

        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));

        return builder.compact();
    }

    @Override
    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary((secretKey)))
                .parseClaimsJws(token).getBody();

        return  claims.getSubject();
    }
}
