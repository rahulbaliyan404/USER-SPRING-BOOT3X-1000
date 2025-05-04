package com.home.logic;

import com.home.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserLogic {
    List<User> users();
}
