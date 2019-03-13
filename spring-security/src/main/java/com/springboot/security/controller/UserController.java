package com.springboot.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.data.User;
import com.springboot.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	UserService _userService;
	
	@GetMapping
	public List<User> getUsers() {
		log.info("Serving the request");
		return _userService.getAllUsers();
	}
	
	@PostMapping
	public User addUser(@RequestParam(name="userName") String uName,
						@RequestParam(name="userPassword") String uPwd) {
		return _userService.addUser(uName, uPwd);
	}
}
