package com.app.briskit.service;

import com.app.briskit.dto.UserDTO;
import com.app.briskit.utils.ROLE;

public interface UserService {
	UserDTO registerNewUser(UserDTO user, ROLE role);
}
