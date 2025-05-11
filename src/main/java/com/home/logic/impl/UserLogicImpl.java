package com.home.logic.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.home.dao.UserDao;
import com.home.dto.UserDto;
import com.home.entity.UserEntity;
import com.home.logic.UserLogic;

@Component
public class UserLogicImpl implements UserLogic {

	@Autowired
	private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLogicImpl.class);
	String message = null;

	@Override
	public Optional<UserEntity> getUserById(int id) {
		LOGGER.info("UserLogicImpl getUserById method :: START");
		return userDao.getUserById(id);
	}

	@Override
	public List<UserEntity> getUsers() {
		LOGGER.info("UserLogicImpl getUsers method :: START");

		List<UserEntity> mysqlUserList = userDao.getMySqlUsers();
		return mysqlUserList;

	}

	@Override
	public UserEntity saveUser(UserDto user) {
		LOGGER.info("UserLogicImpl saveUser method :: START");
		return userDao.saveUser(user);
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserLogicImpl deleteUser method :: START");
		return userDao.deleteUser(id);
	}

	@Override
	public UserEntity loginUser(UserEntity user) {
		LOGGER.info("UserLogicImpl loginUser method :: START");
		return userDao.loginUser(user);
	}

}
