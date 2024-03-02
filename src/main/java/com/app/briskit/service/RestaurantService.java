package com.app.briskit.service;

import java.util.List;

import com.app.briskit.model.RestaurantsEB;

public interface RestaurantService {
	RestaurantsEB save(RestaurantsEB restaurant);
	List<RestaurantsEB> findAllRestaurant();
}
