package com.test.helloworld;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.test.helloworld.entity.User;
import com.test.helloworld.services.UserManager;

@Component
public class ApplicationLifecycle {

	@Autowired
	private UserManager userManager;
	
	@PostConstruct
	public void applicationIsStarted() {
		if(!userManager.userExists("sueda")) {
			UserDetails sueda = new User("sueda", "$2a$10$H4IR9lG08BwdCYJTHDa6tOA3E8lTlXHCXbiwz1YbRicErMJelUR9K", "ROLE_ADMIN");
			userManager.createUserWithoutHashingPassword(sueda);
		}
		if(!userManager.userExists("serdar")) {
			UserDetails serdar = new User("serdar", "$2a$10$H4IR9lG08BwdCYJTHDa6tOA3E8lTlXHCXbiwz1YbRicErMJelUR9K", "ROLE_ADMIN");
			userManager.createUserWithoutHashingPassword(serdar);
		}
	}
}
