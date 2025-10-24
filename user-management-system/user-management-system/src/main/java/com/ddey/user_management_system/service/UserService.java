package com.ddey.user_management_system.service;

import com.ddey.user_management_system.dto.UserRequestDTO;
import com.ddey.user_management_system.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    // Create user
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    // Get user by ID
    UserResponseDTO getUser(Long id);

    // Get all users
    List<UserResponseDTO> getAllUsers();

    // Update user by ID
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);

    // Delete user by ID
    String deleteUser(Long id);
}
