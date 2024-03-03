package com.app.briskit.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class UsersEB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERS_ID")
	private Long usersId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@OneToOne
	@NotNull
	@JoinColumn(name = "ROLE_ID")
	private RoleEB role;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "USERNAME", unique = true)
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONE_NO", unique = true)
	private String phoneNo;
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	@Column(name = "DELETED")
	private String deleted;
	public Long getUsersId() {
		return usersId;
	}
	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public RoleEB getRole() {
		return role;
	}
	public void setRole(RoleEB role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
	
}
