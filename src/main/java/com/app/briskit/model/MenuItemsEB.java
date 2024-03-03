package com.app.briskit.model;

import java.time.LocalTime;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ITEMS_ID")
	private long menuItemsId;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "SERVE_START_TIME" )
	private LocalTime serveStartTime;
	@Column(name = "SERVE_END_TIME")
	private LocalTime serveEndTime;
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

	public long getMenuItemsId() {
		return menuItemsId;
	}

	public void setMenuItemsId(long menuItemsId) {
		this.menuItemsId = menuItemsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalTime getServeStartTime() {
		return serveStartTime;
	}

	public void setServeStartTime(LocalTime serveStartTime) {
		this.serveStartTime = serveStartTime;
	}

	public LocalTime getServeEndTime() {
		return serveEndTime;
	}

	public void setServeEndTime(LocalTime serveEndTime) {
		this.serveEndTime = serveEndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public RestaurantsEB getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantsEB restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
