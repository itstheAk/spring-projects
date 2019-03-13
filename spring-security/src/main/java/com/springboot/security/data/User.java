package com.springboot.security.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER")
public class User {
	
	public User() {
		
	}
	
	public User(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_PASSWORD")
	private String password; 
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLE", joinColumns = @JoinColumn(name="USER_ID"))
	private Set<Role> userRoles;

}
