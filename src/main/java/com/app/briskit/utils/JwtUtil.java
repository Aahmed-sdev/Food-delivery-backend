package com.app.briskit.utils;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.briskit.exception.TokenGenerationException;
import com.app.briskit.utils.ROLE;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;

@Component
public class JwtUtil {
	@Value("${auth.token.secret}")
	private String secretToken;
	
	public String generateToken(String subject, ROLE role, Map<String, String> body, long validity) {
		String token = "";
		
		try {
			byte[] secretKeyBytes = secretToken.getBytes();
			SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyBytes);
			
			Instant now = Instant.now();
			Instant expiration = now.plusSeconds(validity); // 1 hour
			Date expDate = Date.from(expiration);
			
			token = Jwts.builder()
					.subject(subject)
					.claim("role", role.toString())
					.claims(body)
					.issuedAt(Date.from(now))
					.expiration(expDate)
					.signWith(secretKey)
					.compact();
		}catch (WeakKeyException e) {
			e.printStackTrace();
			throw new TokenGenerationException(e.getMessage());
		}
		return token;
	}
	
	public ERROR validateToken(String token) {
		byte[] secretKeyBytes = secretToken.getBytes();
		SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);
		JwtParser parser = Jwts.parser()
		                .verifyWith(key)
		                .build();
		try {
			parser.parseSignedClaims(token);			
		}catch (ExpiredJwtException e) {
			e.printStackTrace();
			return ERROR.EXPIRED;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return ERROR.INVALID;
		}
		
		return ERROR.NONE;
	}
	
	public Claims getJwtPayload(String token) {
		byte[] secretKeyBytes = secretToken.getBytes();
		SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);
		JwtParser parser = Jwts.parser()
		                .verifyWith(key)
		                .build();
		return parser.parseSignedClaims(token).getPayload();
	}

}
