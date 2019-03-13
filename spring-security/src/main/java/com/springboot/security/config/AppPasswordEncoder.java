package com.springboot.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class AppPasswordEncoder implements PasswordEncoder{
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return true;
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

}
