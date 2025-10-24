package com.ddey.user_management_system.service;

import com.ddey.user_management_system.dto.UserRequestDTO;
import com.ddey.user_management_system.dto.UserResponseDTO;
import com.ddey.user_management_system.entity.Role;
import com.ddey.user_management_system.entity.User;
import com.ddey.user_management_system.exception.UserNotFoundException;
import com.ddey.user_management_system.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getRole() == null){
            userRequestDTO.setRole(String.valueOf(Role.STUDENT));
        }
        User newUser = modelMapper.map(userRequestDTO , User.class);
        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser , UserResponseDTO.class);
    }

    @Override
    public User getUser(Long id) {
        // Using orElseThrow directly on Optional to throw exception if user not found
        // No need to store Optional separately

        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return existingUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        // Using orElseThrow directly on Optional to throw exception if user not found
        // No need to store Optional separately

        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUser(Long id) {
        // Using orElseThrow directly on Optional to throw exception if user not found
        // No need to store Optional separately

        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(existingUser);
        return "User delete of id " + id;
    }
}
