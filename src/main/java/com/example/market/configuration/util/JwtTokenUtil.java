package com.example.market.configuration.util;

import com.example.market.configuration.security.CustomUserDetail;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private final String jwtSecret = "jdna54sad655kzvmsNFhqzjqP";
    private final String jwtIssuer = "car-sale";

    public String generateAccessToken(UserDetails userDetails){
        CustomUserDetail user =(CustomUserDetail) userDetails;

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setId(Integer.toString(user.getId()));
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setSubject(String.format("%s,%s", user.getId(),userDetails.getUsername()));
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+(24*60*60*1000)));
        jwtBuilder.setIssuer(jwtIssuer);
        return jwtBuilder.compact();
    }
    public String generateAccessToken(Integer id, String email){

        JwtBuilder jwtBuilder=Jwts.builder();
        jwtBuilder.setId(Integer.toString(id));
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setSubject(String.format("%s,%s", id, email));
        jwtBuilder.signWith(SignatureAlgorithm.ES256, jwtSecret);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+(24 * 60 * 60 * 1000)));
        jwtBuilder.setIssuer(jwtIssuer);

        return jwtBuilder.compact();
    }
    public String getUserId(String token){
        Claims claims =Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token){
        Claims claims=Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[1];
    }

    public Date getExpirationDate(String token){
        Claims claims=Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }
    public boolean validate(String token){
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            //logger.error("Invalid JWT signature - {}", ex.getMessage());
        }catch (MalformedJwtException ex) {
            // logger.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            // logger.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            // logger.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            // logger.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }

}
