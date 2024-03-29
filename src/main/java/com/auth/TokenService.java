package com.auth;


import com.auth.DTOS.Principal;
import com.common.utils.exceptions.MissingAuthTokenExceptions;
import com.common.utils.exceptions.TokenParseExceptions;
import com.user.dtos.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private final JwtConfig jwtConfig;

    public TokenService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(UserResponse subject) {
        long now = System.currentTimeMillis();

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(String.valueOf(subject.getId()))
                .setIssuer("Ecommerce")
                .claim("role", subject.getRole())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return tokenBuilder.compact();

    }

    public Principal extractTokenDetails(String token) {

        if (token == null || token.isEmpty()) {
            throw new MissingAuthTokenExceptions();
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            return new Principal(claims.getId(), claims.get("role", String.class));
        } catch (ExpiredJwtException e) {
            throw new TokenParseExceptions("The provided token is expired", e);
        } catch (Exception e) {
            throw new TokenParseExceptions(e);
        }
    }

}
