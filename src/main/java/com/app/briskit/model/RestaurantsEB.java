package com.app.briskit.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "restaurants")
@Table(name = "RESTAURANTS")
public class RestaurantsEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESTAURANT_ID")
	private Long restaurantId;
	@Column(name = "NAME")
	private String name;
	private Long location;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "MENU_ITEMS_ID")
	private List<MenuItemsEB> menuItems;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	@Column(name = "DELETED")
	private String Deleted;
}
