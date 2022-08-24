package com.agency04.devcademy.util;

import com.agency04.devcademy.form.LoginForm;
import com.agency04.devcademy.service.impl.UsersServiceImpl;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Autowired
    private UsersServiceImpl usersService;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> resolver) {
        return resolver.apply(getAllClaimsFromToken(token));
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(LoginForm loginDetails) {
        Claims claims = Jwts.claims().setSubject(loginDetails.getEmail());
        claims.put("role", usersService.findByEmail(loginDetails.getEmail()).getAuthorities());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, LoginForm loginDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(loginDetails.getEmail()) && !isTokenExpired(token));
    }

}
