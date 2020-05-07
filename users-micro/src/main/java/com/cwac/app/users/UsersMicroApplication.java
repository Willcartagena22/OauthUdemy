package com.cwac.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.cwac.app.user.commons.entity"})
@SpringBootApplication
public class UsersMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroApplication.class, args);
	}

}
