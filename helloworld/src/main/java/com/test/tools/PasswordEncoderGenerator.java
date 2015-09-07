package com.test.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

  public static void main(String[] args) {
	final String password = "464197";
	
	int i = 0;
	while (i < 10) {
		String hashedPassword = generateHashedPassword(password);
		System.out.println(hashedPassword);
		i++;
	}
  }
  
  public static String generateHashedPassword(String password) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	  return passwordEncoder.encode(password);
  }
}