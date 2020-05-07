package com.cwac.app.oauth.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwac.app.user.commons.entity.Usuario;

@FeignClient(name = "users-micro")
public interface UserFeignClient {
	
	@GetMapping("/users/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
}
