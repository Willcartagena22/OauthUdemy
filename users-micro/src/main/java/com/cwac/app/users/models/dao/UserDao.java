package com.cwac.app.users.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import  com.cwac.app.user.commons.entity.Usuario;

@RepositoryRestResource(path="users")
public interface UserDao extends PagingAndSortingRepository<Usuario, Long>{
	
	@RestResource(path ="buscar-username")
	public Usuario findByUsername(@Param("name") String username);
	
	
	@Query(value="select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	
	
}
