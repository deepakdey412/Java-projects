package com.ddey.user_management_system.service;

import com.ddey.user_management_system.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUser(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    String deleteUser(Long id);

}
