package com.fintrack.fintrack.service;

import com.fintrack.fintrack.dto.UserDTO;
import com.fintrack.fintrack.model.User;
import com.fintrack.fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(),user.getPassword()))
                .collect(Collectors.toList());

    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        //   Optional<User> user =  userRepository.findById(id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        user.setId(id);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User updatedUser = userRepository.save(user);

        // Step 4: Return as UserDTO
        return new UserDTO(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPassword()
        );
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Id has been deleted";
    }


}
