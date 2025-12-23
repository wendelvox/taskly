package br.com.taskly.projeto.service;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.taskly.projeto.dto.AcessDTO;
import br.com.taskly.projeto.dto.AuthenticationDTO;
import br.com.taskly.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public AcessDTO login(AuthenticationDTO authDTO) {
		try {
		UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());
		Authentication authentication = authenticationManager.authenticate(userAuth);
		UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
		String token = jwtUtils.generateJwtToken(userAuthenticate);
		
		AcessDTO acessDTO = new AcessDTO(token);
		return acessDTO;
		} catch (BadCredentialsException e) {
			// TODO: handle exception
		}
	 return new AcessDTO("Acesso Negado");
		
		
	}

}
