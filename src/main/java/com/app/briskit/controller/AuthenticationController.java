package com.app.briskit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.dto.AdminAuthRequest;
import com.app.briskit.service.AuthenticationService;
import com.app.briskit.utils.JwtUtil;
import com.app.briskit.utils.ROLE;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication service")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	@Autowired
	private JwtUtil jwtService;
	
	@PostMapping("/admin/signin")
	public ResponseEntity<Object> authenticateUser(@RequestBody AdminAuthRequest authReqBody){
		String token = jwtService.generateToken("admin", ROLE.ADMIN, null, 0);
		return ResponseEntity.ok()
				.header(HttpHeaders.AUTHORIZATION, token)
				.body(token);
	}
}
