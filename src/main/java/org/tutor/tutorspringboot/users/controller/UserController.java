package org.tutor.tutorspringboot.users.controller;

import org.springframework.web.bind.annotation.*;
import org.tutor.tutorspringboot.users.dto.CreateUserDto;
import org.tutor.tutorspringboot.users.entity.User;
import org.tutor.tutorspringboot.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto.getFullName(), createUserDto.getEmail());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
