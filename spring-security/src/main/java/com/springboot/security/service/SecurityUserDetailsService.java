package com.springboot.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.security.data.SecurityUserDetails;
import com.springboot.security.data.User;
import com.springboot.security.jpa.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepo.findByName(userName);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		return optionalUser.map(SecurityUserDetails::new).get();
	}

}
