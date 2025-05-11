package com.home.dao;

import java.util.List;
import java.util.Optional;

import com.home.dto.UserDto;
import com.home.entity.UserEntity;

public interface UserDao {

	List<UserEntity> getMySqlUsers();

	Optional<UserEntity> getUserById(int id);

	UserEntity saveUser(UserDto user);

	String deleteUser(int id);

	UserEntity loginUser(UserEntity user);

}
