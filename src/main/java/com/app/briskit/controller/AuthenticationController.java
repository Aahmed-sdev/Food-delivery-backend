package com.app.briskit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.briskit.dto.AdminAuthRequest;
import com.app.briskit.service.AuthenticationService;
import com.fasterxml.jackson.core.sym.Name;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Tag(name = "Authentication service")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/admin/signin")
	public ResponseEntity<AdminAuthRequest> authenticateUser(@RequestBody AdminAuthRequest authReqBody){
		return null;
	}
}
