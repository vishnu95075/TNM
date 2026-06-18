package com.tns.user.service.impl;

import com.tns.user.entity.UserProfile;
import com.tns.user.exception.UserAlreadyExistsException;
import com.tns.user.repository.UserRepository;
import com.tns.user.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserProfile createUser(UserProfile user) {
        boolean isUserExit = userRepository.existsById(user.getUserName());
        if(isUserExit){
            throw new UserAlreadyExistsException("User already exit Exit: " + user.getUserName());
        }
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userName) {
       userRepository.deleteById(userName);
    }

    @Override
    public UserProfile updateUser(UserProfile user) {
        String id = user.getUserName();
        UserProfile user1 = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Can not found by id "+id));
      return  userRepository.save(user);
    }
}
