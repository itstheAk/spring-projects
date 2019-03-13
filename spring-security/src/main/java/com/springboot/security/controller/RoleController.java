package com.springboot.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.data.Role;
import com.springboot.security.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;

	@GetMapping
	public List<Role> getAllRoles() {
		log.info("Getting All Roles");
		return roleService.getAllRoles();
	}
	
	@PostMapping
	public Role addRole(@RequestParam(name="roleName") String roleName) {
		return roleService.addRole(roleName);
	}
}
