package com.app.briskit.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.briskit.dto.UserDTO;
import com.app.briskit.model.RoleEB;
import com.app.briskit.model.UsersEB;
import com.app.briskit.repository.RoleRepository;
import com.app.briskit.repository.UsersRepository;
import com.app.briskit.utils.ROLE;
import com.app.briskit.utils.Utils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public UserDTO registerNewUser(UserDTO user, ROLE role) {
		//Check user already exists or not
		if(!validateUserInput(user, role)) {
			RoleEB roleEntity =  roleRepo.findRoleByCode(user.getRole());
			UsersEB userEntity = Utils.convertToUserEntity(user);
			userEntity.setRole(roleEntity);
			try {
				UsersEB savedUser = userRepo.save(userEntity);
				return Utils.convertToUserDTO(savedUser);
			}catch (Exception e) {
				// To Do throw exception to controller advice
			}
		}
		if(role == ROLE.ADMIN) {
			
		}
		return null;
		
	}
	
	public boolean validateUserInput(UserDTO user, ROLE role) {
		//Check First Name and Last Name is not empty
		if(StringUtils.isEmpty(user.getFirstName())) {
			
		}
		if(role == ROLE.ADMIN) {
			//if(user.get)
		}
		return true;
	}
	
	private boolean isUserUnique() {
		//to do
		return true;
	}

}
