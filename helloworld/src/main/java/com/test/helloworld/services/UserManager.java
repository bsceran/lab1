package com.test.helloworld.services;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.test.helloworld.entity.User;
import com.test.tools.PasswordEncoderGenerator;

public class UserManager implements UserDetailsManager {
	
	private final MongoOperations mongoOperations;
	
	public UserManager(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public void createUser(UserDetails userDetails) {
		if(!userExists(userDetails.getUsername())){
			String password = userDetails.getPassword();
			String hashedPassword = PasswordEncoderGenerator.generateHashedPassword(password);
			User user = (User)userDetails;
			user.setPassword(hashedPassword);
			mongoOperations.save((User)userDetails);
		}
	}
	
	public void createUserWithoutHashingPassword(UserDetails userDetails) {
		if(!userExists(userDetails.getUsername())){
			mongoOperations.save((User)userDetails);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Query query = new Query(Criteria.where("username").is(username));
		User user = mongoOperations.findOne(query, User.class);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		} 
		return user;
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean userExists(String username) {
		Query query = new Query(Criteria.where("username").is(username));
		if(mongoOperations.find(query, User.class).isEmpty()) {
			return false;
		}
		return true;
	}
}
