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
    private final ImageUploadService imageUploadService;

    public UserController(IUserService userService, ImageUploadService imageUploadService) {
        this.userService = userService;
        this.imageUploadService = imageUploadService;

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

    @DeleteMapping("/{userName}")
    public String deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
        return "User Successfully Delete";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = imageUploadService.uploadImage(file);

            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

    }
    @PatchMapping("avatar/{userName}")
    public ResponseEntity<?> uploadProfilePic(@PathVariable String userName,@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = imageUploadService.uploadImage(file);
           int flag = userService.findByIdUpdateProfilePicUrl(userName,imageUrl);
           if(flag==0){
               return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profile pic has not updated");
           }
            return ResponseEntity.status(HttpStatus.OK).body("Profile pic updated successful");
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

    }


}
