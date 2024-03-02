package com.app.briskit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.model.RestaurantsEB;
import com.app.briskit.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping(value = "")
	public List<RestaurantsEB> getAllRestaurants(){
		return restaurantService.findAllRestaurant();
	}
	
}
