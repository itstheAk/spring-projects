package com.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.security.data.User;
import com.springboot.security.jpa.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepo.findAll().forEach(i -> users.add(i));
		log.info("All User List " + users);
		return users;
	}
	
	public User addUser(String uName, String uPwd) {
		User newUser = new User();
		newUser.setName(uName);
		newUser.setPassword(uPwd);
		userRepo.save(newUser);
		return newUser;
	}
}
