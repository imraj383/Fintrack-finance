package com.fintrack.fintrack.service;

import com.fintrack.fintrack.dto.UserDTO;
import com.fintrack.fintrack.model.User;

import java.util.List;

public interface UserService {
     List<UserDTO> getAllUsers();

     String addUser(User user);

     User saveUser(UserDTO userDTO);

     UserDTO updateUser(int id, UserDTO userDTO);

     String deleteUser(int id);
}
