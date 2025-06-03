package org.example.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtHelper {
    private static final long tokenExpiration = 24*60*60*1000L; // 1 day
    private static final SecretKey tokenSignKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String createToken(Long userId) {
        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .signWith(tokenSignKey)
                .compressWith(Jwts.ZIP.GZIP)
                .compact();
        return token;
    }

    public static Long getUserId(String token) {
        if(token == null || token.isBlank()) return null;

        try{
            Claims claims = Jwts.parser()
                    .verifyWith(tokenSignKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.get("userId", Long.class);
        }catch(JwtException e){
            return null;
        }
    }

    /**
     *
     * @param token
     * @return false : token is existed
     *         true : token is expired or other error
     */
    public static boolean isExpiration(String token){
        if (token == null || token.isBlank()) {
            return true;
        }
        try {
            Date expirationDate = Jwts.parser()
                    .verifyWith(tokenSignKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration();

//            if (expirationDate == null) {
//                return false;
//            }
            return expirationDate.before(new Date());
        } catch (ExpiredJwtException eje ) {
//            eje.printStackTrace();
            return true;
        } catch (JwtException e) {
//            e.printStackTrace();
            return true;
        }
    }
}