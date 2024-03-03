package com.app.briskit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.dto.UserDTO;
import com.app.briskit.service.UserService;
import com.app.briskit.utils.ROLE;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register/admin")
	public UserDTO createAdminUser(@RequestBody UserDTO user) {
		return userService.registerNewUser(user, ROLE.ADMIN);
	}
	
	@PostMapping("/register/customer")
	public UserDTO createCustomerUser(@RequestBody UserDTO user) {
		return userService.registerNewUser(user, ROLE.CUSTOMER);
	}
	
	@PostMapping("/register/deliveryPerson")
	public UserDTO createDeliveryUser(@RequestBody UserDTO user) {
		return userService.registerNewUser(user, ROLE.DELIVERY_PERSON);
	}
	
	@PostMapping("/register/restaurant")
	public UserDTO createRestaurantUser(@RequestBody UserDTO user) {
		return userService.registerNewUser(user, ROLE.RESTAURANT);
	}
}
