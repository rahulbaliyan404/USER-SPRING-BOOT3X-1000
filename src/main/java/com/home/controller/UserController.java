package com.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.dto.UserDto;
import com.home.entity.UserEntity;

@RequestMapping(value = "/BOOT3X1000")
public interface UserController {
	
	@GetMapping(value = "/login")
	public UserEntity loginUser(@RequestBody UserEntity userPojo);

	@GetMapping(value = "/user/{id}")
	public Optional<UserEntity> getUserById(@PathVariable("id") int id);

	@GetMapping(value = "/users")
	public List<UserEntity> getUsers();

	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") int id);
	
	@PutMapping(value = "/update/{id}")
	public String updateUser(@RequestBody UserEntity user,@PathVariable("id") int id);

	@PostMapping(value = "/save")
	public String saveUser(@RequestBody UserDto user);

}
