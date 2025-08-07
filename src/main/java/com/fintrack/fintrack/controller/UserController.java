package com.fintrack.fintrack.controller;

import com.fintrack.fintrack.dto.UserDTO;
import com.fintrack.fintrack.model.User;
import com.fintrack.fintrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/saveuser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User createdUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @PutMapping("api/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id,@RequestBody UserDTO userDTO){
     UserDTO userDTO1 = userService.updateUser(id, userDTO);
     return new ResponseEntity<>(userDTO1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/delete/{id}")
    public String deleteUser(@PathVariable int id){
        String s = userService.deleteUser(id);
        return s;
    }
}
