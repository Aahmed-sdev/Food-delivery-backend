package com.app.briskit.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class OrdersEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERS_ID")
	private Long ordersId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	@Column(name = "USERS_ID")
	private String usersId;
	
	@Column(name = "RESTAURANT_ID")
	private String restaurantId;
	//private MenuItemsEB menuItems;
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmmount;

}
