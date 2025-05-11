package com.home.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.home.controller.UserController;
import com.home.dto.UserDto;
import com.home.entity.UserEntity;
import com.home.logic.UserLogic;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserLogic userLogic;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

	@Override
	public UserEntity loginUser(UserEntity user) {
		LOGGER.info("UserControllerImpl loginUser method  :: START");
		return userLogic.loginUser(user);
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		LOGGER.info("UserControllerImpl getUserById method :: START");
		return userLogic.getUserById(id);
	}

	@Override
	public List<UserEntity> getUsers() {
		LOGGER.info("UserControllerImpl getUsers method    :: START");
		return userLogic.getUsers();
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserControllerImpl deleteUser method  :: START");
		return userLogic.deleteUser(id);
	}

	@Override
	public String updateUser(UserEntity user,int id) {
		return "Data";
	}
	
	@Override
	public String saveUser(@RequestBody UserDto user) {
		userLogic.saveUser(user);
		return "User Created Successfully";
	}
}
