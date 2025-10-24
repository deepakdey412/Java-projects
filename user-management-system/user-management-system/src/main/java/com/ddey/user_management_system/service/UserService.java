package com.ddey.user_management_system.service;

import com.ddey.user_management_system.dto.UserRequestDTO;
import com.ddey.user_management_system.dto.UserResponseDTO;
import com.ddey.user_management_system.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO getUser(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    String deleteUser(Long id);

}
