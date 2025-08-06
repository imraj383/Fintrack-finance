package com.fintrack.fintrack.service;

import com.fintrack.fintrack.dto.UserDTO;
import com.fintrack.fintrack.model.User;
import com.fintrack.fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());

    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "Success";
    }
}
