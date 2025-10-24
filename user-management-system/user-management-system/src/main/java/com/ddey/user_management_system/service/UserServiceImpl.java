package com.ddey.user_management_system.service;

import com.ddey.user_management_system.dto.UserRequestDTO;
import com.ddey.user_management_system.dto.UserResponseDTO;
import com.ddey.user_management_system.entity.Role;
import com.ddey.user_management_system.entity.User;
import com.ddey.user_management_system.exception.UserNotFoundException;
import com.ddey.user_management_system.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // ✅ Create user
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getRole() == null || userRequestDTO.getRole().isBlank()) {
            userRequestDTO.setRole(String.valueOf(Role.STUDENT));
        }
        User newUser = modelMapper.map(userRequestDTO , User.class);
        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser , UserResponseDTO.class);
    }

    // ✅ Get single user
    @Override
    public UserResponseDTO getUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return modelMapper.map(existingUser , UserResponseDTO.class);
    }

    // ✅ Get all users
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> listOfUsers = new ArrayList<>();
        for (User user : users) {
            listOfUsers.add(modelMapper.map(user, UserResponseDTO.class));
        }
        return listOfUsers;
    }

    // ✅ Update user
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        // Map request DTO fields to existing entity
        modelMapper.map(userRequestDTO, existingUser);

        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

    // ✅ Delete user
    @Override
    public String deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(existingUser);
        return "User deleted with id " + id;
    }
}
