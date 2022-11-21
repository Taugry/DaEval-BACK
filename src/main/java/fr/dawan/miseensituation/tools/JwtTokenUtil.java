package fr.dawan.miseensituation.tools;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenUtil implements Serializable  {

	private static final long serialVersionUID = 1L;

	// changer durée de validité du token
		public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60; //1j
		
		
		@Value("${jwt.secret}")
		private String secret;
		
		public String getNameFromToken(String token) {
			return getClaimFromToken(token, Claims::getSubject);
		}

		public Date getIssuedAtDateFromToken(String token) {
			return getClaimFromToken(token, Claims::getIssuedAt);
		}

		public Date getExpirationDateFromToken(String token) {
			return getClaimFromToken(token, Claims::getExpiration);
		}

		public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
			final Claims claims = getAllClaimsFromToken(token);
			return claimsResolver.apply(claims);
		}

		public Claims getAllClaimsFromToken(String token) {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}

		public Boolean isTokenExpired(String token) {
			final Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date());
		}

		private Boolean ignoreTokenExpiration(String token) {
			// here you specify tokens, for that the expiration is ignored
			return false;
		}

		public String doGenerateToken(Map<String, Object> claims, String subject) {

			return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
					.signWith(SignatureAlgorithm.HS512, secret).compact();
		}

		public Boolean canTokenBeRefreshed(String token) {
			return (!isTokenExpired(token) || ignoreTokenExpiration(token));
		}
		
}
