package com.app.briskit.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.briskit.dto.UserDTO;
import com.app.briskit.model.RoleEB;
import com.app.briskit.model.UsersEB;
import com.app.briskit.repository.RoleRepository;
import com.app.briskit.repository.UsersRepository;
import com.app.briskit.service.exception.InvalidUserInputException;
import com.app.briskit.service.exception.UserAlreadyExistsException;
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
		RoleEB roleEntity =  roleRepo.findRoleByCode(user.getRole());
		if(roleEntity == null) {
			throw new InvalidUserInputException(
					String.format("Invalid role =%s", user.getRole())
				);
		}
		if(validateUserInput(user, role) && !isUserExists(user)) {
			UsersEB userEntity = Utils.convertToUserEntity(user);
			userEntity.setRole(roleEntity);
			try {
				UsersEB savedUser = userRepo.save(userEntity);
				return Utils.convertToUserDTO(savedUser);
			}catch (Exception e) {
				throw new UserAlreadyExistsException("Test");
			}
		}
		return null;
		
	}
	
	public boolean validateUserInput(UserDTO user, ROLE role) {
		//Check First Name and Last Name is not empty
		if(StringUtils.isEmpty(user.getFirstName())) {
			throw new InvalidUserInputException("Invalid first name ");
		}
		if(StringUtils.isEmpty(user.getLastName())){
			throw new InvalidUserInputException("Invalid last name ");
		}
		if(role == ROLE.ADMIN) {
			if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
				throw new InvalidUserInputException(" For admin registration email and password field is mandatory ");
			}
		}else if(role == ROLE.CUSTOMER) {
			if(StringUtils.isEmpty(user.getPhoneNo())){
				throw new InvalidUserInputException(" For customer registration phone number field is mandatory ");
			}
		}else if(role == ROLE.DELIVERY_PERSON || role == ROLE.RESTAURANT) {
			if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
				throw new InvalidUserInputException("For delivery user registration username and password fields are mandatory fields");
			}
		}
		return true;
	}
	
	private boolean isUserExists(UserDTO user) {
		if(userRepo.findUserByEmail(user.getEmail()).isEmpty()) {
			throw new InvalidUserInputException(
					String.format("User already resistered with mail =%s", user.getEmail())
			);
		}
		if(userRepo.findUserByUsername(user.getUsername()).isEmpty()) {
			throw new InvalidUserInputException(
					String.format("User already resistered with username =%s", user.getUsername())
			);
		}
		if(userRepo.findUserByPhoneNo(user.getPhoneNo()).isEmpty()) {
			throw new InvalidUserInputException(
					String.format("User already resistered with phone number =%s", user.getPhoneNo())
			);
		}
		return false;
	}

}
