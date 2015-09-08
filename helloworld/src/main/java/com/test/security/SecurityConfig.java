package com.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import com.test.helloworld.services.UserManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager())
        .passwordEncoder(passwordEncoder());
    }
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

    @Bean
    public UserDetailsManager inMemoryUserDetailsManager() {
    		return new UserManager(mongoOperations);
    }
    
	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error")
		    .usernameParameter("username").passwordParameter("password")		
		.and()
		    .logout().logoutSuccessUrl("/") // logoin?logout
		.and()
		    .csrf().disable()
//		 .and()
//		 	.requiresChannel().anyRequest().requiresSecure()
//		 .and()
		 	.exceptionHandling().accessDeniedPage("/error/403");
		    ;
	}
}
