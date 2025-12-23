package br.com.taskly.projeto.security.jwt;



import java.security.Key;
import java.util.Base64.Decoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.taskly.projeto.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {
	
	@Value("${projeto.jwtSecret}")
	private String jwtSecret;
	
	@Value("${projeto.jwtExpirationMs}")
	private int jwtExpirationMs;
	
		  public String generateJwtToken(UserDetailsImpl userDetail) {
   
		    return Jwts.builder()
		        .setSubject((userDetail.getUsername()))
		        .setIssuedAt(new Date())
		        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		        .signWith(getSigninKey(), SignatureAlgorithm.HS512)
		        .compact();
		  }
		  
		  public String getUsernameToken(String token) {
			  return Jwts.parser().setSigningKey(getSigninKey()).build()
					  .parseClaimsJws(token).getBody().getSubject();
		  }
	
		  
		  public Key getSigninKey() {
			  return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
			  
		  }
		  
		  public boolean validateJwtToken(String authToken) {
			  try {
				  Jwts.parser().setSigningKey(getSigninKey()).build().parse(authToken);
				  return true;
				  
			  }catch(MalformedJwtException e) {
				  System.out.println("Infalid JWT toke: " + e.getMessage() );
			  }catch(ExpiredJwtException e) {
				  System.out.println("JWT token is expired: " + e.getMessage());
			  }catch(UnsupportedJwtException e) {
				  System.out.println("JWT token is unsopported: " + e.getMessage());
			  }catch(IllegalArgumentException e) {
				  System.out.println("JWT claims string is empty:" + e.getMessage());
			  }
			  return false;
		  }

		  
		 
		  	
	
	

}
