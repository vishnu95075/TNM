package com.tns.user.service.impl;

import com.tns.user.config.JwtService;
import com.tns.user.entity.UserProfile;
import com.tns.user.exception.ResourceNotFoundException;
import com.tns.user.exception.UserAlreadyExistsException;
import com.tns.user.repository.UserRepository;
import com.tns.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;


    public UserServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserProfile createUser(UserProfile user) {
        boolean isUserExit = userRepository.existsById(user.getUserName());
        if (isUserExit) {
            throw new UserAlreadyExistsException("User already exit Exit: " + user.getUserName());
        }

        return userRepository.save(user);
    }

    @Override
    public UserProfile getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "UserProfile", id));
    }

    @Override
    public UserProfile getUserProfileByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public int findByIdUpdateProfilePicUrl(String username, String profileUrl) {
        boolean isUserExit = userRepository.existsById(username);
        if (isUserExit) {
            throw new UserAlreadyExistsException("User already exit Exit: " + username);
        }

        return userRepository.updateProfilePicUrl(username, profileUrl);
    }

    @Override
    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }

    @Override
    public UserProfile updateUser(UserProfile user) {
        String id = user.getUserName();
        UserProfile user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Can not found by id " + id));
        return userRepository.save(user);
    }

    @Override
    public UserProfile getUserProfileByToken(String token) {
        String id = jwtService.extractUserId(token);
        System.out.println("id "+id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "UserProfile", id));
    }
}
