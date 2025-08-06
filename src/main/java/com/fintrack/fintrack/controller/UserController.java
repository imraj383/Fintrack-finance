package com.fintrack.fintrack.controller;

import com.fintrack.fintrack.dto.UserDTO;
import com.fintrack.fintrack.model.User;
import com.fintrack.fintrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
     List<UserDTO> getAll(){
        List<UserDTO> getUser = userService.getAllUsers();
        return getUser;
    }

    @PostMapping("/api/adduser")
    public String addUser(@RequestBody User user){
        String s = userService.addUser(user);
        return s;

    }
}
