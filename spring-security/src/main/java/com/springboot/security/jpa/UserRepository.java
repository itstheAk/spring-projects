package com.springboot.security.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.security.data.User;

public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByName(String userName);

}
