package com.tns.user.controller;

import com.tns.user.entity.UserProfile;
import com.tns.user.service.IUserService;
import com.tns.user.service.ImageUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;
    private final ImageUploadService service;

    public UserController(IUserService userService, ImageUploadService service) {
        this.userService = userService;
        this.service = service;
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
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = service.uploadImage(file);

            return ResponseEntity.ok(
                    new UploadResponse(imageUrl)
            );
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

    }


    record UploadResponse(String url) {
    }


}
