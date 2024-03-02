package com.app.briskit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.briskit.model.RestaurantsEB;
import com.app.briskit.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List<RestaurantsEB> findAllRestaurant(int limit, int offset){
		//return restaurantRepository.findAllrestaurantByPagination(limit, offset);
		return null;
	}
}
