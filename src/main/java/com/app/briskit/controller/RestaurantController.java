package com.app.briskit.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.model.RestaurantsEB;
import com.app.briskit.service.RestaurantService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping(value = "")
	public List<RestaurantsEB> getAllRestaurants(@RequestParam(name = "searchTime", required = true) 
		   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @Parameter(schema = @Schema(type = "string", format = "time")) LocalTime time) //@Parameter is for swagger
	{
		if(isValidSearchTime(time)) {
			
		}
		return restaurantService.findAllRestaurant();
	}
	
	private boolean isValidSearchTime(LocalTime time) {
		return true;
	}
	
}
