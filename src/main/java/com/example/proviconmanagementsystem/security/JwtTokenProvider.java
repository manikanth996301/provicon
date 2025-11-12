package com.example.proviconmanagementsystem.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtTokenProvider {
private static final String SECRET_KEY="mNlajOihTbMlohDewaSzMjnbhYtfdsPl";
private static final long EXPIRATION_TIME=86400000;
private final Key key=Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
public String generateToken(String username,String role) {
	return Jwts.builder()
			.setSubject(username)
			.claim("role", role)
			.addClaims(Map.of("role",role))
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME ))
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
	
}
public String extractUsername(String token) {
	return parseClaims(token).getBody().getSubject();
}
public String extractRole(String token) {
	return parseClaims(token).getBody().get("role",String.class);
}
public boolean isValidToken(String token) {
	try {
		parseClaims(token);
		return true;
	}
	catch (JwtException e) {
		// TODO: handle exception
return false;
	}
}
private Jws<Claims> parseClaims(String token){
	return Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
}
}
