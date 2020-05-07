package com.cwac.app.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.cwac.app.user.commons.entity.Role;
import  com.cwac.app.user.commons.entity.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		config.exposeIdsFor(Usuario.class, Role.class);
		
	}

	
	
}
