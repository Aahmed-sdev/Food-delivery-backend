package com.app.briskit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOCATION")
public class LocationEB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_ID")
	private Long locationId;
	@Column(name = "ADDRESS_1")
	private String address1;
	@Column(name = "ADDRES_2")
	private String address2;
	@Column(name = "LANDMARK")
	private String landmark;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIP_CODE")
	private Long zipCode;
	@Column(name = "LONGITUDE" )
	private Double longitude;
	@Column(name = "LATTITUDE")
	private Double lattitude;
	@Column(name = "CREATED_BY")
	private Long createdBy;
	@Column(name = "DELETED")
	private String deleted;
}
