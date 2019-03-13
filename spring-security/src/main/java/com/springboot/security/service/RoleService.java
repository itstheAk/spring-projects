package com.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.security.data.Role;
import com.springboot.security.jpa.RoleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	public List<Role> getAllRoles() {
		List<Role> users = new ArrayList<>();
		roleRepo.findAll().forEach(i -> users.add(i));
		log.info("All Role List " + users);
		return users;
	}
	
	public Role addRole(String roleName) {
		Role newRole = new Role();
		newRole.setName(roleName);
		roleRepo.save(newRole);
		return newRole;
	}
}
