package com.app.briskit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "role")
@Table(name = "ROLE")
public class RoleEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private Long roleId;
	@Column(name = "CODE", unique = true)
	private String code;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DELETED")
	private String deleted;
}
