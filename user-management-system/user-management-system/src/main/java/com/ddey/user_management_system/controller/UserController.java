package com.ddey.user_management_system.controller;

import com.ddey.user_management_system.entity.User;
import com.ddey.user_management_system.service.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

@RestController
@RequestMapping(path = "/user-api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    public User create(@RequestBody  User user){
        return userService.createUser(user);
    }
    public Optional<User> getUserByid(@PathVariable Long id){
        return userService.getUser(id);
    }
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    public User update(@PathVariable Long id , @RequestBody User user){
        return userService.updateUser(id, user);
    }
    public String delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
