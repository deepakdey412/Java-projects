package com.ddey.user_management_system.controller;

import com.ddey.user_management_system.entity.User;
import com.ddey.user_management_system.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user-api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // ✅ 1. Create User
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // 201 Created
    }

    // ✅ 2. Get User by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User foundUser = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundUser);
    }

    // ✅ 3. Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }

    // ✅ 4. Update User
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
        User updatedUser  = userService.updateUser(id , user);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
    }

    // ✅ 5. Delete User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String notify = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(notify);
    }
}
