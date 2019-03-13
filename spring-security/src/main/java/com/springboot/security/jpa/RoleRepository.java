package com.springboot.security.jpa;

import org.springframework.data.repository.CrudRepository;

import com.springboot.security.data.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
