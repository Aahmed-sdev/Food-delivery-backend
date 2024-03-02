package com.app.briskit.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MENU_ITEMS")
public class MenuItemsEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MENU_ITEMS_ID")
	private long menuItemsId;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "SERVE_START_TIME" )
	private Date serveStartTime;
	@Column(name = "SERVE_END_TIME")
	private Date serveEndTime;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	@Column(name = "DELETED")
	private String deleted;
	@Column(name = "PRICE")
	private Double price;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RESTAURANT_ID")
	private RestaurantsEB restaurant;
}
