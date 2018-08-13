package com.bridgelabz.microservice.fundoonote.user.services;

import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenProvider {

	@Value("${key}")
	private String secret;

	public String tokenGenerator(String id) {
		long timeMillis = System.currentTimeMillis() + (24 * 60 * 60 * 1000);
		Date date = new Date(timeMillis);
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(new Date()).setExpiration(date)
				.setSubject("usertoken").signWith(SignatureAlgorithm.HS256, secret);
		return builder.compact();

	}

	public Claims parseJWT(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(jwt)
				.getBody();

		System.out.println("The details of claims: ");
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Exp time: " + claims.getExpiration());
		System.out.println("issue at: " + claims.getIssuedAt());
		return claims;
	}

	public Boolean isTokenExpired(String token) {
		final Date expiration = parseJWT(token).getExpiration();
		return expiration.before(new Date());
	}

}
