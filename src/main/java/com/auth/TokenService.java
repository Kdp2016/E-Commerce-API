package com.auth;


import com.auth.DTOS.Principal;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private final JwtConfig jwtConfig;

    public TokenService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Principal subject) {
        long now = System.currentTimeMillis();

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(subject.getAuthUserId())
                .setIssuer("Ecommerce")
                .claim("role", subject.getAuthUserRole())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return tokenBuilder.compact();

    }

    public Principal extractTokenDetails(String token) {

        if (token == null || token.isEmpty()) {
            throw new ();
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            return new Principal(claims.getId(), claims.get("role", String.class));
        } catch (ExpiredJwtException e) {
            throw new TokenParseException("The provided token is expired", e);
        } catch (Exception e) {
            throw new TokenParseException(e);
        }
    }

}
