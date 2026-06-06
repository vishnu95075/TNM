package com.tns.user.controller;

import com.tns.user.entity.UserEntity;
import com.tns.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        System.out.println("hello Its work Create user");
        return userService.createUser(user);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Successfully Delete";
    }

}
