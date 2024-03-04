package com.app.briskit.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.model.RestaurantsEB;
import com.app.briskit.service.RestaurantService;
import com.app.briskit.service.exception.InvalidUserInputException;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Restaurant Service")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping(value = "")
	public ResponseEntity<Object> getAllRestaurants(@RequestParam(name = "searchTime", required = true) 
		   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @Parameter(schema = @Schema(type = "string", format = "time")) LocalTime time) //@Parameter is for swagger
	{
		if(!isValidSearchTime(time)) {
			return ResponseEntity
                    .badRequest()
                    .body("Invalid search time");
		}
		List<RestaurantsEB> restaurants = restaurantService.findAllRestaurantByTime(time);
		return ResponseEntity.ok(restaurants);
	}
	
	private boolean isValidSearchTime(LocalTime time) {
		if(time.getMinute() % 15 != 0) {
			return false;
		}
		return true;
	}
	
}
