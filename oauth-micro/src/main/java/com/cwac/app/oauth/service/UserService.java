package com.cwac.app.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cwac.app.oauth.client.UserFeignClient;
import com.cwac.app.user.commons.entity.Usuario;

@Service
public class UserService implements UserDetailsService{

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient client;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
		Usuario user = client.findByUsername(username);
		
		if (user==null) {
			log.error("Error Login, no existe el usuario: "+ username);
			throw new UsernameNotFoundException("Error Login, no existe el usuario: "+ username);
			
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: "+authority.getAuthority()))
				.collect(Collectors.toList());
		
		log.info("Usuario autenticado: "+username);
		
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), 
				true, true, true, authorities );
	}

}
