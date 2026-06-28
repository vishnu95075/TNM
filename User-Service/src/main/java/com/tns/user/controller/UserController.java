package com.tns.user.controller;

import com.tns.user.entity.UserProfile;
import com.tns.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserProfile> getUser(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }



    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        System.out.println("Create " + user);
        System.out.println("hello Its work Create user");
        return userService.createUser(user);
    }

    @PutMapping
    public UserProfile updateUser(@RequestBody UserProfile user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
        return "User Successfully Delete";
    }

//    // Authentication
//    @GetMapping("/user-profile")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
//    public String getUserProfile() {
//        return "Accessible by logged-in mobile users.";
//    }
//

}
