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

@Entity
@Table(name = "RESTAURANTS")
public class RestaurantsEB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String deleted;
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLocation() {
		return location;
	}
	public void setLocation(Long location) {
		this.location = location;
	}
	public List<MenuItemsEB> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItemsEB> menuItems) {
		this.menuItems = menuItems;
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
