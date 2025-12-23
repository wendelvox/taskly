package br.com.taskly.projeto.service;

import java.util.ArrayList;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.taskly.projeto.model.UsuarioEntity;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	
	
	
	public UserDetailsImpl(Integer id, String name, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UsuarioEntity usuario) {
		return new UserDetailsImpl(usuario.getId(), 
				usuario.getNome(), 
				usuario.getLogin(),
				usuario.getEmail(), 
				usuario.getSenha(),
				new ArrayList<>()
				);
	}
	private Collection<? extends GrantedAuthority> authorities;
		

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return authorities;
	}

	@Override
	public @Nullable String getPassword() {		
		return password;
	}

	@Override
	public String getUsername() {		
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return UserDetails.super.isAccountNonExpired();
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return UserDetails.super.isAccountNonLocked();
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	

}
