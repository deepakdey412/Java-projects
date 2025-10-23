package com.ddey.user_management_system.service;

import com.ddey.user_management_system.entity.User;
import com.ddey.user_management_system.exception.UserNotFoundException;
import com.ddey.user_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
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
