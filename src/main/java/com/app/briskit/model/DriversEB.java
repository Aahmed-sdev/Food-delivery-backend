package com.app.briskit.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DRIVERS")
public class DriversEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DRIVERS_ID")
	private Long driversId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USERS_ID")
	private UsersEB user;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ORDERED_AT")
	private Date orderPickedAt;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	@Column(name = "DELETED")
	private String deleted;
	
}
