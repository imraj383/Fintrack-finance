package com.fintrack.fintrack.controller;

import com.fintrack.fintrack.model.User;
import com.fintrack.fintrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
     List<User> getAll(){
        List<User> getUser = userService.getAllUsers();
        return getUser;
    }
}
