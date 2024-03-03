package com.app.briskit.utils;

import org.modelmapper.ModelMapper;

import com.app.briskit.dto.UserDTO;
import com.app.briskit.model.UsersEB;

public class Utils {
	public static UserDTO convertToUserDTO(UsersEB user) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, UserDTO.class);
	}
	
	public static UsersEB convertToUserEntity(UserDTO user) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, UsersEB.class);
	}
}
