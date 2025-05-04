package com.home.controller;

import com.home.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@RequestMapping(value = "/BOOT3X1000")
public interface UserController {
    @GetMapping(value = "/users")
    public List<String> userList();

    @GetMapping(value = "/user/{userId}")
    public String getUser(@PathVariable ("userId") int userId);
}
