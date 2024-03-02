package com.app.briskit.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UsersEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERS_ID")
	private Long usersId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@OneToOne
	private RoleRB role;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "USERNAME", unique = true)
	private String username;
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	@Column(name = "DELETED")
	private String deleted;
	
}
