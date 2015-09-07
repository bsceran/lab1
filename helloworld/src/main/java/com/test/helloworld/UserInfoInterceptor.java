package com.test.helloworld;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInfoInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoInterceptor.class);
			
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(null == modelAndView) {
			return;
		}
		
		String role = null;
		String userName = getUserName(request.getUserPrincipal());
		if(userDetailsManager.userExists(userName)) {
			UserDetails userDetails = userDetailsManager.loadUserByUsername(userName);
			role = getRole(userDetails.getAuthorities());
		}
		
		logger.info("view    :" + modelAndView.getViewName());
		logger.info("userName:" + userName);
		logger.info("userRole:" + role);
		
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("userRole", role);
	}
	
	private String getUserName(Principal principal) {
		if(principal != null) {
			return principal.getName();
		}
		return null;
	}
	
	private String getRole(Collection<? extends GrantedAuthority> collection) {
		Iterator<? extends GrantedAuthority> iterator = collection.iterator();
		if(iterator.hasNext()) {
			return iterator.next().getAuthority();
		}
		return null;
	}
}
