package com.tns.user.controller;

import com.tns.user.entity.User;
import com.tns.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
     private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping
    public User registerUser(@RequestBody User user){
        System.out.println("hello Its work Create user");
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Successfully Delete";
    }

    // Authentication
        @GetMapping("/user-profile")
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public String getUserProfile() {
            return "Accessible by logged-in mobile users.";
        }


}
